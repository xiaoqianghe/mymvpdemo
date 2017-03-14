package com.suirenshi.mymvpdemo.base;

/**
 * @包名: com.suirenshi.mymvpdemo.base
 * @类名: BaseViewInterface
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/3/14 15:36
 * @描述 : TODO
 */

public interface BaseViewInterface {
    void showLoadingView(String showText);
    void dissmissLoadingView();
    void showMessage(String showText);

    boolean IsNetConnected();
}
