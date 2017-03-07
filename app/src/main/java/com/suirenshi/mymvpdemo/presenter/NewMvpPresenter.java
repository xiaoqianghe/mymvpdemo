package com.suirenshi.mymvpdemo.presenter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bq2015.bqhttp.event.BQNetEvent;
import com.bq2015.bqhttp.net.OnBQNetEventListener;
import com.google.gson.Gson;
import com.suirenshi.mymvpdemo.Http.LoadCallBack;
import com.suirenshi.mymvpdemo.Http.OkHttpHelper;
import com.suirenshi.mymvpdemo.Http.SpotsCallBack;
import com.suirenshi.mymvpdemo.biz.RequestBiz;
import com.suirenshi.mymvpdemo.common.NetTest;
import com.suirenshi.mymvpdemo.modul.LoginBean;
import com.suirenshi.mymvpdemo.modul.LoginInfo;
import com.suirenshi.mymvpdemo.modul.login.AuthenticateBean;
import com.suirenshi.mymvpdemo.view.NewMvpView;

import io.realm.Realm;
import okhttp3.Response;

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
    private Context mContext;

    public NewMvpPresenter(Context mContext) {
        this.mContext=mContext;

        realm = Realm.getDefaultInstance();

    }






    /**
     * @todo: 登录请求
     *
     * */
   public void toLogin(String phone,String password){
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




    /**
     *
     * @todo: 新封装的Get请求
     *
     * */

    public void toNewGet(){
        String url="";
        OkHttpHelper.getInstance().get(url, new SpotsCallBack<LoginBean>(mContext) {
            @Override
            public void onSuccess(Response response, LoginBean mLoginBean) {

            }

            @Override
            public void onError(Response response, int code, Exception e) {

            }
        });



    }

    /**
     * @todo: 新封装的OkHttp3的Pos请求的
     *
     *
     * */
    public void toNewPost(){
        String url="http://192.168.1.105:8002/srs-mobile/v3/auth/login2";
        LoginInfo mLoginInfo=new LoginInfo();
        mLoginInfo.setPassword("123456");
        mLoginInfo.setUsername("177000000033");
        OkHttpHelper.getInstance().postJson(url, new Gson().toJson(mLoginInfo), new SpotsCallBack<AuthenticateBean>(mContext) {
            @Override
            public void onSuccess(Response response, AuthenticateBean mAuthenticateBean) {
                Log.e(TAG, "=============onSuccess::" + new Gson().toJson(mAuthenticateBean));

            }

            @Override
            public void onError(Response response, int code, Exception e) {
                Log.e(TAG, "=============onError::" + code + "=========response.body().toString() ::" + response.body().toString());

            }
        });

    }


    /**
     * @todo: 新封装的OkHttp3的Pos请求的
     *
     *
     * */
    public void toNewCallBackPost(){
        String url="http://192.168.1.105:8002/srs-mobile/v3/auth/login2";
        LoginInfo mLoginInfo=new LoginInfo();
        mLoginInfo.setPassword("123456");
        mLoginInfo.setUsername("177000000033");
        OkHttpHelper.getInstance().postJson(url, new Gson().toJson(mLoginInfo), new LoadCallBack<AuthenticateBean>(mView) {
            @Override
            public void onSuccess(Response response, AuthenticateBean mAuthenticateBean) {
                Log.e(TAG, "=============onSuccess::" + new Gson().toJson(mAuthenticateBean));

            }
            @Override
            public void onError(Response response, int code, Exception e) {
                mView.showMessage(code+":"+response.body().toString());
                Log.e(TAG, "=============onError::" + code + "=========response.body().toString() ::" + response.body().toString());

            }
        });

    }






}
