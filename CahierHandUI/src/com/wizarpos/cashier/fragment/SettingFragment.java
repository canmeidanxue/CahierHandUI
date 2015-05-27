package com.wizarpos.cashier.fragment;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.activity.NetworkPrinterSettingActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.setting_fragmen, null);
		setView(view);
		return view;
	}

	private void setView(View view) {
		TextView title = (TextView) view.findViewById(R.id.text_title);
		title.setText(getResources().getString(R.string.setting_title));
		view.findViewById(R.id.ll_net_print).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),NetworkPrinterSettingActivity.class);
				startActivity(intent);
			}
		});

	}
}
