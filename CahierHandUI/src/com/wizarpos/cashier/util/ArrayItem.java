package com.wizarpos.cashier.util;

public class ArrayItem {
	private String realValue;
	private String showValue;

	public ArrayItem() {}

	public ArrayItem(String realValue, String showValue) {
		this.realValue = realValue;
		this.showValue = showValue;
	}

	public String getRealValue() {
		return realValue;
	}

	public void setRealValue(String realValue) {
		this.realValue = realValue;
	}

	public String getShowValue() {
		return showValue;
	}

	public void setShowValue(String showValue) {
		this.showValue = showValue;
	}

	@Override
	public String toString() {
		return showValue;
	}
}
