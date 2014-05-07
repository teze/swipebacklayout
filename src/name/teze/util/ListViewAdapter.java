package name.teze.util;

import name.teze.test.TestInfo;

import name.teze.swipebacklayout.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**功能：
 * ListViewAdapter
 * @author   by Fooyou  2014年5月7日   上午11:19:40
 */
public class ListViewAdapter extends CommonAdapter<TestInfo> {
	
	public ListViewAdapter(Context context) {
		super(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		TestInfo currItem=getItem(position);
		if (convertView==null) {
			convertView =View.inflate(mContext, R.layout.view_item_list, null);
			holder=new ViewHolder();
			holder.name=(TextView) convertView.findViewById(R.id.name);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		holder.name.setText(currItem.getName());
		
		return convertView;
	}

	
	class ViewHolder{
		public  TextView name;
	}
}
