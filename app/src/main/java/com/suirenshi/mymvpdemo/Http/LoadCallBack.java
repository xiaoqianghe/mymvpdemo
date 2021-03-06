package com.suirenshi.mymvpdemo.Http;

import com.suirenshi.mymvpdemo.base.BaseViewInterface;

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


    private BaseViewInterface mView;
    private boolean successIsDismiss=true;

    private void showDialog(){
        mView.showLoadingView("加载中...");
    }

    private void dismissDialog(){
        mView.dissmissLoadingView();
    }




    public LoadCallBack(BaseViewInterface mView) {
        this.mView=mView;

    }
    public LoadCallBack(BaseViewInterface mView,boolean successIsDismiss) {
        this.mView=mView;
        this.successIsDismiss=successIsDismiss;

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
        return mView.IsNetConnected();
    }

    @Override
    public void onErrorResponse(Response response) {
        dismissDialog();
    }

    @Override
    public void onSuccessResponse(Response response) {
        if(successIsDismiss) {
            dismissDialog();
        }
    }



}
