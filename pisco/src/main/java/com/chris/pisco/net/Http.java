package com.chris.pisco.net;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * Created by chris on 2018/2/7.
 */

public class Http {

    private OkHttpClient client;

    public Http() {
        client = new OkHttpClient();
    }

    public Bitmap getImageByUrl(String url) {
        Bitmap bm = null;
        try {
            ResponseBody body = client.newCall(new Request.Builder().url(url).build()).execute().body();
            if (body != null) {
                bm = preProcess(streamToArray(body.byteStream()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bm;
    }

    private byte[] streamToArray(InputStream is) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = is.read(buff)) != -1) {
            bos.write(buff, 0, len);
        }
        is.close();
        bos.close();
        return bos.toByteArray();
    }

    private Bitmap preProcess(byte[] data) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);

        int inSampleSize = 1;
        int count = options.outWidth * options.outHeight * 4;
        while (count > 1.5f * 1024 * 1024) {
            inSampleSize *= 2;
            count /= (inSampleSize * inSampleSize);
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = inSampleSize;
        options.inPreferredConfig = Bitmap.Config.ARGB_4444;
        bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
        return bitmap;
    }
}
