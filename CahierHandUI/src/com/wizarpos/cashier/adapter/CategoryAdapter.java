package com.wizarpos.cashier.adapter;

import java.util.ArrayList;
import java.util.List;

import com.wizarpos.cashier.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class CategoryAdapter extends BaseAdapter {

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
				R.layout.component_category_menu_data_item, null);
		TextView icon = (TextView) rlayout
				.findViewById(R.id.amount_icon);
		TextView tvName = (TextView) rlayout
				.findViewById(R.id.tv_stock_category_list_name);
		tvName.setText(list.get(position)[0]);
		icon.setText(list.get(position)[1]);
		return rlayout;
	}

}
