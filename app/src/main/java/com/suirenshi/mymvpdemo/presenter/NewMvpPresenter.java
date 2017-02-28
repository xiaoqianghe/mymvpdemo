package com.suirenshi.mymvpdemo.presenter;

import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bq2015.bqhttp.event.BQNetEvent;
import com.bq2015.bqhttp.net.OnBQNetEventListener;
import com.suirenshi.mymvpdemo.biz.RequestBiz;
import com.suirenshi.mymvpdemo.common.NetTest;
import com.suirenshi.mymvpdemo.modul.login.AuthenticateBean;
import com.suirenshi.mymvpdemo.view.NewMvpView;

import io.realm.Realm;

/**
 * @包名: com.suirenshi.mymvpdemo.presenter
 * @类名: NewMvpPresenter
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 15:51
 * @描述 : TODO
 */

public class NewMvpPresenter extends BaseParsenter<NewMvpView> {
    private final String TAG = "NewMvpPresenter";

    private RequestBiz requestBiz;
    private Handler mHandler;
    private Realm realm;

    public NewMvpPresenter() {

        realm = Realm.getDefaultInstance();

    }






    /**
     * @todo: 登录请求
     *
     * */
   public void toLogin(String phone,String password){

       //http://192.168.1.105:8002/srs-mobile/v3/auth/login
       mView.showLoadingView("登录中...");

       Log.d(TAG,"============================authenticate ::http://192.168.1.105:8002/srs-mobile/v3/auth/authenticate");
       NetTest.get(phone, password).getAuthenticate()
               .showProgress(mView,"正在加载中...")

               .execute(new OnBQNetEventListener() {
                   @Override
                   public void netRequestSuccess(BQNetEvent event) {
                       String authenticateString = event.getNetResult();
                       AuthenticateBean authenticate = JSON.parseObject(authenticateString, AuthenticateBean.class);

                       Log.d(TAG, "============================authenticate ::" + JSON.toJSON(authenticate));

                       mView.showMessage("登录成功！");

                       mView.setLoginShowData(authenticate);


                   }

                   @Override
                   public boolean netRequestFail(BQNetEvent event) {

                       mView.showMessage("登录失败！");
                       return false;
                   }
               });
   }


//    public void loadPrintIp(int apiKey, int branchNo, int start, int size){
//
//        NetTest.get().getPrintList(apiKey,branchNo,start,size)
//                .showProgress(mView)
//                .execute(new OnBQNetEventListener() {
//                    @Override
//                    public void netRequestSuccess(BQNetEvent event) {
//                        String authenticateString = event.getNetResult();
//                        PrintStyleInfo mPrintStyleInfo = JSON.parseObject(authenticateString, PrintStyleInfo.class);
//                        if(null!=mPrintStyleInfo&&mPrintStyleInfo.getPrintingStyle().size()>0){
//                            PrintingStyleSQL.save(realm, mPrintStyleInfo.getPrintingStyle());
//                        }
//
//
//                    }
//
//                    @Override
//                    public boolean netRequestFail(BQNetEvent event) {
//                        return false;
//                    }
//                });
//
//
//    }






}
