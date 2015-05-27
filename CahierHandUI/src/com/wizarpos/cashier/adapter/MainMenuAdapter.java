package com.wizarpos.cashier.adapter;

import java.util.ArrayList;
import java.util.List;

import com.wizarpos.cashier.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainMenuAdapter extends BaseAdapter {

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
				R.layout.component_mainmenu_data_item, null);
		ImageView ivIcon=(ImageView)rlayout.findViewById(R.id.icon_type);
		TextView tvTranType = (TextView) rlayout
				.findViewById(R.id.tv_trans_type);
		TextView tvAmount = (TextView) rlayout
				.findViewById(R.id.tv_cashier_amount);
		if (list.get(position)[0].equals("昨日销售")) {
			ivIcon.setBackgroundResource(R.drawable.icon_yesterday);
		}else if (list.get(position)[0].equals("本周销售")) {
			ivIcon.setBackgroundResource(R.drawable.icon_week);
		}else if (list.get(position)[0].equals("本月销售")) {
			ivIcon.setBackgroundResource(R.drawable.icon_month);
		}
		tvTranType.setText(list.get(position)[0]);
		tvAmount.setText("￥" + list.get(position)[1]);
		return rlayout;
	}

}
