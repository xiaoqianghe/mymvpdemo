package com.suirenshi.mymvpdemo.presenter;

import android.os.Handler;

import com.suirenshi.mymvpdemo.biz.OnRequestListener;
import com.suirenshi.mymvpdemo.biz.RequestBiz;
import com.suirenshi.mymvpdemo.view.MvpView;

import java.util.List;


/**
 * @包名: com.suirenshi.mymvpdemo.presenter
 * @类名: MvpParsenter
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 12:07
 * @描述 : TODO P层 关于View层的业务逻辑操作
 */

public class MvpParsenter {

    private MvpView mvpView;

    RequestBiz requestBiz;
    private Handler mHandler;

    public MvpParsenter(MvpView mvpView) {
        this.mvpView = mvpView;
    }

    public void onResume(){
        mvpView.showLoadingDialog();
        requestBiz.requestData(new OnRequestListener() {
            @Override
            public void onSuccess(final List<String> data) {
                //由于请求开启了新线程，所以用handler去更新界面
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mvpView.hideLoadingDialog();
                        mvpView.setListItem(data);
                    }
                });
            }

            @Override
            public void onFailed() {
                mvpView.showMessage("请求失败");

            }
        });


    }

    public void onItemClick(int position){
        mvpView.showMessage("点击了Item的"+position);

    }

    public void onDestroy(){
        mvpView=null;
    }
}
