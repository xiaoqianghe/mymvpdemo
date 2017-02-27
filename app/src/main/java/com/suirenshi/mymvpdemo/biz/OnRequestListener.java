package com.suirenshi.mymvpdemo.biz;

import java.util.List;

/**
 * @包名: com.suirenshi.mymvpdemo.mvpinterface
 * @类名: OnRequestListener
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 12:23
 * @描述 : TODO  获取数据的接口回调
 */

public interface OnRequestListener {

    void onSuccess(List<String> data);
    void onFailed();


}
