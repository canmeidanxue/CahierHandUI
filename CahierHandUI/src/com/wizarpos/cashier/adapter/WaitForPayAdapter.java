package com.wizarpos.cashier.adapter;

import java.util.ArrayList;
import java.util.List;

import com.wizarpos.cashier.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class WaitForPayAdapter extends BaseAdapter {

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
				R.layout.component_wait_for_pay_data_item, null);
		TextView serialNum=(TextView)rlayout.findViewById(R.id.tv_sale_serial_num);
		TextView transTime=(TextView)rlayout.findViewById(R.id.trans_time);
		TextView transContent=(TextView)rlayout.findViewById(R.id.tv_payment_content);
		TextView transAmount=(TextView)rlayout.findViewById(R.id.tv_wait_amount);
		Button goPay=(Button)rlayout.findViewById(R.id.go_pay);
		serialNum.setText(list.get(position)[0]);
		transTime.setText(list.get(position)[1]);
		transContent.setText(list.get(position)[2]);
		transAmount.setText("￥"+list.get(position)[3]);
		return rlayout;
	}

}
