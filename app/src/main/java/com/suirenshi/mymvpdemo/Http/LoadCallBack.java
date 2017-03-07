package com.suirenshi.mymvpdemo.Http;

import com.bq2015.oknet.modeinterface.INetView;
import com.suirenshi.mymvpdemo.Utils.NetworkUtils;
import com.suirenshi.mymvpdemo.app.MyMvpApplication;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @包名: com.suirenshi.mymvpdemo.Http
 * @类名: LoadCallBack
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/3/7 11:41
 * @描述 : TODO
 */

public abstract class LoadCallBack<T> extends BaseCallback<T> {


    private INetView mView;

    private void showDialog(){
        mView.showLoadingView("加载中...");
    }

    private void dismissDialog(){
        mView.dissmissLoadingView();
    }




    public LoadCallBack(INetView mView) {
        this.mView=mView;

    }


    @Override
    public void onRequestBefore(Request request) {
        //这里需要校验一下网络

        if(checkNetConnected()){
            showDialog();
        }


    }

    @Override
    public void onFailure(Call call, IOException e) {
        dismissDialog();

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
        boolean isConnected = NetworkUtils.isNetworkConnected(MyMvpApplication.getContext());
        if (!isConnected) {
//            Toast.makeText(mContext, "网络异常...", Toast.LENGTH_SHORT).show();
//            Log.e(TAG, "===网络异常...");
            mView.showMessage("网络异常");
        }
        return isConnected;
    }



}
