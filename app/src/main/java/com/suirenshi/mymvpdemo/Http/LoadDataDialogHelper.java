package com.suirenshi.mymvpdemo.Http;

import android.content.Context;
import android.util.Log;

import com.suirenshi.mymvpdemo.widght.LoadDataDialog;

/**
 * @包名: com.suirenshi.mymvpdemo.Http
 * @类名: LoadDataDialogHelper
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/3/10 9:55
 * @描述 : TODO
 */

public class LoadDataDialogHelper {

    private static String TAG="LoadDataDialogHelper";

    private static LoadDataDialogHelper mInstance;
    
    private LoadDataDialog mLoadDataDialog;

    public LoadDataDialogHelper(Context mContext) {
        Log.e(TAG, "=============LoadDataDialogHelper(Context mContext)");
        mLoadDataDialog=new LoadDataDialog(mContext);
    }


    public void showDialog(){
        //spotsDialog.show();
        if(null!=mLoadDataDialog&&!mLoadDataDialog.isShowing()) {
            mLoadDataDialog.show();
        }
    }

    public  void dismissDialog(){
        if(null!=mLoadDataDialog&&mLoadDataDialog.isShowing()){
            mLoadDataDialog.dismiss();
        }
        
    }

    public  void setDialogMessage(String message){
        if(null!=mLoadDataDialog){
            mLoadDataDialog.setMessage(message); 
        }
        
    }


    public static LoadDataDialogHelper getInstance(Context mContext) {
        if (mInstance== null) {
            synchronized (LoadDataDialogHelper.class) {
                if (mInstance== null) {
                    mInstance= new LoadDataDialogHelper (mContext);
                }
            }
        }
        return mInstance;
    }


}
