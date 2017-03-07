package com.suirenshi.mymvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.suirenshi.mymvpdemo.Http.OkHttpHelper;
import com.suirenshi.mymvpdemo.Http.SpotsCallBack;
import com.suirenshi.mymvpdemo.modul.LoginInfo;
import com.suirenshi.mymvpdemo.modul.login.AuthenticateBean;

import okhttp3.Response;

public class MainActivity extends Activity {

    private final String TAG = "MainActivity";

    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_login=(Button)findViewById(R.id.bt_login);
        initEvent();

    }

    private void initEvent() {

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toNewPost();
            }
        });
    }


    /**
     * @todo: 新封装的OkHttp3的Pos请求的
     *
     *
     * */
    public void toNewPost(){
        String url="http://192.168.1.105:8002/srs-mobile/v3/auth/login";
        LoginInfo mLoginInfo=new LoginInfo();
        mLoginInfo.setPassword("123456");
        mLoginInfo.setUsername("17700000003");
        OkHttpHelper.getInstance().postJson(url, new Gson().toJson(mLoginInfo), new SpotsCallBack<AuthenticateBean>(MainActivity.this) {
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


}
