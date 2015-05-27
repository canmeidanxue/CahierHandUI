package com.wizarpos.cashier.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.adapter.MenuListAdapter;
import com.wizarpos.cashier.adapter.TakeStockMenuListAdapter;

public class MenuListActivity extends BaseActivity {
	private ListView list;
	private MenuListAdapter menuListAdapter;
	private TakeStockMenuListAdapter takeStockMenuListAdapter;
	private int type=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_list);
		 list = (ListView) findViewById(R.id.data_list);
		 type=getIntent().getIntExtra("type", -1);
		switch (type) {
		case 0:
			setTitleText(getResources().getString(R.string.sale_menu));
			showSaleData();
			break;
		case 1:
			setTitleText(getResources().getString(R.string.instock_menu));
			showTakeStockMenu();
			break;
		case 2:
			setTitleText(getResources().getString(R.string.outstock_menu));
			showTakeStockMenu();
			break;
		case 3:
			setTitleText(getResources().getString(R.string.account_stock_menu));
			showTakeStockMenu();
			break;
		case 4:
			setTitleText(getResources().getString(R.string.online_menu));
			showSaleData();
			break;
		case 5:
			setTitleText(getResources().getString(R.string.shopping_stock));
			showTakeStockMenu();
			break;

		default:
			setTitleText(getResources().getString(R.string.shopping_sale_amount));
			showSaleData();
			break;
		}
		findViewById(R.id.btn_query).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MenuListActivity.this,QueryActivity.class);
				startActivity(intent);
				
			}
		});
		findViewById(R.id.btn_back_menu).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	private void showTakeStockMenu() {
//		setTitleText(getResources().getString(R.string.account_stock_menu));
		takeStockMenuListAdapter=new TakeStockMenuListAdapter();
		LayoutInflater inflater = LayoutInflater.from(this);
		takeStockMenuListAdapter.inflater = inflater;
		ArrayList<String[]> arrayList = new ArrayList<String[]>();
		// 模拟数据
		String[] one = { "s201505190001", "2015-5-19 18:08:17" }, two = { "s201505190001", "2015-5-19 18:08:17"}, three = {
				"s201505190001", "2015-5-19 18:08:17"};
		arrayList.add(one);
		arrayList.add(two);
		arrayList.add(three);
		takeStockMenuListAdapter.list = arrayList;
		list.setAdapter(takeStockMenuListAdapter);
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent(MenuListActivity.this,MenuListDetailActivity.class);
				intent.putExtra("type", type);
				startActivity(intent);
				
			}
		});
	}
	private void showSaleData() {
		menuListAdapter = new MenuListAdapter();
		LayoutInflater inflater = LayoutInflater.from(this);
		menuListAdapter.inflater = inflater;
		ArrayList<String[]> arrayList = new ArrayList<String[]>();
		// 模拟数据
		String[] one = { "s201505190001", "2015-5-19 18:08:17" ,"290.00"}, two = { "s201505190001", "2015-5-19 18:08:17" ,"290.00"}, three = {
				"s201505190001", "2015-5-19 18:08:17" ,"290.00"};
		arrayList.add(one);
		arrayList.add(two);
		arrayList.add(three);
		menuListAdapter.list = arrayList;
		list.setAdapter(menuListAdapter);
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent(MenuListActivity.this,MenuListDetailActivity.class);
				intent.putExtra("type", type);
				startActivity(intent);
				
			}
		});
	}

}
