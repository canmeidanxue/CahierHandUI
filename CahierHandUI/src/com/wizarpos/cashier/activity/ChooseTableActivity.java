package com.wizarpos.cashier.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.adapter.ChooseTableListAdapter;

public class ChooseTableActivity extends BaseActivity {
	private GridView gridView;
	private int REQUESTCODE=10001;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_table);
		setTitleText(getResources().getString(R.string.choose_table));
		gridView=(GridView)findViewById(R.id.grid_view);
		ArrayList<String[]>list=new ArrayList<String[]>();
		String[] exDataNull={"001桌","14.00","0","0","0","0"};
		String[] exDataOrder={"002桌","14.00","1","0","0","1"};
		String[] exData={"003桌","14.00","0","1","0","2"};
		for (int i = 0; i < 10; i++) {
			list.add(exDataNull);
			list.add(exDataOrder);
			list.add(exData);
		}
		gridView.setAdapter(new ChooseTableListAdapter(this,list));
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
		findViewById(R.id.btn_back_menu).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		findViewById(R.id.text_back).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		findViewById(R.id.icon_scan).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(ChooseTableActivity.this,ScanQRCodeActivity.class);
				startActivityForResult(intent,REQUESTCODE);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode==REQUESTCODE) {
			if (resultCode==RESULT_OK) {
				String code=data.getStringExtra("authCode");
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
