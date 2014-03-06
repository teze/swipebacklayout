package com.teze.testslidingpanelayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivityC extends SwipeBackActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSwipeEnable(true);
		setContentView(R.layout.activity_c);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_activity_c, menu);
		return true;
	}
	
	public void buttononClick(View v){
		Intent intent=new Intent(this, MainActivityA.class);
		startActivity(intent);
	}

}
