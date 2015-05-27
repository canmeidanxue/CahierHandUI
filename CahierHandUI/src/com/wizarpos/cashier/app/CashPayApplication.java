package com.wizarpos.cashier.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class CashPayApplication {
	private static CashPayApplication application;
	private List<Activity> activities = new ArrayList<Activity>();

	public void onCreate() {
		application = this;
	}

	public static CashPayApplication getInstance() {
		return application;
	}

	public void addActivity(Activity activity) {
		activities.add(activity);
	}

	public void removeActivity(Activity activity) {
		activities.remove(activity);
	}

	public void killAllActivites() {
		for (Activity activity : activities) {
			activity.finish();
		}
		activities.clear();
	}

}
