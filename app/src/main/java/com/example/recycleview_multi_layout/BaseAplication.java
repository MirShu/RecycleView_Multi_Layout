package com.example.recycleview_multi_layout;

import android.app.Application;

import org.xutils.x;

public class BaseAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
