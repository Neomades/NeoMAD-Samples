package com.neomades.slidemenuexample.slidemenu.base;

import java.util.Vector;

import com.neomades.app.Screen;
import com.neomades.graphics.Color;
import com.neomades.ui.ListAdapter;
import com.neomades.ui.ListView;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ItemClickedListener;

/**
 * Base class for left and right screen. The screen will contain a ListView
 * filled with an adapter.
 */
public abstract class SlidingPaneScreen extends Screen implements ListAdapter, ItemClickedListener {
	
	private static final int DARK_GREY = 0x303030;

	/**
	 * ListView main component of this screen.
	 */
	private ListView list;

	/**
	 * Items in the ListView.
	 */
	private Vector items = new Vector();
	
	/*
	 * Called at screen initialization.
	 * 
	 * @see com.neomades.app.Screen#onCreate()
	 */
	protected void onCreate() {
		
		// Build the screen content
		list = new ListView();
		list.setStretchMode(MATCH_PARENT, MATCH_PARENT);
		list.setListAdapter(this);
		list.setItemClickedListener(this);
		list.setSeparatorVisible(false);
		setContent(list);
		setBackgroundColor(Color.rgb(DARK_GREY));
		list.setBackgroundColor(Color.rgb(DARK_GREY));
		
		// Fill the list
		onCreateItems();
	}
	
	/*
	 * Called when an item of the list is clicked.
	 * 
	 * @see com.neomades.ui.listeners.ItemClickedListener#onItemClicked(int, com.neomades.ui.View)
	 */
	public void onItemClicked(int index, View child) {		
		onItemClicked(((SlidingMenuItemHolder)child.getTag()).getModel());
	}
	
	/**
	 * Define the behavior of an item of the list when it is clicked.
	 * 
	 * @param item
	 *            the clicked item
	 */
	public abstract void onItemClicked(SlidingMenuItem item);

	/*
	 * Called by the ListView when it requires items to fill the list.
	 * 
	 * @see com.neomades.ui.ListAdapter#getView(int, com.neomades.ui.View, com.neomades.ui.View)
	 */
	public View getView(int atIndex, View convertView, View parent) {
		SlidingMenuItem item = (SlidingMenuItem)items.elementAt(atIndex);
		
		// Item at this index does not exist, create it
		if (convertView == null) {
			convertView = new SlidingMenuItemHolder().buildView();
		}
		
		// Update the view at this index
		SlidingMenuItemHolder itemView = (SlidingMenuItemHolder)convertView.getTag();
		itemView.update(item);
		
		return convertView;
	}

	/*
	 * Called by the ListView to now its number of item.
	 * 
	 * @see com.neomades.ui.ListAdapter#getCount()
	 */
	public int getCount() {
		return items.size();
	}

	/**
	 * Add an item to the ListView and update it.
	 * 
	 * @param item
	 *            item to add to the list
	 */
	public void addItem(SlidingMenuItem item) {
		items.addElement(item);
		list.notifyDataChanged();
	}

	/**
	 * Define the way the items Vector is filled.
	 */
	protected abstract void onCreateItems();
	

}
