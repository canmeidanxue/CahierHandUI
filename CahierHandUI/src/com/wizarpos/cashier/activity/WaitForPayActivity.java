package com.wizarpos.cashier.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.adapter.WaitForPayAdapter;

public class WaitForPayActivity extends BaseActivity{
	private WaitForPayAdapter waitForPayAdapter;
	private LayoutInflater inflater;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wait_for_pay);
		setTitleText(getResources().getString(R.string.wait_for_pay));
		listView=(ListView)findViewById(R.id.list_wait_for_pay);
		waitForPayAdapter=new WaitForPayAdapter();
		inflater=LayoutInflater.from(this);
		String[] one={"s201505200002","2015-5-20 14:30:47","包间 精英堂  5月20日 11:00-13:00","12.00"};
		ArrayList<String[]>arrayList=new ArrayList<String[]>();
		for (int i = 0; i <10; i++) {
			arrayList.add(one);
		}
		waitForPayAdapter.inflater=inflater;
		waitForPayAdapter.list=arrayList;
		listView.setAdapter(waitForPayAdapter);
	}
	

}
