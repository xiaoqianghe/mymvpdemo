package com.suirenshi.mymvpdemo.presenter;

/**
 * @包名: com.suirenshi.mymvpdemo.presenter
 * @类名: BaseParsenter
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 15:37
 * @描述 : TODO 关于Parsenter业务层的基类
 */

public abstract class BaseParsenter<T> {

    public T mView;


    /**
     * @TODO:绑定View
     *
     * */
    public void attach(T mView){
        this.mView=mView;
    }


    /**
     * @TODO:解绑View
     *
     *
     * */
    public void dettach(){
        mView=null;
    }


}
