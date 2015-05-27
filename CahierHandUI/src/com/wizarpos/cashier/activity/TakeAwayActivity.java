package com.wizarpos.cashier.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.adapter.CategoryMenuAdapter;

public class TakeAwayActivity extends BaseActivity {
	private ListView list;
	private CategoryMenuAdapter categoryMenuAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_take_away);
		setTitleText(getResources().getString(R.string.take_away));
		list = (ListView) findViewById(R.id.lv_list_menu);
		categoryMenuAdapter = new CategoryMenuAdapter();
		LayoutInflater inflater = LayoutInflater.from(this);
		categoryMenuAdapter.inflater = inflater;
		ArrayList<String[]> arrayList = new ArrayList<String[]>();
		// 模拟数据
		String[] one = { "麻辣水煮牛肉", "￥22.00" }, two = { "麻辣水煮牛肉", "￥22.00" }, three = {
				"麻辣水煮牛肉", "￥22.00" };
		arrayList.add(one);
		arrayList.add(two);
		arrayList.add(three);
		categoryMenuAdapter.list = arrayList;
		list.setAdapter(categoryMenuAdapter);
		findViewById(R.id.btn_back_menu).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		findViewById(R.id.text_back).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

}
