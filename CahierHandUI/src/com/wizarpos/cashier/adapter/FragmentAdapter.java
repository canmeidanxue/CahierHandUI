package com.wizarpos.cashier.adapter;

import java.util.ArrayList;



import com.wizarpos.cashier.common.WizarPosUiConstant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
	ArrayList<Fragment> list;
	private int scanType = 0;
	
	public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> list)
	{
		super(fm);
		if (list != null) {
			this.list = list;
		} else {
			this.list = new ArrayList<Fragment>();
		}
	}
	
	public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> list,int scanType) {
		super(fm);
		this.scanType = scanType;
		if (list != null) {
			this.list = list;
		} else {
			this.list = new ArrayList<Fragment>();
		}
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Fragment getItem(int position) {
		/** 将操作类型传递给fragment*/
		Fragment fragment = list.get(position);
		if(scanType!=0)
		{
			Bundle bundle = new Bundle();
			bundle.putInt(WizarPosUiConstant.SCAN_SKIT_TYPE, scanType);
			fragment.setArguments(bundle);
		}
		return fragment;
	}
	

}
