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
import android.widget.TextView;

import com.wizarpos.cashier.R;
import com.wizarpos.cashier.adapter.FragmentAdapter;
import com.wizarpos.cashier.fragment.ContactlessCardFragment;
import com.wizarpos.cashier.fragment.InputByHandFragment;
import com.wizarpos.cashier.fragment.ScanQrcodeFragment;
import com.wizarpos.cashier.fragment.SwipeCardFragment;

public class ScanMemberCardActivity extends BaseActivity implements OnClickListener {

	/** viewpager滑动状态的监听 */
	public interface ViewPagerListener {
		public void onViewPagerState();
	};
	private TextView tvTitle;
	private ViewPager viewPager;
	private FragmentAdapter scancardFragmentAdapter;
	private Button[] btnArray = new Button[4];
	private LinearLayout[] llArray = new LinearLayout[4];
	private int currentFragmentIndex = 0;
	private SwipeCardFragment swipeCardFragment;
	private ScanQrcodeFragment scanQrcodeFragment;
	private InputByHandFragment inputByHandFragment;
	private ContactlessCardFragment contactlessCardFragment;
	private LinearLayout back;
	/** 跳转扫描类型*/
	private int scanType = 0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan_member_card);
		setupView();
		setData();
		addListener();
		updateButtonColor();
	}
	
	private void setupView() {
		tvTitle = (TextView) findViewById(R.id.text_title);
		viewPager = (ViewPager) findViewById(R.id.viewpager_membercard_fragment);
		back=(LinearLayout)findViewById(R.id.title_back);
		btnArray[0] = (Button) findViewById(R.id.btn_scan_card);
		btnArray[1] = (Button) findViewById(R.id.btn_two_dimensioncode);
		btnArray[2] = (Button) findViewById(R.id.btn_humanwork);
		btnArray[3] = (Button) findViewById(R.id.btn_contactless_card);
		llArray[0] = (LinearLayout) findViewById(R.id.ll_scan_card);
		llArray[1] = (LinearLayout) findViewById(R.id.ll_two_dimensioncode);
		llArray[2] = (LinearLayout) findViewById(R.id.ll_humanwork);
		llArray[3] = (LinearLayout) findViewById(R.id.ll_contactless_card);
	}
	
	private void setData() {
		tvTitle.setText(getResources().getString(R.string.member_card));
		swipeCardFragment = new SwipeCardFragment();
		scanQrcodeFragment = new ScanQrcodeFragment();
		inputByHandFragment = new InputByHandFragment();
		contactlessCardFragment = new ContactlessCardFragment();
		
		ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
		fragmentList.add(swipeCardFragment);
		fragmentList.add(scanQrcodeFragment);
		fragmentList.add(inputByHandFragment);
		fragmentList.add(contactlessCardFragment);
		scancardFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList,scanType);
		viewPager.setOffscreenPageLimit(4);
		viewPager.setAdapter(scancardFragmentAdapter);
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
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
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
				llArray[i].setBackgroundColor(getResources().getColor(R.color.blue));
			} else {
				llArray[i].setBackgroundColor(getResources().getColor(R.color.grays));
			}
		}
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_scan_card:
			this.currentFragmentIndex = 0;
			break;
		case R.id.btn_two_dimensioncode:
			this.currentFragmentIndex = 1;
			break;
		case R.id.btn_humanwork:
			this.currentFragmentIndex = 2;
			break;
		case R.id.btn_contactless_card:
			this.currentFragmentIndex = 3;
			break;
		}
		viewPager.setCurrentItem(currentFragmentIndex);
		updateButtonColor();
	}
}
