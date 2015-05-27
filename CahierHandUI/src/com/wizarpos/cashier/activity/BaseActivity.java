package com.wizarpos.cashier.activity;

import com.wizarpos.cashier.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class BaseActivity extends FragmentActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

	}
	
	public void setOnClickListenerById(int viewId, View.OnClickListener listener) {
		findViewById(viewId).setOnClickListener(listener);
	}

	public void setOnClickListenerByIds(int[] viewIds, View.OnClickListener listener) {
		for (int viewId : viewIds) {
			setOnClickListenerById(viewId, listener);
		}
	}
	public void findViewByIds(int[] viewIds, View[] views) {
		for (int i = viewIds.length; --i >= 0;) {
			views[i] = findViewById(viewIds[i]);
		}
	}
	/*
	 * 设置标题
	 */
	protected void setTitleText(String text) {
		if (text == null) {
			return;
		}
		TextView tv = (TextView) findViewById(R.id.text_title);
		if (tv == null) {
			return;
		}
		tv.setVisibility(View.VISIBLE);
		tv.setText(text);
	}
	@Override
	public void onClick(View v) {
		
	}
}
