package com.wizarpos.cashier;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wizarpos.cashier.activity.BaseActivity;
import com.wizarpos.cashier.fragment.MainMenuFragment;
import com.wizarpos.cashier.fragment.ManageFragment;
import com.wizarpos.cashier.fragment.QueryFragment;
import com.wizarpos.cashier.fragment.SettingFragment;

public class MainActivity extends BaseActivity {

	protected static final String TAG = "MainActivity";
	private ImageButton mMenu, mQuery, mManage, mSetting;
	private View currentButton;
	private LinearLayout buttomBarGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		init();
	}

	private void findView() {
		buttomBarGroup = (LinearLayout) findViewById(R.id.buttom_bar_group);
		mMenu = (ImageButton) findViewById(R.id.buttom_news);
		mQuery = (ImageButton) findViewById(R.id.buttom_constact);
		mManage = (ImageButton) findViewById(R.id.buttom_deynaimic);
		mSetting = (ImageButton) findViewById(R.id.buttom_setting);
	}

	private void init() {
		mMenu.setOnClickListener(mainmenuOnClickListener);
		mQuery.setOnClickListener(queryOnClickListener);
		mManage.setOnClickListener(managerOnClickListener);
		mSetting.setOnClickListener(settingOnClickListener);
		mMenu.performClick();

	}

	private OnClickListener mainmenuOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			MainMenuFragment mainMenuFragment = new MainMenuFragment();
			ft.replace(R.id.fl_content, mainMenuFragment, MainActivity.TAG);
			ft.commit();
			setButton(v);

		}
	};

	private OnClickListener queryOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			QueryFragment queryFragment = new QueryFragment();
			ft.replace(R.id.fl_content, queryFragment, MainActivity.TAG);
			ft.commit();
			setButton(v);

		}
	};

	private OnClickListener managerOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			ManageFragment manageFragment = new ManageFragment();
			ft.replace(R.id.fl_content, manageFragment, MainActivity.TAG);
			ft.commit();
			setButton(v);

		}
	};

	private OnClickListener settingOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			SettingFragment settingFragment = new SettingFragment();
			ft.replace(R.id.fl_content, settingFragment, MainActivity.TAG);
			ft.commit();
			setButton(v);

		}
	};

	private void setButton(View v) {
		if (currentButton != null && currentButton.getId() != v.getId()) {
			currentButton.setEnabled(true);
		}
		v.setEnabled(false);
		currentButton = v;
	}

	private int im = 0;

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			switch (im++) {
			case 0:
				Toast.makeText(MainActivity.this, "再按一次返回键退出程序",
						Toast.LENGTH_LONG);
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					public void run() {
						im = 0;
					}
				}, 3000);
				break;
			case 1:
				// PaymentApplication.getInstance().resetAppState();
				this.finish();
				break;
			default:
				break;
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
