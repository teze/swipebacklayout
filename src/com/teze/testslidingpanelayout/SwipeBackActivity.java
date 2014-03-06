package com.teze.testslidingpanelayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.teze.testslidingpanelayout.SlidingPaneLayout.PanelSlideListener;

public class SwipeBackActivity extends FragmentActivity implements PanelSlideListener{

	private static final String TAG = "SwipeBackActivity";
	private boolean swipeEnable=true;
	private Drawable mShadowDrawable;
	private int mShadowResource=R.drawable.translucent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/*if (BuildConfig.DEBUG)Log.i(TAG, "onCreate");*/
		super.onCreate(savedInstanceState);
	}

	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		/*if (BuildConfig.DEBUG)Log.i(TAG, "onPostCreate >> swipeEnable >> "+swipeEnable);*/
		if (swipeEnable) {
			ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
			View localView = localViewGroup.getChildAt(0);
			localViewGroup.removeView(localView);
			SlidingPaneLayout slidingPaneLayout=new SlidingPaneLayout(this);
			slidingPaneLayout.setPanelSlideListener(this);
			slidingPaneLayout.setSliderFadeColor(getResources().getColor(android.R.color.transparent));
			slidingPaneLayout.setShadowResource(mShadowResource);
			if (mShadowDrawable!=null) {
				slidingPaneLayout.setShadowDrawable(mShadowDrawable);
			}
			slidingPaneLayout.setCoveredFadeColor(getResources().getColor(android.R.color.transparent));
			/*slidingPaneLayout.setBackgroundColor(Color.alpha(0));*/
			
			View localViewTemp=new TextView(this);
			/*localViewTemp.setTextColor(getResources().getColor(R.color.beta));
			localViewTemp.setBackgroundResource(android.R.color.black);*/
			ViewHelper.setAlpha(localViewTemp, 0.0f);
			ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			slidingPaneLayout.addView(localViewTemp, localLayoutParams);
			slidingPaneLayout.addView(localView);
			localViewGroup.addView(slidingPaneLayout);
			getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		}
		super.onPostCreate(savedInstanceState);
	}

	@Override
	public void onPanelSlide(View panel, float slideOffset) {
	}

	@Override
	public void onPanelOpened(View panel) {
		super.finish();
	}

	@Override
	public void onPanelClosed(View panel) {
	}


	public boolean isSwipeEnable() {
		return swipeEnable;
	}


	public void setSwipeEnable(boolean swipeEnable) {
		/*if (BuildConfig.DEBUG)Log.i(TAG, "setSwipeEnable >> swipeEnable >> "+swipeEnable);*/
		this.swipeEnable = swipeEnable;
	}
	
	public void setShadowDrawable(Drawable d) {
		mShadowDrawable = d;
	}

	public void setShadowResource(int resId) {
		mShadowResource=resId;
	}
}
