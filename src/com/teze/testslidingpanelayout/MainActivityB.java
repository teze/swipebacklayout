package com.teze.testslidingpanelayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.teze.testslidingpanelayout.SlidingPaneLayout.PanelSlideListener;

public class MainActivityB extends Activity implements PanelSlideListener{

	private TextView localViewTemp;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		listView = (ListView) findViewById(R.id.listView);

		ListViewAdapter mAdapter=new ListViewAdapter(this);
		listView.setAdapter( mAdapter);
		for (int i = 0; i < 200; i++) {
			TestInfo item=new TestInfo();
			item.setName("测试"+i);
			mAdapter.addItem(item);
		}
		mAdapter.notifyDataSetChanged();
		
	}
	
	
	public void buttononClick(View v){
		Intent intent=new Intent(this, MainActivityC.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onPanelClosed(View arg0) {
		
	}

	@Override
	public void onPanelOpened(View arg0) {
		super.finish();
	}

	@Override
	public void onPanelSlide(View arg0, float arg1) {
		
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
		View localView = localViewGroup.getChildAt(0);
		localViewGroup.removeView(localView);
		SlidingPaneLayout slidingPaneLayout=new SlidingPaneLayout(this);
		slidingPaneLayout.setPanelSlideListener(this);
		slidingPaneLayout.setSliderFadeColor(Color.RED);
		slidingPaneLayout.setShadowDrawable(getResources().getDrawable(R.color.beta));
		slidingPaneLayout.setCoveredFadeColor(Color.GREEN);
		/*slidingPaneLayout.setBackgroundColor(Color.alpha(0));*/
		
		localViewTemp=new TextView(this);
		/*localViewTemp.setTextColor(getResources().getColor(R.color.beta));
		localViewTemp.setBackgroundResource(android.R.color.black);*/
		ViewHelper.setAlpha(localViewTemp, 0.0f);
		ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
		slidingPaneLayout.addView(localViewTemp, localLayoutParams);
		slidingPaneLayout.addView(localView);
		localViewGroup.addView(slidingPaneLayout);
		/*getWindow().setBackgroundDrawableResource(R.color.alpa);*/
	}
}
