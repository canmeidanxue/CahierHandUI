package com.wizarpos.cashier.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.activity.PointMeunActivity;
import com.wizarpos.cashier.adapter.MainMenuAdapter;

public class MainMenuFragment extends Fragment {
	private MainMenuAdapter mainMenuAdapter = null;
	private ListView listView = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_menu_fragment, null);
		mainMenuAdapter = new MainMenuAdapter();
		mainMenuAdapter.inflater = inflater;
		setView(view);
		return view;
	}

	private void setView(View view) {
		TextView title = (TextView) view.findViewById(R.id.text_title);
		title.setText(getResources().getString(R.string.app_name));
		listView = (ListView) view.findViewById(R.id.list_data);
		ArrayList<String[]> recordListShow = new ArrayList<String[]>();
		String[] todayData = { "昨日销售", "100.00" }, weekData = { "本周销售",
				"200.00" }, monthData = { "本月销售", "300.00" };
		recordListShow.add(todayData);
		recordListShow.add(weekData);
		recordListShow.add(monthData);
		mainMenuAdapter.list = recordListShow;
		listView.setAdapter(mainMenuAdapter);
		view.findViewById(R.id.btn_cash_desk).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(getActivity(),
								PointMeunActivity.class);
						startActivity(intent);
					}
				});

	}
}
