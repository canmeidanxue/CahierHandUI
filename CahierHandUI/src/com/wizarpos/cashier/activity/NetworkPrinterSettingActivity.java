package com.wizarpos.cashier.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.adapter.FragmentAdapter;
import com.wizarpos.cashier.fragment.FeiYinPrintFragment;
import com.wizarpos.cashier.fragment.RuiGongPrintFragment;

public class NetworkPrinterSettingActivity extends BaseActivity implements
		OnClickListener {
	private ViewPager viewPager;
	private FragmentAdapter mainFragmentAdapter;
	private Button[] btnArray = new Button[2];
	private RuiGongPrintFragment ruiGongPrintFragment;
	private FeiYinPrintFragment feiYinPrintFragment;
	private LinearLayout[] llArray = new LinearLayout[2];
	private int currentFragmentIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupView();
		setData();
		addListener();
		updateButtonColor();

	}

	private void setupView() {
		setContentView(R.layout.activity_network_printer__setting_activity);
		setTitleText(getResources().getString(R.string.printer_setting));
		viewPager = (ViewPager) findViewById(R.id.viewpager_printer_fragment);
		btnArray[0] = (Button) findViewById(R.id.btn_rui_gong);
		btnArray[1] = (Button) findViewById(R.id.btn_fei_yin);
		llArray[0] = (LinearLayout) findViewById(R.id.ll_rui_gong);
		llArray[1] = (LinearLayout) findViewById(R.id.ll_fei_yin);

	}

	private void setData() {
		ruiGongPrintFragment = new RuiGongPrintFragment();
		feiYinPrintFragment = new FeiYinPrintFragment();
		ArrayList<Fragment> list = new ArrayList<Fragment>();
		list.add(ruiGongPrintFragment);
		list.add(feiYinPrintFragment);
		mainFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),
				list);
		viewPager.setAdapter(mainFragmentAdapter);
	}

	private void addListener() {
		for (Button btn : btnArray) {
			btn.setOnClickListener(this);
		}
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int index) {
				currentFragmentIndex = index;
				updateButtonColor();
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

	}

	private void updateButtonColor() {
		for (int i = 0; i < btnArray.length; i++) {
			if (i == this.currentFragmentIndex) {
				btnArray[i].setTextColor(getResources().getColor(R.color.blue));
			} else {
				btnArray[i].setTextColor(0xFF000000);
			}
		}
		for (int i = 0; i < llArray.length; i++) {
			if (i == this.currentFragmentIndex) {
				llArray[i].setBackgroundColor(getResources().getColor(
						R.color.blue));
			} else {
				llArray[i].setBackgroundColor(getResources().getColor(
						R.color.gray));
			}
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_rui_gong:
			this.currentFragmentIndex = 0;
			break;
		case R.id.btn_fei_yin:
			this.currentFragmentIndex = 1;
		}
		viewPager.setCurrentItem(currentFragmentIndex);
		updateButtonColor();

	}
}
