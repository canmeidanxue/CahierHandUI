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


public class CategoryListAdapter extends BaseAdapter {

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
		ImageView icon = (ImageView) rlayout
				.findViewById(R.id.iv_category_icon);
		TextView tvName = (TextView) rlayout
				.findViewById(R.id.tv_category_name);
		TextView tvAmount = (TextView) rlayout.findViewById(R.id.tv_amount);
		TextView tvMount = (TextView) rlayout.findViewById(R.id.tv_mount);
		Button btnAdd = (Button) rlayout.findViewById(R.id.btn_add);
		Button btnSub = (Button) rlayout.findViewById(R.id.btn_sub);
		// icon.setBackgroundResource(Integer.parseInt(list.get(position)[0]));
		tvName.setText(list.get(position)[1]);
		tvAmount.setText(list.get(position)[2]);
		tvMount.setText(list.get(position)[3]);
		return rlayout;
	}

}
