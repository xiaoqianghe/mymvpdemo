package com.suirenshi.mymvpdemo.Http;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.suirenshi.mymvpdemo.Utils.NetworkUtils;
import com.suirenshi.mymvpdemo.app.MyMvpApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @包名: com.suirenshi.mymvpdemo.Http
 * @类名: OkHttpHelper 网络请求封装类
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/3/2 10:53
 * @描述 : TODO
 */

public class OkHttpHelper {
    private static OkHttpClient okHttpClient;
    private static OkHttpHelper mIntance;
    private static Gson gson;
    private Handler handler;

    private Request request;
    private OkHttpHelper(){
//        okHttpClient=new OkHttpClient();
//        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
//        okHttpClient.setWriteTimeout(10, TimeUnit.SECONDS);
//        okHttpClient.setReadTimeout(30, TimeUnit.SECONDS);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();


        //设置一些超时时间
        gson=new Gson();
        handler=new Handler(Looper.getMainLooper());

    }


    public  static synchronized OkHttpHelper getInstance(){
        if(null==mIntance){
            mIntance=new OkHttpHelper();
        }
        return mIntance;
    }




    public void get(String url,BaseCallback callback){
        request=buildJsonRequest(url, null, HttpMethodType.GET);
        doRequets(request,callback);

    }


//    public void post(String url,Map<String,String> params,BaseCallback callback){
//        Request request=buildRequest(url,params,HttpMethodType.POST);
//        doRequets(request, callback);
//    }


    private void doRequets(Request request, final BaseCallback callback){
        //这里需要校验一下网络状态
        if(!NetworkUtils.isNetworkConnected(MyMvpApplication.getContext())){

        }else {
            callback.onRequestBefore(request);
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    callback.onFailure(call, e);
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    //callback.onResponse(response);
                    if (response.isSuccessful()) {
                        String resultStr = response.body().string();
                        if (callback.type == String.class) {
                            // callback.onSuccess(response,resultStr);
                            callback.onSuccessResponse(response);
                            callbackSuccess(callback, response, resultStr);
                        } else {
                            try {
                                Object object = gson.fromJson(resultStr, callback.type);
                                // callback.onSuccess(response, object);
                                callback.onSuccessResponse(response);
                                callbackSuccess(callback, response, object);
                            } catch (JsonSyntaxException e) {
                                callback.onErrorResponse(response);
                                callbackError(callback, response, response.code(), e);
                            }
                        }
                    } else {
                        callback.onErrorResponse(response);
                        callbackError(callback, response, response.code(), null);
                    }
                }
            });
        }
    }



//
//    private Request buildRequest(String url,Map<String,String> params,HttpMethodType httpMethodType){
//        Request.Builder build=new Request.Builder();
//        build.url(url);
//        if(httpMethodType==HttpMethodType.GET){
//            build.get();
//        }else if(httpMethodType==HttpMethodType.POST){
//            RequestBody body=buildFormData(params);
//            build.post(body);
//        }
//        return build.build();
//    }

//
//    /**
//     * @todo: 构建RequestBody
//     *
//     * */
//    public  RequestBody buildFormData(Map<String,String> params){
//        FormBody.Builder body=new FormBody.Builder();
//        if(null!=params){
//            for(Map.Entry<String,String> entry:params.entrySet()){
//                body.add(entry.getKey(),entry.getValue());
//            }
//            return body.build();
//        }
//        return body.build();
//    }
//



    public void postJson(String url,String json,BaseCallback callback){
        request=buildJsonRequest(url,json,HttpMethodType.POST);

        doRequets(request, callback);
    }



    /**
     * @todo: 构建关于Json的Post的Request请求
     *
     * */
    private Request buildJsonRequest(String url,String json,HttpMethodType httpMethodType){
        Request.Builder build=new Request.Builder();
        build.url(url);
        if(httpMethodType==HttpMethodType.GET){
            build.get();
        }else if(httpMethodType==HttpMethodType.POST){
            RequestBody body=buildJsonData(json);
            build.post(body);
        }
        return build.build();
    }


    /**
     * @todo: 构建关于Json的RequestBody
     *
     * */
    public  RequestBody buildJsonData(String josn){
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body=RequestBody.create(JSON,josn);

        return body;
    }



































    enum HttpMethodType{
        GET,
        POST
    }


    private void callbackSuccess(final BaseCallback callback, final Response response, final Object object){
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(response,object);
            }
        });
    }

    private void callbackError(final BaseCallback callback,final Response response, final int code, final Exception e){
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(response,code,e);
            }
        });
    }










}
