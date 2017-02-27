package com.suirenshi.mymvpdemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.suirenshi.mymvpdemo.R;
import com.suirenshi.mymvpdemo.modul.login.AuthenticateBean;
import com.suirenshi.mymvpdemo.presenter.NewMvpPresenter;
import com.suirenshi.mymvpdemo.view.NewMvpView;

/**
 * @包名: com.suirenshi.mymvpdemo.ui
 * @类名: NewMvpActivity
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 16:02
 * @描述 : TODO
 */

public class NewMvpActivity extends BaseMvpActivity<NewMvpView,NewMvpPresenter> implements NewMvpView, AdapterView.OnItemClickListener {
    protected final String TAG = "NewMvpActivity";
    private ListView mvpListView;
    ProgressBar pb;
    private Button bt_login;
    private TextView tv_show_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        bt_login=(Button)findViewById(R.id.bt_login);
        tv_show_login=(TextView)findViewById(R.id.tv_show_login);
        initEvent();
    }

    private void initEvent() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.toLogin("17700000000", "123456");
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public NewMvpPresenter initPresenter() {
        return new NewMvpPresenter();
    }
    @Override
    public void showLoadingView(String showText) {
    }

    @Override
    public void dissmissLoadingView() {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(NewMvpActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoginShowData(AuthenticateBean data) {
        tv_show_login.setText("---登录成功的："+data.getStaff_no());
    }
}
