package com.suirenshi.mymvpdemo.Http;

import android.content.Context;

import java.io.IOException;

import dmax.dialog.SpotsDialog;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @包名: com.suirenshi.mymvpdemo.Http
 * @类名: SpotsCallBack
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/3/6 20:35
 * @描述 : TODO
 */

public abstract class SpotsCallBack<T> extends BaseCallback<T> {




    SpotsDialog spotsDialog;

    public SpotsCallBack(Context mContext) {
        spotsDialog=new SpotsDialog(mContext);
    }

    private void showDialog(){
        spotsDialog.show();
    }

    private void dismissDialog(){
        spotsDialog.dismiss();
    }

    private void setDialogMessage(String message){
        spotsDialog.setMessage(message);

    }


    @Override
    public void onRequestBefore(Request request) {
        showDialog();

    }

    @Override
    public void onFailure(Call call, IOException e) {
        dismissDialog();

    }

//    @Override
//    public void onSuccess(Response response, Object o) {
//
//    }
//
//    @Override
//    public void onError(Response response, int code, Exception e) {
//
//    }

    @Override
    public void onResponse(Response response) {
        dismissDialog();
    }
}
