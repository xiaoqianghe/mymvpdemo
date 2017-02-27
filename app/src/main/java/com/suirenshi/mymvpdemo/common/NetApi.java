package com.suirenshi.mymvpdemo.common;


import com.bq2015.bqhttp.net.NetRequest;
import com.bq2015.oknet.modeinterface.annotation.GET;

/**
 * Created by KyLin on 2016/6/30
 *
 * 这里是关于url的接口
 *
 */
public interface NetApi {


    @GET("http://www.sina.com.cn/")
    NetRequest<String> testNet();



    //https://104.236.194.90:8443/pmt-jfpayment-1.3-SNAPSHOT/v3/auth/authenticate
    @GET("v3/auth/authenticate")
    NetRequest<String> getAuthenticate();



}

