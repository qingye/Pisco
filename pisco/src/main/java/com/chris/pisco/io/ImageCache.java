package com.chris.pisco.io;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.chris.pisco.io.base.BaseFile;
import com.chris.pisco.util.MDigest5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by chris on 2018/2/7.
 */

public class ImageCache extends BaseFile {

    private final String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
    private final String PISCO_IMAGE_PATH_DIR = SDCARD + "/pisco";

    public ImageCache() {
        removeCache(PISCO_IMAGE_PATH_DIR);
    }

    /***********************************************************************************************
     * Image By URL
     ***********************************************************************************************/
    public Bitmap getImageByUrl(final String url) {
        return getImageFile(PISCO_IMAGE_PATH_DIR + "/" + urlToFileName(url));
    }

    /***********************************************************************************************
     * Save Image By URL
     ***********************************************************************************************/
    public boolean saveImageByUrl(Bitmap bm, String url) {
        return saveImageFile(bm, urlToFileName(url));
    }

    /***********************************************************************************************
     * URL to name
     ***********************************************************************************************/
    private String urlToFileName(String url) {
        return MDigest5.MD5(url);
    }

    /***********************************************************************************************
     * Save Image File
     ***********************************************************************************************/
    private boolean saveImageFile(Bitmap bm, String filename) {
        boolean result = false;
        if (bm == null || bm.isRecycled() || !isEnoughSpace()) {
            return result;
        }

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File dir = new File(PISCO_IMAGE_PATH_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(dir, filename);
            try {
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                if (bm.compress(Bitmap.CompressFormat.PNG, 100, fos)) {
                    fos.flush();
                }
                fos.close();
                result = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /***********************************************************************************************
     * Get Image File
     ***********************************************************************************************/
    private Bitmap getImageFile(final String path) {
        Bitmap bm = null;
        File file = new File(path);
        if (file.exists()) {
            bm = BitmapFactory.decodeFile(path);
            if (bm == null) {
                file.delete();
            } else {
                updateFileLastTime(path);
            }
        }

        return bm;
    }
}
