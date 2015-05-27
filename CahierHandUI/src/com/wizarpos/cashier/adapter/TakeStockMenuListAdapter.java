package com.wizarpos.cashier.adapter;

import java.util.ArrayList;
import java.util.List;

import com.wizarpos.cashier.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class TakeStockMenuListAdapter extends BaseAdapter {

	public LayoutInflater inflater = null;
	public List<String[]> list = new ArrayList<String[]>();

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		RelativeLayout rlayout = (RelativeLayout) inflater.inflate(
				R.layout.component_take_stock_menu_list_data_item, null);
		TextView singleNum= (TextView) rlayout
				.findViewById(R.id.tv_take_stock_single_num);
		TextView time = (TextView) rlayout
				.findViewById(R.id.tv_take_stock_trans_time);
		
		singleNum.setText(list.get(position)[0]);
		time.setText(list.get(position)[1]);
		return rlayout;
	}

}
