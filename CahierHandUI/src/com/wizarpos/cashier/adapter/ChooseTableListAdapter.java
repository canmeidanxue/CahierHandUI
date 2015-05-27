package com.wizarpos.cashier.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wizarpos.cashier.R;

public class ChooseTableListAdapter extends BaseAdapter {

	private Context context;
	private final ArrayList<String[]> list;

	public ChooseTableListAdapter(Context context,
			ArrayList<String[]> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = new View(context);
		view = inflater.inflate(
				R.layout.component_choose_table_list_menu_data_item, null);
		LinearLayout outer=(LinearLayout)view.findViewById(R.id.rl_outer);
		TextView deskNum=(TextView)view.findViewById(R.id.tv_serial_num);
		TextView amount=(TextView)view.findViewById(R.id.count_amount);
		ImageView openTab=(ImageView)view.findViewById(R.id.iv_kai_tai);
		ImageView telOrder=(ImageView)view.findViewById(R.id.iv_tel_call);
		ImageView orderMenu=(ImageView)view.findViewById(R.id.iv_order_menu);
		LinearLayout llKiaTai=(LinearLayout)view.findViewById(R.id.ll_kai_tai);
		LinearLayout llOrderMenu=(LinearLayout)view.findViewById(R.id.ll_order_menu);
		if (list.get(position)[5].equals("0")) {//桌台背景
			outer.setBackgroundResource(R.drawable.table_white);
			amount.setText("空桌");
			llKiaTai.setVisibility(View.INVISIBLE);
			llOrderMenu.setVisibility(View.INVISIBLE);
			deskNum.setTextColor(Color.BLACK);
		}else if (list.get(position)[5].equals("1")) {
			outer.setBackgroundResource(R.drawable.table_blue);
		}else {
			outer.setBackgroundResource(R.drawable.table_orange);
		}
		deskNum.setText(list.get(position)[0]);
		return view;
	}
}
