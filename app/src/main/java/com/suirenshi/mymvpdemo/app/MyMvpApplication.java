package com.suirenshi.mymvpdemo.app;

import android.app.Application;
import android.content.Context;

import com.bq2015.oknet.OkHttpUtils;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * @包名: com.suirenshi.mymvpdemo.app
 * @类名: MyMvpApplication
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/2/27 16:02
 * @描述 : TODO
 */

public class MyMvpApplication extends Application{

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext=this;

        initOkhttps();
        initRealm();

    }

    private void initOkhttps() {
        OkHttpUtils.init(this);
        OkHttpUtils.getInstance().setConnectTimeout(80000);
    }

    private void initRealm(){
        Realm.init(this);
        RealmConfiguration realmConfiguration=new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
    public static Context getContext()
    {
        return mContext;
    }





}
