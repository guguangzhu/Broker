package com.toda.broker.app;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by guugangzhu on 2016/9/23.
 */

public class BrokerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
