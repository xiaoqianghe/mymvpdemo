package com.suirenshi.mymvpdemo.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/28.
 */

public class NetworkUtils {

    /**
     * 判断网络是否已连接
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo net = conn.getActiveNetworkInfo();
        if (net != null && net.isConnected()) {
            return true;
        }
        Toast.makeText(context, "网络异常，请重试！！", Toast.LENGTH_SHORT).show();
        return false;
    }
}
