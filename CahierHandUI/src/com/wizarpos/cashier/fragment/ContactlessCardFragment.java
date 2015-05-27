package com.wizarpos.cashier.fragment;


import com.wizarpos.cashier.R;
import com.wizarpos.cashier.activity.PointMeunActivity;
import com.wizarpos.cashier.common.WizarPosUiConstant;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ContactlessCardFragment extends Fragment{
	private final String LOG_TAG = "ContactlessCardFragment";
	View contactlessCardLoading;
	
//	private BProcess activateProcess = ProcessMgr.getInstants().getActivateProcess();
	private String cardNo = "";
	
	/** 操作类型*/
	private int scanType = 0 ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.contactlesscard_fragment, null);
		setupView(view);
		Bundle bundle = getArguments();
		if(bundle!=null && !bundle.isEmpty())
		{
			scanType = bundle.getInt(WizarPosUiConstant.SCAN_SKIT_TYPE);
		}else{
			Log.e(LOG_TAG, "bundle is empty");
		}
//		doSwipe();
		return view;
	}
	
	
//	void doSwipe()
//	{
//		activateProcess.doSwipe(new IWaitCallback() {
//			
//			@Override
//			public void success(Response response) {
//				cardNo = activateProcess.doReadContent(WizarConstants.POS_MIFARE_NO_POSITION_0,WizarConstants.CONTROL_BYTE_KEYB_DEFAULT);
//				skitToActivity();
//			}
//			
//			@Override
//			public void failed(Response response) {
//				
//			}
//		});
//	}
	
	
	
	void skitToActivity()
	{
		Intent intent = new Intent();
		intent.putExtra(WizarPosUiConstant.CARD_NO, cardNo);
		intent.putExtra(WizarPosUiConstant.SWIPE_TYPE_TAG, WizarPosUiConstant.SWIPE_TYPE_CONTACTLESS);
		intent.setClass(getActivity(), PointMeunActivity.class);
		getActivity().startActivity(intent);
		isSkitTo = true;
		getActivity().finish();
	}
	
	boolean isSkitTo = false;
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if(!isSkitTo)
		{
//			activateProcess.doEndSwipe();
		}
	}
	
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}
	
	private void setupView(View view){
		contactlessCardLoading = view.findViewById(R.id.contactlesscard_loading);
		final AnimationDrawable loadingAnimation = (AnimationDrawable) contactlessCardLoading.getBackground(); 
		Handler mHandler = new Handler();
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				loadingAnimation.start();
			}
		});
	}

}
