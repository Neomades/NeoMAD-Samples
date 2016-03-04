package com.neomades.asynclist.adapter.base;

import com.neomades.ui.ItemTypeAdapter;
import com.neomades.ui.ListAdapter;
import com.neomades.ui.View;

/**
 * ListAdapter and ItemTypeAdapter
 */
public abstract class BaseListAdapter implements ListAdapter, ItemTypeAdapter {

	/**
	 * @param index
	 * @return
	 */
	public abstract Object getModelAtIndex(int index);

	public abstract boolean areAllItemsEnabled();

	public abstract boolean isEnabled(int index);

	public abstract int getItemViewType(int index);

	public abstract int getViewTypeCount();

	public abstract int getCount();

	public abstract View getView(int index, View convertView, View parentView);

}
