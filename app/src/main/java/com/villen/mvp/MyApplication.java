package com.villen.mvp;

import android.app.Application;

import com.villen.mvp.util.SPUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SPUtil.init(this);
    }
}
