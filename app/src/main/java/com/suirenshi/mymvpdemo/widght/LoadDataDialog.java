package com.suirenshi.mymvpdemo.widght;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.suirenshi.mymvpdemo.R;

/**
 * @包名: com.suirenshi.mymvpdemo.widght
 * @类名: LoadDataDialog
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/3/8 19:55
 * @描述 : TODO
 */

public class LoadDataDialog extends AlertDialog {

    private static final int DELAY = 150;
    private static final int DURATION = 1500;

    private int size;

    private CharSequence message;

    public LoadDataDialog(Context context) {
        this(context, R.style.SpotsDialogDefault);
    }

    public LoadDataDialog(Context context, CharSequence message) {
        this(context);
        this.message = message;
    }

    public LoadDataDialog(Context context, CharSequence message, int theme) {
        this(context, theme);
        this.message = message;
    }

    public LoadDataDialog(Context context, int theme) {
        super(context, theme);
    }

    public LoadDataDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loading_data_dialog);
        setCanceledOnTouchOutside(false);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    public void setMessage(CharSequence message) {
        ((TextView) findViewById(R.id.tv_msg)).setText(message);
    }





}
