package com.chris.pisco.model.processer;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by chris on 2018/2/8.
 */

public abstract class AbsBitmapProcesser implements BitmapProcessor {

    protected int targetWidth = -1;
    protected int targetHeight = -1;

    public AbsBitmapProcesser() {
    }

    public AbsBitmapProcesser(int targetWidth, int targetHeight) {
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
    }

    public AbsBitmapProcesser setTargetWidth(int targetWidth, int targetHeight) {
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        return this;
    }

    /***********************************************************************************************
     * Auto scale by target width & height
     ***********************************************************************************************/
    protected Bitmap scale(Bitmap src) throws Exception {
        float widthScale = (float) targetWidth / (float) src.getWidth();
        float heightScale = (float) targetHeight / (float) src.getHeight();
        float srcRatio = (float) src.getWidth() / (float) src.getHeight();
        float targetRatio = (float) targetWidth / (float) targetHeight;

        boolean ret = targetRatio > srcRatio;
        Bitmap bitmap = null;
        if (ret) {
            bitmap = widthScale == 1.0f ? src : scale(src, widthScale, widthScale);
        } else {
            bitmap = heightScale == 1.0f ? src : scale(src, heightScale, heightScale);
        }
        return bitmap;
    }

    /***********************************************************************************************
     * Scale by given width & height
     ***********************************************************************************************/
    protected Bitmap scale(Bitmap src, float scaleWidth, float scaleHeight) throws Exception {
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = src;
        }
        return bitmap;
    }

    /***********************************************************************************************
     * Clip bitmap
     ***********************************************************************************************/
    protected Bitmap centerCorp(Bitmap src) throws Exception {
        if (targetWidth > src.getWidth()) {
            targetWidth = src.getWidth();
        }
        if (targetHeight > src.getHeight()) {
            targetHeight = src.getHeight();
        }

        Bitmap bitmap = Bitmap.createBitmap(src, Math.abs(src.getWidth() - targetWidth) / 2,
                Math.abs(src.getHeight() - targetHeight) / 2, targetWidth, targetHeight, null, false);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = src;
        }
        return bitmap;
    }
}
