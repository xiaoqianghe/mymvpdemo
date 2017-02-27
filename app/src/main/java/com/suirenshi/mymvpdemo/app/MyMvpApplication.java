package com.suirenshi.mymvpdemo.app;

import android.app.Application;

import com.bq2015.oknet.OkHttpUtils;

/**
 * @包名: com.suirenshi.mymvpdemo.app
 * @类名: MyMvpApplication
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/2/27 16:02
 * @描述 : TODO
 */

public class MyMvpApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        initOkhttps();

    }

    private void initOkhttps() {
        OkHttpUtils.init(this);
        OkHttpUtils.getInstance().setConnectTimeout(80000);
    }
}
