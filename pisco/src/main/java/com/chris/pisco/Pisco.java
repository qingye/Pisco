package com.chris.pisco;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import com.chris.pisco.io.ImageCache;
import com.chris.pisco.memory.MemoryCache;
import com.chris.pisco.model.OnPiscoListener;
import com.chris.pisco.model.Options;
import com.chris.pisco.model.PiscoObject;
import com.chris.pisco.model.processer.BitmapProcessor;
import com.chris.pisco.net.Http;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chris on 2018/2/7.
 */

public enum Pisco {
    INSTANCE;

    private static final int nThreadPoolSize = 3;
    private static ExecutorService mExecutorService = Executors.newFixedThreadPool(nThreadPoolSize);

    private ImageCache imageCache;
    private MemoryCache memoryCache;

    Pisco() {
    }

    public void init(Context context) {
        imageCache = new ImageCache();
        memoryCache = new MemoryCache(context);
    }

    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    PiscoObject object = (PiscoObject) msg.obj;
                    if (object != null) {
                        ImageView view = object.getView();
                        String url = object.getUrl();
                        OnPiscoListener listener = object.getListener();
                        Bitmap bitmap = object.getBitmap();

//                        Log.e("chris", "view.tag = " + view.getTag() + ", url = " + url + ", bitmap = " + bitmap);

                        if (view != null && view.getTag().equals(url) && bitmap != null && !bitmap.isRecycled()) {
                            view.setImageBitmap(bitmap);
                        } else if (bitmap.isRecycled()){
                            Log.e("chris", "rec.view = " + view);
                        }
                    }
                    break;

                case 1:
                    mExecutorService.execute(new LoadRunnable(msg.obj));
                    break;

                default:
                    break;
            }
        }
    };

    private class LoadRunnable implements Runnable {

        private PiscoObject object;

        public LoadRunnable(Object o) {
            this.object = (PiscoObject) o;
        }

        @Override
        public void run() {
            if (object == null) {
                return;
            }

            String url = object.getUrl();
            Bitmap bm = memoryCache.getBitmapFromCache(url);
            if (bm == null || bm.isRecycled()) {
                bm = imageCache.getImageByUrl(url);
                if (bm == null) {
                    bm = new Http().getImageByUrl(url);
                    imageCache.saveImageByUrl(bm, url);
                }

                if (bm != null) {
                    memoryCache.addBitmapToCache(url, bm);
                }
            }

            Options options = object.getOptions();
            if (options != null && options.getProcessor() != null && object.getView().getTag().equals(object.getUrl())) {
                ImageView view = object.getView();
                BitmapProcessor processor = options.getProcessor();
                bm = processor.setTargetWidth(view.getWidth(), view.getHeight()).process(bm);
            }

            if (bm != null && !bm.isRecycled()) {
                object.setBitmap(bm);
                handler.sendMessage(handler.obtainMessage(0, object));
            }
        }
    }

    public void load(ImageView view, String url, OnPiscoListener listener) {
        handler.sendMessage(handler.obtainMessage(1, new PiscoObject(view, url, listener)));
    }
    public void load(ImageView view, String url, Options options, OnPiscoListener listener) {
        handler.sendMessage(handler.obtainMessage(1, new PiscoObject(view, url, options, listener)));
    }
}
