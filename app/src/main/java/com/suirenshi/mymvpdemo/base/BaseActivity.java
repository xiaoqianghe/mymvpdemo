package com.suirenshi.mymvpdemo.base;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.suirenshi.mymvpdemo.Utils.LogUtils;
import com.suirenshi.mymvpdemo.Utils.ShowToast;
import com.suirenshi.mymvpdemo.widght.WqLoadingDialog;

/**
 * @包名: com.suirenshi.mymvpdemo.base
 * @类名: BaseActivity
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 11:56
 * @描述 : TODO
 */

public class BaseActivity extends Activity implements BaseViewInterface {
    private final String TAG = "BaseActivity";
//    private static LoadDataDialog mLoadDataDialog;
    private static WqLoadingDialog mLoadDataDialog;
    @Override
    public void showLoadingView(String showText) {
        toShowLoadingDialog(showText);
    }

    @Override
    public void dissmissLoadingView() {
        toDisimissLoadingDialog();
    }

    @Override
    public void showMessage(String showText) {
        toshowMeassage(showText);
    }

    @Override
    public boolean IsNetConnected() {
        return isNetworkConnected(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        toDisimissLoadingDialog();//Activity销毁的时候也是需要关闭diloag

    }

//    protected void toShowLoadingDialog(String showText){
//        if(!this.isFinishing()){
//            if(null!=mLoadDataDialog&&mLoadDataDialog.isShowing()){
//                mLoadDataDialog.setMessage(showText);
//                mLoadDataDialog.show();
//            }else{
//                mLoadDataDialog=new LoadDataDialog(this);
//                mLoadDataDialog.setMessage(showText);
//                mLoadDataDialog.show();
//            }
//
//        }
//    }
//
//    protected void toDisimissLoadingDialog(){
//        if(null!=mLoadDataDialog&&mLoadDataDialog.isShowing()){
//            mLoadDataDialog.dismiss();
//
//        }
//
//    }


    /**
     * @todo 弹出Toast
     *
     *
     * */
    protected void toshowMeassage(String showText){
       // Toast.makeText(this,showText,Toast.LENGTH_SHORT).show();
        ShowToast.show(showText,this);
    }


    /**
     * @todo 弹出dialog
     *
     * */
    protected void toShowLoadingDialog(String showText){
        if(!this.isFinishing()){
            if(null!=mLoadDataDialog&&mLoadDataDialog.isShowing()){
                LogUtils.v(TAG,"============== mLoadDataDialog.showLoadingDialog(showText);");
                mLoadDataDialog.showLoadingDialog(showText);
            }else{
                mLoadDataDialog=new WqLoadingDialog(this);
                mLoadDataDialog.showLoadingDialog(showText);
                LogUtils.v(TAG, "============== mLoadDataDialog=new WqLoadingDialog(this);");
            }

        }
    }

    /**
     * @todo: 关闭dialog
     *
     *
     * */
    protected void toDisimissLoadingDialog(){
        if(null!=mLoadDataDialog&&mLoadDataDialog.isShowing()){
            mLoadDataDialog.dismissDialog();

            LogUtils.v(TAG,"============== toDisimissLoadingDialog()");
        }
    }


    /**
     * 判断网络是否已连接
     * @param context
     * @return
     */
    protected boolean isNetworkConnected(Context context) {
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo net = conn.getActiveNetworkInfo();
        if (net != null && net.isConnected()) {
            return true;
        }
        //Toast.makeText(context, "网络异常，请重试！！", Toast.LENGTH_SHORT).show();
        toshowMeassage("网络异常，请重试！");
        return false;
    }
}


