package com.chris.pisco.demo;

import android.app.Application;

import com.chris.pisco.Pisco;

/**
 * Created by chris on 2018/2/7.
 */

public class PiscoDemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Pisco.INSTANCE.init(getApplicationContext());
    }
}
