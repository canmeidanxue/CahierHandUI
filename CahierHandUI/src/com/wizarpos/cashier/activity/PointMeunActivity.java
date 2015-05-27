package com.wizarpos.cashier.activity;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.adapter.CategoryAdapter;
import com.wizarpos.cashier.adapter.CategoryMenuAdapter;
import com.wizarpos.cashier.adapter.SaleDetailAdapter;
import com.wizarpos.cashier.util.SlidingLayout;

public class PointMeunActivity extends BaseActivity {
	private LinearLayout more;
	private CategoryAdapter categoryAdapter;
	private LayoutInflater inflater;
	private SaleDetailAdapter saleDetailAdapter;
	private SlidingLayout slidingLayout;
	private  PopupWindow mPopupWindow; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_point_meun);
		setTitleText(getResources().getString(R.string.point_menu));
		slidingLayout = (SlidingLayout) findViewById(R.id.sliding_layout);
		slidingLayout.leftLayoutPadding = 320;
		ListView list = (ListView) findViewById(R.id.category_list);
		ListView listDetail = (ListView) findViewById(R.id.detail_list);
		categoryAdapter = new CategoryAdapter();
		saleDetailAdapter = new SaleDetailAdapter();
		inflater = LayoutInflater.from(this);
		ArrayList<String[]> categoryList = new ArrayList<String[]>();
		// 模拟数据,左侧list中显示的数据
		String[] bussiness = { "商务套餐", "3" }, fan = { "盖浇饭", "2" }, zai = {
				"煲仔饭", "4" }, shaguo = { "砂锅系列", "5" }, sale = { "配餐", "13" }, other = {
				"其它", "12" };
		categoryList.add(bussiness);
		categoryList.add(fan);
		categoryList.add(zai);
		categoryList.add(shaguo);
		categoryList.add(sale);
		categoryList.add(other);
		categoryAdapter.inflater = inflater;
		categoryAdapter.list = categoryList;
		list.setAdapter(categoryAdapter);
		// 右侧list中显示的数据
		// ///////////////////////////////////////////////////////////////////
		ArrayList<String[]> detailList = new ArrayList<String[]>();
		String[] one = { "0", "咖喱鸡块+小炒+时蔬", "12元", "1" }, two = { "0",
				"咖喱鸡块+小炒+时蔬", "12元", "1" }, three = { "0", "咖喱鸡块+小炒+时蔬", "12元",
				"1" }, four = { "0", "咖喱鸡块+小炒+时蔬", "12元", "1" }, five = { "0",
				"咖喱鸡块+小炒+时蔬", "12元", "1" };
		saleDetailAdapter.inflater = inflater;
		detailList.add(one);
		detailList.add(two);
		detailList.add(three);
		detailList.add(four);
		detailList.add(five);
		saleDetailAdapter.list = detailList;
		listDetail.setAdapter(saleDetailAdapter);
		slidingLayout.setScrollEvent(listDetail);
		more = (LinearLayout) findViewById(R.id.more);
		findViewById(R.id.buttom_more).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						more.setVisibility(View.VISIBLE);
					}
				});
		
		//更多
		findViewById(R.id.buttom_add).setOnClickListener(new OnClickListener() {//新增
			@Override
			public void onClick(View v) {
				more.setVisibility(View.GONE);
				
			}
		});
		findViewById(R.id.buttom_del).setOnClickListener(new OnClickListener() {//删除
			@Override
			public void onClick(View v) {
				more.setVisibility(View.GONE);
				
			}
		});
		findViewById(R.id.buttom_history).setOnClickListener(new OnClickListener() {//历史记录
			@Override
			public void onClick(View v) {
				more.setVisibility(View.GONE);
				
			}
		});
		findViewById(R.id.buttom_shift_change).setOnClickListener(new OnClickListener() {//交接班
			@Override
			public void onClick(View v) {
				more.setVisibility(View.GONE);
				
			}
		});
		findViewById(R.id.re_go_pay).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showPopupWindow();

			}
		});
		findViewById(R.id.go_pay).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showPopupWindow();

			}
		});
		findViewById(R.id.buttom_wait_for_pay).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(PointMeunActivity.this,
								WaitForPayActivity.class);
						startActivity(intent);

					}
				});
		findViewById(R.id.buttom_member_card).setOnClickListener(
				new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(PointMeunActivity.this,
								ScanMemberCardActivity.class);
						startActivity(intent);
						
					}
				});
	}

	/*
	 * 显示交易后续交易
	 */
	public void showPopupWindow() {
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.order_type_popupwindow, null);
		mPopupWindow= new PopupWindow(view,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		mPopupWindow.setFocusable(true);
		mPopupWindow.setBackgroundDrawable(new BitmapDrawable(
				getResources(), (Bitmap) null));
		mPopupWindow.setOutsideTouchable(true);
		mPopupWindow.showAtLocation(view,Gravity.CENTER, 0, 0);
		Button takeAway = (Button) view
				.findViewById(R.id.btn_take_away), 
				hallDinner = (Button) view
				.findViewById(R.id.btn_dinner_hall);
		
		takeAway.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PointMeunActivity.this,
						TakeAwayActivity.class);
				startActivity(intent);
				mPopupWindow.dismiss();
			}
		});
		hallDinner.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PointMeunActivity.this,
						ChooseTableActivity.class);
				startActivity(intent);
				mPopupWindow.dismiss();
			}
		});
	}
}
