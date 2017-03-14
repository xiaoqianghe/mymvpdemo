package com.suirenshi.mymvpdemo.widght;


import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.suirenshi.mymvpdemo.R;


/**
 * @项目名:
 * @包名:
 * @类名:    LoadingDialog
 * @创建者:
 * @创建时间:
 * @描述:       正在加载的弹窗
 *
 */

public class WqLoadingDialog {
    private AlertDialog create;
    private TextView mTvMsg;


    public WqLoadingDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View view = View.inflate(context, R.layout.loading_data_dialog, null);
            mTvMsg = (TextView) view.findViewById(R.id.tv_msg);
            builder.setView(view);
            create = builder.create();
            create.setCanceledOnTouchOutside(false);


    }




    public void showLoadingDialog(){
        create.show();
    }

    public void showLoadingDialog(String str){
        getMsgView().setText(str);
        create.show();
    }

    public void dismissDialog() {
        if(null!=create) {
            create.dismiss();
        }
    }
    /**
     * 设置dialog 点击空白处不会消失,默认是可以消失的
     *
     */
    public void setCanceledOnTouchOutside() {
        create.setCanceledOnTouchOutside(false);
    }


    public boolean isShowing() {
        return create.isShowing();
    }

    public TextView getMsgView() {
        return mTvMsg;
    }


}
