package com.suirenshi.mymvpdemo.Http;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @包名: com.suirenshi.mymvpdemo.Http
 * @类名: BaseCallback
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/3/6 19:40
 * @描述 : TODO
 */

public abstract class BaseCallback<T>{

    public Type type;



    static Type getSuperclassTypeParameter(Class<?> subclass){

        Type superclass=subclass.getGenericSuperclass();
        if(superclass instanceof  Class){
            throw new RuntimeException("Miss type parameter .");
        }
        ParameterizedType parameteried=(ParameterizedType)superclass;
       // return $Gson$Types.canonicalize(parameteried.getActualTypeArguments()[0]);
        return parameteried.getActualTypeArguments()[0];

    }

    public BaseCallback(){


        type= getSuperclassTypeParameter(this.getClass());

    }





    public abstract void onRequestBefore(Request request);

    public abstract void onFailure(Call call, IOException e);
    public abstract void onSuccess(Response response,T t);

    public abstract void onError(Response response,int code,Exception e);

    public abstract void onResponse(Response response);


}
