package com.suirenshi.mymvpdemo.view;

import java.util.List;

/**
 * @包名: com.suirenshi.mymvpdemo.view
 * @类名: MvpView
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 11:50
 * @描述 : TODO View层的接口
 */

public interface MvpView {

    //显示 dialog方法
    void showLoadingDialog();

    void hideLoadingDialog();



    void showMessage(String s);//Toast消息提示


    void setListItem(List<String> data);//ListView数据的初始化



}
