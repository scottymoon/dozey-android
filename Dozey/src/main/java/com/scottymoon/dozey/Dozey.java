package com.scottymoon.dozey;

import android.app.Application;

public class Dozey extends Application {
    private static Dozey mSingleton;

    @Override
    public void onCreate() {
        super.onCreate();
        mSingleton = this;
    }

    public static Dozey getInstance() {
        return mSingleton;
    }

}
