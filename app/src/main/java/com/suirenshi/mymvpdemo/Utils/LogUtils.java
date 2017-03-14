package com.suirenshi.mymvpdemo.Utils;

import android.util.Log;

/**
 *
 *@包名:com.yspl.ymb_android_code.utils
 *@类名:LogUtils
 *@author:heweiqiang
 *@时间:2015-6-26 上午10:42:46
 *
 *@描述:Log打印工具类
 *
 */
public class LogUtils
{

	private static final int VERBOSE = 1;
	private static final int DEBUG = 2;
	private static final int INFO = 3;
	private static final int WARN = 4;
	private static final int ERROR = 5;
	//private static int LOGLEVEL = 2;
	private static int LOGLEVEL = 0;


	public static void v(String tag,String msg){
		if(VERBOSE>LOGLEVEL){
			Log.v(tag, msg);
		}


	}
	public static void d(String tag,String msg){
		if(DEBUG>LOGLEVEL){
			Log.d(tag, msg);
		}

	}
	public static void i(String tag,String msg){
		if(INFO>LOGLEVEL){
			Log.i(tag, msg);
		}


	}
	public static void w(String tag,String msg){
		if(WARN>LOGLEVEL){
			Log.w(tag, msg);
		}


	}
	public static void e(String tag,String msg){
		if(ERROR>LOGLEVEL){
			Log.e(tag, msg);
		}

	}
	
}
