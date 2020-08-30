package com.lilo.museboxapp;

import android.app.Application;
import android.content.Context;

public class MuseBoxApplication extends Application {

    static public Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
