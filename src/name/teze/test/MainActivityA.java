package name.teze.test;

import name.teze.layout.lib.SwipeBackActivity;

import name.teze.swipebacklayout.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

/**功能：
 * MainActivityA
 * @author   by Fooyou  2014年5月7日   上午11:20:14
 */
public class MainActivityA extends SwipeBackActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSwipeEnable(false);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void buttononClick(View v){
		Intent intent=new Intent(this, MainActivityB.class);
		startActivity(intent);
	}
}
