package com.wizarpos.cashier.fragment;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.common.WizarPosUiConstant;


public class SwipeCardFragment extends Fragment{
	private final String LOG_TAG = "SwipeCardFragment";
	View swipeCardLoading;
	/** 操作类型*/
	private int scanType = 0 ;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Bundle bundle = getArguments();
		if(bundle!=null && !bundle.isEmpty())
		{
			scanType = bundle.getInt(WizarPosUiConstant.SCAN_SKIT_TYPE);
		}else{
			Log.e(LOG_TAG, "bundle is empty");
		}
		View view = inflater.inflate(R.layout.swipecard_fragment, null);
		setupView(view);
		initSwipe();
		return view;
		
	}
	
	
	void initSwipe()
	{
//		DeviceManager.getInstance().getTrack2(new ResultListener() {
//			
//			@Override
//			public void onSuccess(Response response) {
//				
//				skitToActivity(response);
//				
//				
//			}
//			
//			@Override
//			public void onFaild(Response response) {
//				Log.e("", "failed");
//			}
//		});
		
	}

	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}
	
	private void setupView(View view){
		swipeCardLoading = view.findViewById(R.id.swipecard_loading);
		final AnimationDrawable loadingAnimation = (AnimationDrawable) swipeCardLoading.getBackground(); 
		Handler mHandler = new Handler();
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				loadingAnimation.start();
			}
		});
	}
}
