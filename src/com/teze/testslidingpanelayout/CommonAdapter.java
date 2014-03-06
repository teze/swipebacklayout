package com.teze.testslidingpanelayout;

import java.util.List;
import java.util.Vector;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CommonAdapter <T> extends  BaseAdapter {

	Context mContext;
	List<T> items=new Vector<T>();
	
	
	
	
	public CommonAdapter(Context context) {
		super();
		mContext=context;
	}
	
	public void addItem(T item) {
		items.add(item);
	}
	
	public void removeItem(int item) {
		items.remove(item);
	}
	
	public void clearItem(){
		items.clear();
	}
	
	public void setItems(List<T> item) {
		items=item;
	}
	
	public List<T> getItems() {
		return this.items;
	}
	

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public T getItem(int position) {
		if (position < 0 || position >= items.size()) {
			return null;
		}
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

}
