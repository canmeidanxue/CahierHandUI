package com.wizarpos.cashier.activity;

import java.util.ArrayList;
import java.util.Iterator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.adapter.MenuListDetailAdapter;
import com.wizarpos.cashier.adapter.StockMenuListDetailAdapter;

public class MenuListDetailActivity extends BaseActivity {
	private ListView list;
	private MenuListDetailAdapter menuListAdapter;
	private StockMenuListDetailAdapter stockMenuListDetailAdapter;
	private ImageView back,write;
	private int type=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_menu_detail_list);
//		back=(ImageView)findViewById(R.id.btn_back_menu);
//		write=(ImageView)findViewById(R.id.icon_write);
//		back.setVisibility(View.VISIBLE);
		type=getIntent().getIntExtra("type", -1);
		switch (type) {
		case 0:
			setContentView(R.layout.activity_menu_detail_list);
			list = (ListView) findViewById(R.id.list_menu);
			setTitleText(getResources().getString(R.string.sale_menu_detail));
			showSaleDetailMenu();
			break;
		case 1:
			setTitleText(getResources().getString(R.string.instock_menu_detai));
			break;
		case 2:
			setTitleText(getResources().getString(R.string.outstock_menu_detail));
			break;
		case 3:
			setContentView(R.layout.activity_take_stock_menu_detail_list);
			list = (ListView) findViewById(R.id.list_menu);
			setTitleText(getResources().getString(R.string.account_stock_menu_detai));
			showStockData();
			break;
		case 4:
			setTitleText(getResources().getString(R.string.online_menu_detail));
			break;
		case 5:
			setTitleText(getResources().getString(R.string.shopping_stock_detail));
			break;

		default:
			setTitleText(getResources().getString(R.string.shopping_sale_amount_detail));
			break;
		}
//		list = (ListView) findViewById(R.id.list_menu);
//		menuListAdapter = new MenuListDetailAdapter();
//		LayoutInflater inflater = LayoutInflater.from(this);
//		menuListAdapter.inflater = inflater;
//		ArrayList<String[]> arrayList = new ArrayList<String[]>();
//		// 模拟数据
//		String[] one = { "麻辣水煮牛肉", "22.00" ,"2"}, two = { "麻辣水煮牛肉", "22.00","1"}, three = {
//				"麻辣水煮牛肉", "22.00","4"};
//		arrayList.add(one);
//		arrayList.add(two);
//		arrayList.add(three);
//		menuListAdapter.list = arrayList;
//		list.setAdapter(menuListAdapter);
//		findViewById(R.id.btn_back_menu).setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				finish();
//				
//			}
//		});
//		findViewById(R.id.text_back).setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				finish();
//				
//			}
//		});
	}
	private void showStockData() {
		back=(ImageView)findViewById(R.id.btn_back_menu);
		write=(ImageView)findViewById(R.id.icon_write);
		back.setVisibility(View.VISIBLE);
		write.setVisibility(View.VISIBLE);
		stockMenuListDetailAdapter=new StockMenuListDetailAdapter();
		LayoutInflater inflater=LayoutInflater.from(this);
		stockMenuListDetailAdapter.inflater=inflater;
		ArrayList<String[]>arrayList=new ArrayList<String[]>();
		String[] yin={"青岛啤酒 500ml 德国风味","盈3"},kui={"青岛啤酒 500ml 德国风味","亏3"};
		for (int i = 0; i < 10; i++) {
			arrayList.add(yin);
			arrayList.add(kui);
		}
		stockMenuListDetailAdapter.list=arrayList;
		list.setAdapter(stockMenuListDetailAdapter);
		findViewById(R.id.btn_back_menu).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		
	}
	private void showSaleDetailMenu() {
		menuListAdapter = new MenuListDetailAdapter();
		LayoutInflater inflater = LayoutInflater.from(this);
		menuListAdapter.inflater = inflater;
		ArrayList<String[]> arrayList = new ArrayList<String[]>();
		// 模拟数据
		String[] one = { "麻辣水煮牛肉", "22.00" ,"2"}, two = { "麻辣水煮牛肉", "22.00","1"}, three = {
				"麻辣水煮牛肉", "22.00","4"};
		arrayList.add(one);
		arrayList.add(two);
		arrayList.add(three);
		menuListAdapter.list = arrayList;
		list.setAdapter(menuListAdapter);
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
