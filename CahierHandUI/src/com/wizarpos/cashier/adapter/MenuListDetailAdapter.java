package com.wizarpos.cashier.adapter;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wizarpos.cashier.R;

public class MenuListDetailAdapter extends BaseAdapter {

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
				R.layout.component_menu_list_detail_data_item, null);
		TextView name = (TextView) rlayout
				.findViewById(R.id.category_name);
		TextView amount = (TextView) rlayout
				.findViewById(R.id.tv_amount);
		TextView account = (TextView) rlayout
				.findViewById(R.id.tv_account);
		
		name.setText(list.get(position)[0]);
		amount.setText("￥" + list.get(position)[1]);
		account.setText("*" + list.get(position)[2]);
		return rlayout;
	}

}
