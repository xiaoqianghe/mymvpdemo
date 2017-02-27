package com.suirenshi.mymvpdemo.ui;

import android.os.Bundle;

import com.suirenshi.mymvpdemo.base.BaseActivity;
import com.suirenshi.mymvpdemo.presenter.BaseParsenter;

/**
 * @包名: com.suirenshi.mymvpdemo.ui
 * @类名: BaseMvpActivity
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 15:43
 * @描述 : TODO ui层的基类
 */

public abstract class BaseMvpActivity<V,T extends BaseParsenter<V>> extends BaseActivity {
    public  T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=initPresenter();
    }
    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V)this);
    }
    @Override
    protected void onDestroy() {
        presenter.dettach();
        super.onDestroy();
    }
    //实例化   presenter
    public abstract T initPresenter();

}
