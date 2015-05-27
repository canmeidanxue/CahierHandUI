package com.wizarpos.cashier.fragment;

import com.wizarpos.cashier.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ManageFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.manage_fragmen, null);
		setView(view);
		return view;
	}

	private void setView(View view) {
		TextView title = (TextView) view.findViewById(R.id.text_title);
		title.setText(getResources().getString(R.string.manage_title));

	}
}
