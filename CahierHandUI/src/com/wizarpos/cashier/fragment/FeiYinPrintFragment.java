package com.wizarpos.cashier.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.activity.ScanQRCodeActivity;

public class FeiYinPrintFragment extends Fragment {
	private EditText marchantCode,terminalCode,secretKey;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fei_yin_print_fragment, null);
		marchantCode=(EditText)view.findViewById(R.id.et_marchant_code);
		terminalCode=(EditText)view.findViewById(R.id.et_terminal_code);
		secretKey=(EditText)view.findViewById(R.id.et_secret_key);
		view.findViewById(R.id.btn_fei_yin_confirm).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {//确定按钮
				getActivity().finish();
			}
		});
		view.findViewById(R.id.btn_merchant_code).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),ScanQRCodeActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		view.findViewById(R.id.btn_terminal_code).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),ScanQRCodeActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		view.findViewById(R.id.btn_secret_key).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),ScanQRCodeActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		return view;
	}

}
