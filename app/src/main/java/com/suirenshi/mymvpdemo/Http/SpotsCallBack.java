package com.suirenshi.mymvpdemo.Http;

import android.content.Context;
import android.widget.Toast;

import com.suirenshi.mymvpdemo.Utils.NetworkUtils;
import com.suirenshi.mymvpdemo.widght.LoadDataDialog;

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

    private final String TAG = "SpotsCallBack";




    SpotsDialog spotsDialog;
    private static LoadDataDialog mLoadDataDialog;
    private static  Context mContext;

    public SpotsCallBack(Context mContext) {
        this.mContext=mContext;
        if(null!=mContext){
//            spotsDialog=new SpotsDialog(mContext);
            mLoadDataDialog=new LoadDataDialog(mContext);
        }

    }

    private void showDialog(){
        mLoadDataDialog.show();
        setDialogMessage("加载中");
    }

    private void dismissDialog(){
        mLoadDataDialog.dismiss();
    }

    private void setDialogMessage(String message){
        mLoadDataDialog.setMessage(message);
    }


    @Override
    public void onRequestBefore(Request request) {
        //这里需要校验一下网络
        showDialog();
    }

    @Override
    public void onFailure(Call call, IOException e) {
        dismissDialog();
        Toast.makeText(mContext,"网络异常...",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onResponse(Response response) {
        dismissDialog();
    }


    /**
     * 判断网络是否已连接，如果未连接则提示用户
     *
     * @return
     */
    protected boolean checkNetConnected() {
        boolean isConnected = NetworkUtils.isNetworkConnected(mContext);
        if (!isConnected) {
            Toast.makeText(mContext,"网络异常...",Toast.LENGTH_SHORT).show();
        }
        return isConnected;
    }

    @Override
    public void onErrorResponse(Response response) {

        dismissDialog();

    }

    @Override
    public void onSuccessResponse(Response response) {

            dismissDialog();


    }

}
