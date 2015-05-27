package com.wizarpos.cashier.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.activity.MenuListActivity;

public class QueryFragment extends Fragment {
	private LinearLayout saleMenu,inputStock,outputStock,accountMenu,onlineAccount,
	shoppingStock,shoppingSaleAmount;
	private int SALE_MENU=0,INPUT_STOCK=1,OUTPUT_STOCK=2,ACCOUNT_MENU=3,ONLINE_ACCOUNT=4,
			SHOPPING_STOCK=5,SHOPPING_SALE_AMOUNT=6;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.query_fragmen, null);
		setView(view);
		setListenner();
		return view;
	}
	private void setView(View view) {
		TextView title = (TextView) view.findViewById(R.id.text_title);
		title.setText(getResources().getString(R.string.quert_title));
		saleMenu=(LinearLayout)view.findViewById(R.id.ll_sale_menu);
		inputStock=(LinearLayout)view.findViewById(R.id.ll_instock_menu);
		outputStock=(LinearLayout)view.findViewById(R.id.ll_outstock_menu);
		accountMenu=(LinearLayout)view.findViewById(R.id.ll_account_menu);
		onlineAccount=(LinearLayout)view.findViewById(R.id.ll_online_menu);
		shoppingStock=(LinearLayout)view.findViewById(R.id.ll_shopping_stock);
		shoppingSaleAmount=(LinearLayout)view.findViewById(R.id.ll_shopping_sale_amount);
	}
	private void setListenner() {
		saleMenu.setOnClickListener(new OnClickListener() {//销售单
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),MenuListActivity.class);
				intent.putExtra("type", SALE_MENU);
				startActivity(intent);
			}
		});
		inputStock.setOnClickListener(new OnClickListener() {//入库单
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),MenuListActivity.class);
				intent.putExtra("type", INPUT_STOCK);
				startActivity(intent);
			}
		});
		outputStock.setOnClickListener(new OnClickListener() {//出库单
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),MenuListActivity.class);
				intent.putExtra("type", OUTPUT_STOCK);
				startActivity(intent);
			}
		});
		accountMenu.setOnClickListener(new OnClickListener() {//盘点单
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),MenuListActivity.class);
				intent.putExtra("type", ACCOUNT_MENU);
				startActivity(intent);
			}
		});
		onlineAccount.setOnClickListener(new OnClickListener() {//线上订单
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),MenuListActivity.class);
				intent.putExtra("type", ONLINE_ACCOUNT);
				startActivity(intent);
			}
		});
		shoppingStock.setOnClickListener(new OnClickListener() {//商品汇总
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),MenuListActivity.class);
				intent.putExtra("type", SHOPPING_STOCK);
				startActivity(intent);
			}
		});
		shoppingSaleAmount.setOnClickListener(new OnClickListener() {//商品销售单汇总
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),MenuListActivity.class);
				intent.putExtra("type", SHOPPING_SALE_AMOUNT);
				startActivity(intent);
			}
		});
		
	}
	
}
