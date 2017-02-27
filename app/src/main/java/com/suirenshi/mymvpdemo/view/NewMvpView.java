package com.suirenshi.mymvpdemo.view;

import com.bq2015.oknet.modeinterface.INetView;
import com.suirenshi.mymvpdemo.modul.login.AuthenticateBean;

/**
 * @包名: com.suirenshi.mymvpdemo.view
 * @类名: NewMvpView
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 15:47
 * @描述 : TODO 接口 NewMvpView
 */

public interface NewMvpView extends INetView {

   void showMessage(String message);
   void setLoginShowData(AuthenticateBean data);




}
