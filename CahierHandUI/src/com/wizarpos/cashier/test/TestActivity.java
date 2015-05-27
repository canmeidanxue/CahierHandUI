package com.wizarpos.cashier.test;

import com.wizarpos.cashier.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class TestActivity extends Activity  {
	private String msg=null;
	AutoCompleteTextView mauto;  
	private String LOG="TestActivity";
    //定义字符串数组，作为提示的文本  
    String[] personData = new String[]  
            {  
                "/dev/ttyUSB0",  
                "/dev/ttyUSB1",  
                "/dev/ttyUSB2",  
                "/dev/ttyUSB3",  
            };  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		ArrayAdapter<String> pp = new ArrayAdapter<String>(  
                this,android.R.layout.simple_dropdown_item_1line,personData);  
        mauto = (AutoCompleteTextView) findViewById(R.id.mauto); 
        mauto.setAdapter(pp); 
        msg=mauto.getText().toString();
        Log.d(msg,LOG);
        mauto.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				msg=mauto.getText().toString();
				  Log.d(msg,LOG);
//				Toast.makeText(TestActivity.this,msg,Toast.LENGTH_SHORT);
				
			}
		});
        
	}
}
