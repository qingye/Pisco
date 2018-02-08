package com.chris.pisco.model.processer;

import android.graphics.Bitmap;

/**
 * Created by chris on 2018/2/8.
 */

public interface BitmapProcessor {

    BitmapProcessor setTargetWidth(int targetWidth, int targetHeight);

    /**
     * @param bitmap Original
     * @return new one that after process
     */
    Bitmap process(Bitmap bitmap);
}
