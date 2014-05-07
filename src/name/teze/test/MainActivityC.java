package name.teze.test;

import name.teze.layout.lib.SwipeBackActivity;

import name.teze.swipebacklayout.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

/**功能：
 * MainActivityC
 * @author   by Fooyou  2014年5月7日   上午11:20:40
 */
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
