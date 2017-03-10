package com.suirenshi.mymvpdemo.app;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;


public class BaseActivity extends Activity {
	protected final String TAG = this.getClass().getName();

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//动态设置Activity禁止横竖屏切换

	}
	@Override
	protected void onDestroy() {
		super.onDestroy();

	}
	@Override
	protected void onResume() {
		super.onResume();



	}

	@Override
	protected void onPause() {
		super.onPause();
	}




}
