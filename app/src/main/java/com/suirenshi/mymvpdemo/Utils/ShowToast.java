package com.suirenshi.mymvpdemo.Utils;

import android.content.Context;
import android.widget.Toast;

public class ShowToast {
	private static Toast toast = null;

	/**
	 * @todo: 原来的ToastShow
	 *
	 * */

//	public static void show(final String mess,final Activity context) {
//
//		if (Thread.currentThread().getName().equals("main")){
//			Toast.makeText(context, mess, Toast.LENGTH_SHORT).show();
//		} else {
//			context.runOnUiThread(new Runnable() {
//				@Override
//				public void run() {
//					Toast.makeText(context, mess, Toast.LENGTH_SHORT).show();
//				}
//			});
//		}
//
//	}



	public static void show(final String mess,final Context context) {
		//Toast.makeText(context, mess, Toast.LENGTH_SHORT).show(); //原来的

		try {
			if (null == context || null == mess)
				return;
//			if (!Constant.TOAST.TOAST_IS_SHOW)
//				return;
			if (null == toast)
				toast = Toast.makeText(context, mess, Toast.LENGTH_SHORT);
			else {
				toast.setText(mess);
				toast.setDuration(Toast.LENGTH_SHORT);
			}
			toast.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public static void IsShow(final String mess,final Context context){
		try {
			if (null == context || null == mess)
				return;
//			if (!Constant.TOAST.TOAST_IS_SHOW)
//				return;
			if (null == toast)
				toast = Toast.makeText(context, mess, Toast.LENGTH_SHORT);
			else {
				toast.setText(mess);
				toast.setDuration(Toast.LENGTH_SHORT);
			}
			toast.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}






}
