package com.wizarpos.cashier.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wizarpos.barcode.scanner.IScanEvent;
import com.wizarpos.barcode.scanner.ScannerRelativeLayout;
import com.wizarpos.barcode.scanner.ScannerResult;
import com.wizarpos.cashier.R;
import com.wizarpos.cashier.activity.PointMeunActivity;
import com.wizarpos.cashier.common.WizarPosUiConstant;

public class ScanQrcodeFragment extends BaseFragment {
	private final String LOG_TAG = "ScanQrcodeFragment";
	private ScannerRelativeLayout scanLayout;

	/** 操作类型 */
	private int scanType = 0;

	private static final int START_SCAN = 1;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case START_SCAN:
				if (scanLayout != null) {
					scanLayout.startScan();
				}
				break;
			}
		};
	};
	/** 标志位，标志已经初始化完成 */
    private boolean isPrepared;
    /** 是否已被加载过一次，第二次就不再去请求数据了 */
    private boolean mHasLoadedOnce;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(LOG_TAG, "onCreate");
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d(LOG_TAG, "onAttach");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.scan_qrcode_fragment, null);
		setupView(view);
		Bundle bundle = getArguments();
		if (bundle != null && !bundle.isEmpty()) {
			scanType = bundle.getInt(WizarPosUiConstant.SCAN_SKIT_TYPE);
		} else {
			Log.e(LOG_TAG, "bundle is empty");
		}
		Log.d(LOG_TAG,"onCreateView");
		 isPrepared = true;
		 lazyLoad();
		return view;

	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	private void setupView(View view) {
		scanLayout = (ScannerRelativeLayout) view
				.findViewById(R.id.re_scanner_two_dimension_progress);
		//initScan();
	}

	private void initScan() {
		scanLayout.setFrontFacingCamera(true);
		scanLayout.startScan();
		scanLayout.setEncodeFormat("CODE_128");
		scanLayout.setScanSuccessListener(new IScanEvent() {
			@Override
			public void scanCompleted(ScannerResult result) {
				scanLayout.stopScan();
				String authCode = result.getResult();
				skitToActivity(authCode);
			}
		});
	}

	private void skitToActivity(String authCode) {
		Intent intent = new Intent();
		intent.putExtra(WizarPosUiConstant.CARD_NO, authCode);
		intent.putExtra(WizarPosUiConstant.SWIPE_TYPE_TAG,
				WizarPosUiConstant.SWIPE_TYPE_SCANQRCODE);
		intent.setClass(getActivity(), PointMeunActivity.class);
		getActivity().startActivity(intent);
		getActivity().finish();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.d(LOG_TAG, "onActivityCreated");
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(LOG_TAG, "onStart");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d(LOG_TAG, "onResume");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d(LOG_TAG, "onPause");
		if (scanLayout != null) {
			scanLayout.onPause();
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(LOG_TAG, "onStop");
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.d(LOG_TAG, "onDestroyView");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(LOG_TAG,"onDestroy");
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		Log.d(LOG_TAG, "onDetach");
	}

	@Override
	public void lazyLoad() {
		 if (!isPrepared || !isVisible || mHasLoadedOnce) {
	            return;
	        }
		 if (scanLayout != null) {
				scanLayout.onResume();
			}
			new Thread() {
				public void run() {
					try {
						sleep(500L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					handler.sendEmptyMessage(START_SCAN);
				}
			}.start();
		 initScan();
	}

	@Override
	protected void invisible() {
		if(scanLayout!=null)
			scanLayout.stopScan();
	}

}
