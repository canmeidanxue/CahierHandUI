package com.wizarpos.cashier.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.util.ArrayItem;
import com.wizarpos.cashier.util.DialogHelper;

public class QueryActivity extends BaseActivity  {
	public EditText startDateEt, endDateEt, swiftNumberEt;
	private ArrayAdapter<ArrayItem> transTypeAdapter = null;
	private ArrayAdapter<ArrayItem> dateAdapter = null;
	static String transCode = "-1", dateCode = "0";
	static String startDate = "", endDate = "";
	ArrayList<String> stringList = new ArrayList<String>();
	LinearLayout llSerialNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_query);
		setTitleText(getResources().getString(R.string.quert_title));
		initView();
		findViewById(R.id.btn_confirm).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		findViewById(R.id.btn_back_menu).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	}

	private void initView() {
		llSerialNum = (LinearLayout) findViewById(R.id.ll_serialnum);
		startDateEt = (EditText) findViewById(R.id.start_et);
		endDateEt = (EditText) findViewById(R.id.end_et);
		swiftNumberEt = (EditText) findViewById(R.id.serial_transnumber_et);
		String serialNum =swiftNumberEt.getText().toString();
		swiftNumberEt.setText(serialNum);
		swiftNumberEt.setSelection(serialNum.length());
		showTransType();
		showDate();
		startDateEt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				DialogHelper.showDateDialog(QueryActivity.this, startDateEt);
			}
		});
		startDateEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					DialogHelper
							.showDateDialog(QueryActivity.this, startDateEt);
				}
			}
		});
		endDateEt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				DialogHelper.showDateDialog(QueryActivity.this, endDateEt);
			}
		});
		endDateEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					DialogHelper.showDateDialog(QueryActivity.this, endDateEt);
				}
			}
		});
	}

	// 交易类型
	protected void showTransType() {
		Spinner spTransType = (Spinner) findViewById(R.id.trans_type_spinner);
		transTypeAdapter = new ArrayAdapter<ArrayItem>(this,
				R.layout.simple_spinner_item);
		transTypeAdapter
				.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
		String[] numbers = getResources().getStringArray(R.array.numbers_array);
		String[] transTypes = getResources().getStringArray(
				R.array.trans_type_array);
		for (int i = 0; i < numbers.length; i++) {
			transTypeAdapter.add(new ArrayItem(numbers[i], transTypes[i]));
		}
		spTransType.setAdapter(transTypeAdapter);
		spTransType
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> aview, View view,
							int position, long arg3) {
						transCode = transTypeAdapter.getItem(position)
								.getRealValue();
					}

					public void onNothingSelected(AdapterView<?> aview) {
					}
				});
	}

	// 时间范围
	protected void showDate() {
		Spinner spDate = (Spinner) findViewById(R.id.trans_date_spinner);
		dateAdapter = new ArrayAdapter<ArrayItem>(this,
				R.layout.simple_spinner_item);
		dateAdapter
				.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
		String[] numbers = getResources().getStringArray(
				R.array.numbers_array_time);
		String[] timeRange = getResources().getStringArray(
				R.array.time_range_array);
		for (int i = 0; i < numbers.length; i++) {
			dateAdapter.add(new ArrayItem(numbers[i], timeRange[i]));
		}
		spDate.setAdapter(dateAdapter);
		spDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> aview, View view,
					int position, long arg3) {
				dateCode = dateAdapter.getItem(position).getRealValue();
				if (dateCode.equals("6")) {
					startDateEt.setEnabled(true);
					startDateEt.setFocusable(true);
					endDateEt.setEnabled(true);
					endDateEt.setFocusable(true);
					startDateEt.setText(startDate);
					endDateEt.setText(endDate);
					startDateEt.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.search_input));
					endDateEt.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.search_input));
				} else {
					startDateEt.setEnabled(false);
					startDateEt.setFocusable(false);
					endDateEt.setEnabled(false);
					endDateEt.setFocusable(false);
					startDateEt.setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.search_input2));
					endDateEt.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.search_input2));
				}
			}

			public void onNothingSelected(AdapterView<?> aview) {
			}
		});
		startDateEt.setEnabled(false);
		startDateEt.setFocusable(false);
		endDateEt.setEnabled(false);
		endDateEt.setFocusable(false);
	}
}
