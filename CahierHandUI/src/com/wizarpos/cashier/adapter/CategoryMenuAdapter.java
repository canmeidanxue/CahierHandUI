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

public class CategoryMenuAdapter extends BaseAdapter {

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
				R.layout.component_category_list_menu_data_item, null);
		TextView tvTranType = (TextView) rlayout
				.findViewById(R.id.tv_category_list_name);
		TextView tvAmount = (TextView) rlayout
				.findViewById(R.id.tv_list_amount);
		tvTranType.setText(list.get(position)[0]);
		tvAmount.setText(list.get(position)[1]);
		return rlayout;
	}

}
