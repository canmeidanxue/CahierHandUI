package com.wizarpos.cashier.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.activity.PointMeunActivity;
import com.wizarpos.cashier.common.WizarPosUiConstant;
import com.wizarpos.cashier.util.KeyboardLayoutEx;


public class InputByHandFragment extends Fragment implements OnClickListener{
	private final String LOG_TAG = "InputByHandFragment";
	private EditText etInputByHand;
	private KeyboardLayoutEx keyBoard;
	private Button keyOK;
	private String cardNo;
	/** 操作类型*/
	private int scanType = 0 ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.input_by_hand_fragment, null);
		setupView(view);
		Bundle bundle = getArguments();
		keyBoard = (KeyboardLayoutEx) view.findViewById(R.id.keyboard);
		keyOK = (Button) view.findViewById(R.id.key_ok);
		keyOK.setOnClickListener(this);
		keyBoard.setEditView(etInputByHand, KeyboardLayoutEx.INPUT_TYPE_NUM);
		if(bundle!=null && !bundle.isEmpty())
		{
			scanType = bundle.getInt(WizarPosUiConstant.SCAN_SKIT_TYPE);
		}else{
			Log.e(LOG_TAG, "bundle is empty");
		}
		return view;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}
	
	private void setupView(View view){
		etInputByHand = (EditText) view.findViewById(R.id.et_input_by_hand);
	}

	private void skitToActivity () {
		Intent intent = new Intent();
		intent.putExtra(WizarPosUiConstant.CARD_NO, cardNo);
		intent.putExtra(WizarPosUiConstant.SWIPE_TYPE_TAG, WizarPosUiConstant.SWIPE_TYPE_INPUTBYHAND);
		intent.setClass(getActivity(), PointMeunActivity.class);
		getActivity().startActivity(intent);
		getActivity().finish();
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.key_ok:
			cardNo = etInputByHand.getText().toString();
			if (TextUtils.isEmpty(cardNo)) {
				Toast.makeText(getActivity(), "会员卡号不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			skitToActivity();
			break;
		}
	}
}
