package com.chris.pisco.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

/**
 * Created by chris on 2018/2/7.
 */

public class PiscoObject {

    private ImageView view;
    private String url;
    private Bitmap bitmap;
    private Options options;
    private OnPiscoListener listener;

    public PiscoObject(ImageView view, String url, OnPiscoListener listener) {
        this.view = view;
        this.url = url;
        this.listener = listener;
        if (view != null && !TextUtils.isEmpty(url)) {
            this.view.setTag(url);
        }
    }

    public PiscoObject(ImageView view, String url, Options options, OnPiscoListener listener) {
        this(view, url, listener);
        this.options = options;
    }

    public ImageView getView() {
        return view;
    }

    public void setView(ImageView view) {
        this.view = view;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public OnPiscoListener getListener() {
        return listener;
    }

    public void setListener(OnPiscoListener listener) {
        this.listener = listener;
    }
}
