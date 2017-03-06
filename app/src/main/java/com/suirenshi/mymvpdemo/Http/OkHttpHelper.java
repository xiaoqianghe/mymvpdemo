package com.suirenshi.mymvpdemo.Http;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
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

    private OkHttpHelper(){
        okHttpClient=new OkHttpClient();

        //设置一些超时时间
        gson=new Gson();
        handler=new Handler(Looper.getMainLooper());

    }


    private static synchronized OkHttpHelper getInstance(){
        if(null==mIntance){
            mIntance=new OkHttpHelper();
        }
        return mIntance;
    }




    public void get(String url,BaseCallback callback){
        Request request=buildRequest(url,null,HttpMethodType.GET);
        doRequets(request,callback);

    }


    public void post(String url,Map<String,String> params,BaseCallback callback){

        Request request=buildRequest(url,params,HttpMethodType.POST);
        doRequets(request,callback);

    }


    private void doRequets(Request request, final BaseCallback callback){
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(call,e);


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                /**
                 *
                 *
                 *
                 * */

                if(response.isSuccessful()){

                    String resultStr=response.body().string();
                    if(callback.type==String.class){
                       // callback.onSuccess(response,resultStr);
                        callbackSuccess(callback,response,resultStr);
                    }else {

                        try{
                            Object object=gson.fromJson(resultStr,callback.type);
                           // callback.onSuccess(response, object);
                            callbackSuccess(callback,response,object);
                        }catch (JsonSyntaxException e){
                            callbackError(callback, response, response.code(), e);
                        }

                    }

                }else{

                    callbackError(callback,response,response.code(),null);

                }

            }
        });

    }




    private Request buildRequest(String url,Map<String,String> params,HttpMethodType httpMethodType){
        Request.Builder build=new Request.Builder();
        build.url(url);

        if(httpMethodType==HttpMethodType.GET){

            build.get();

        }else if(httpMethodType==HttpMethodType.POST){
            RequestBody body=buildFormData(params);
            build.post(body);
        }


        return null;


    }


    private RequestBody buildFormData(Map<String,String> params){

        if(null!=params){
            for(Map.Entry<String,String> entry:params.entrySet()){


            }

        }



        return null;




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
