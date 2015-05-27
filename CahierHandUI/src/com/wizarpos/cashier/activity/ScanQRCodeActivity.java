package com.wizarpos.cashier.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.wizarpos.barcode.scanner.IScanEvent;
import com.wizarpos.barcode.scanner.ScannerRelativeLayout;
import com.wizarpos.barcode.scanner.ScannerResult;
import com.wizarpos.cashier.R;

public class ScanQRCodeActivity extends BaseActivity {
	private ScannerRelativeLayout scanLayout;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scan_qrcode_fragment);
		scanLayout = (ScannerRelativeLayout) findViewById(R.id.re_scanner_two_dimension_progress);
		initScan();
	
	}
	@Override
	public void onResume() {
		super.onResume();
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
		
	}

	@Override
	public void onPause() {
		super.onPause();
		if (scanLayout != null) {
			scanLayout.onPause();
		}
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
				Intent intent=new Intent(ScanQRCodeActivity.this,NetworkPrinterSettingActivity.class);
				intent.putExtra("authCode", authCode);
				setResult(RESULT_OK, intent);
				ScanQRCodeActivity.this.finish();
			}
		});
	}
}
