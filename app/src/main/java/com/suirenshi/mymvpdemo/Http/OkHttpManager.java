package com.suirenshi.mymvpdemo.Http;

/**
 * @包名: com.suirenshi.mymvpdemo.Http
 * @类名: OkHttpManager
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/3/2 10:53
 * @描述 : TODO
 */

public class OkHttpManager {


    private static OkHttpManager mInstance;


    private static synchronized OkHttpManager getInstance(){

        if(null==mInstance){
            mInstance=new OkHttpManager();

        }

        return mInstance;

    }




}
