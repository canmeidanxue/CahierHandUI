package com.wizarpos.cashier.util;



import com.wizarpos.cashier.R;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * 
 * @ClassName: GridLayoutEx
 * @Author: Huangweicai
 * @Date: 2015-4-27 下午5:35:47
 * @Reason: 键盘容器
 */
public class KeyboardLayoutEx extends LinearLayout implements OnClickListener{
	private final String LOG_TAG = "GridLayoutEx";
	/** 数据操作类型*/
	public static final int INPUT_TYPE_MONEY = 1001;
	public static final int INPUT_TYPE_NUM = 1002;
	
	public KeyboardLayoutEx(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		initView();
	}
	
	public KeyboardLayoutEx(Context context) {
		super(context);
		this.mContext = context;
		initView();
	}

	
	private Context mContext;
	
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
	}
	
	void initView()
	{
		View gridLayout = LayoutInflater.from(mContext).inflate(R.layout.component_keyboard, null);
		
		gridLayout.findViewById(R.id.key_0).setOnClickListener(this);
		gridLayout.findViewById(R.id.key_1).setOnClickListener(this);
		gridLayout.findViewById(R.id.key_2).setOnClickListener(this);
		gridLayout.findViewById(R.id.key_3).setOnClickListener(this);
		gridLayout.findViewById(R.id.key_4).setOnClickListener(this);
		gridLayout.findViewById(R.id.key_5).setOnClickListener(this);
		gridLayout.findViewById(R.id.key_6).setOnClickListener(this);
		gridLayout.findViewById(R.id.key_7).setOnClickListener(this);
		gridLayout.findViewById(R.id.key_8).setOnClickListener(this);
		gridLayout.findViewById(R.id.key_9).setOnClickListener(this);
		gridLayout.findViewById(R.id.key_del).setOnClickListener(this);
	
		addView(gridLayout);
	}
	
	private EditText mEditView;
	private int inputType = -1;
	
	/**
	 * 
	 * @Author: Huangweicai
	 * @Date: 2015-4-27 下午5:38:38
	 * @Reason: 设置控件和类型
	 */

	public void setEditView(EditText mEditView,int inputType)
	{
		this.mEditView = mEditView;
		this.inputType = inputType;
	}
	

	@Override
	public void onClick(View v) {
		if (mEditView == null)
		{
			Log.e(LOG_TAG, "==============textView is null,please set textView=============");
			return ;
		}
		int viewId = v.getId();
		String tag = v.getTag().toString();
		if(viewId == R.id.key_del)
		{
			switch (inputType) {
			case INPUT_TYPE_MONEY:
				delMoney(tag);
				break;
			case INPUT_TYPE_NUM:
				delNum(tag);
				break;
			}
		}else{
			switch (inputType){
			case INPUT_TYPE_MONEY:
				inputMoney(tag);
				break;
			case INPUT_TYPE_NUM:
				inputNum(tag);
				break;
			default:
				break;
			}
		}
	}
	
	private void inputMoney(String tag)
	{
		String text = Tools.inputMoney(mEditView.getText().toString(), tag);
		mEditView.setText(text);
	}
	
	private void inputNum(String tag)
	{
		String text = Tools.inputNumber(mEditView.getText().toString(), tag);
		mEditView.setText(text);
	}
	
	private void delMoney(String tag)
	{
		String text = Tools.deleteMoney(mEditView.getText().toString());
		mEditView.setText(text);
	}
	
	private void delNum(String tag)
	{
		String text = Tools.deleteNumber(mEditView.getText().toString());
		mEditView.setText(text);
	}
	

}
