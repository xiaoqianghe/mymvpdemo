package com.suirenshi.mymvpdemo.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.suirenshi.mymvpdemo.R;
import com.suirenshi.mymvpdemo.base.BaseActivity;
import com.suirenshi.mymvpdemo.presenter.MvpParsenter;
import com.suirenshi.mymvpdemo.view.MvpView;

import java.util.List;

/**
 * @包名: com.suirenshi.mymvpdemo.ui
 * @类名: MvpActivity
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 11:58
 * @描述 : TODO  ui层实现View的接口
 */

public class MvpActivity extends BaseActivity implements MvpView, AdapterView.OnItemClickListener {
    private final String TAG = "MvpActivity";
    private ListView mvpListView;
    ProgressBar pb;
    MvpParsenter mvpParsenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mvpParsenter=new MvpParsenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mvpParsenter.onResume();
    }

    @Override
    public void showLoadingDialog() {
        pb.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoadingDialog() {
        pb.setVisibility(View.GONE);

    }

    @Override
    public void setListItem(List<String> data) {
        Log.d(TAG,"==============data.size()::"+data.size());
        ArrayAdapter adapter= new ArrayAdapter(MvpActivity.this,android.R.layout.simple_list_item_1,data);
        mvpListView.setAdapter(adapter);
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(MvpActivity.this,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mvpParsenter.onItemClick(i);

    }

    @Override
    protected void onDestroy() {
        //记得这里需要销毁，防止内存泄露
        mvpParsenter.onDestroy();
        super.onDestroy();
    }
}
