package com.chris.pisco.model.processer;

import android.graphics.Bitmap;

/**
 * Created by chris on 2018/2/8.
 */

public class CenterCorpProcesser extends AbsBitmapProcesser {

    public CenterCorpProcesser() {
    }

    public CenterCorpProcesser(int targetWidth, int targetHeight) {
        super(targetWidth, targetHeight);
    }

    @Override
    public Bitmap process(Bitmap bitmap) {
        if (targetWidth <= 0) {
            targetWidth = bitmap.getWidth();
        }
        if (targetHeight <= 0) {
            targetHeight = bitmap.getHeight();
        }

        Bitmap bm = null;
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                bm = centerCorp(scale(bitmap));
            } catch (Exception e) {
                e.printStackTrace();
                bm = bitmap;
            } finally {
                System.gc();
            }
        }
        return bm;
    }
}
