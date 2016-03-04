package com.neomades.asynclist.adapter.base;

import com.neomades.ui.View;

public abstract class SimpleListAdapter extends BaseListAdapter {

	private boolean allItemsEnabled = true;
	private ItemBuilder itemBuilder;

	public final int getViewTypeCount() {
		return 1;
	}

	public final void setItemBuilder(ItemBuilder itemBuilder) {
		this.itemBuilder = itemBuilder;
	}

	public final boolean areAllItemsEnabled() {
		return allItemsEnabled;
	}

	public final void setItemEnabled(boolean areAllItemsEnabled) {
		this.allItemsEnabled = areAllItemsEnabled;
	}

	public final boolean isEnabled(int index) {
		return allItemsEnabled;
	}

	public final int getItemViewType(int index) {
		return 0;
	}

	public final View getView(int index, View convertView, View parentView) {
		if (convertView == null) {
			convertView = buildItem(index);
		}
		updateItem(convertView, index);
		return convertView;
	}

	private void updateItem(View convertView, int index) {
		ListViewItem item = (ListViewItem) convertView.getTag();
		if (item != null) {
			item.update(getModelAtIndex(index));
		}
	}

	private View buildItem(int index) {
		ListViewItem item = itemBuilder.buildItem();
		View view = item.getView();
		if (view.getTag() != null) {
			// ERROR
		}
		view.setTag(itemBuilder);
		return view;
	}

}
