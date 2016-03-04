package com.neomades.asynclist.adapter.base;

import java.util.Enumeration;
import java.util.Hashtable;

import com.neomades.ui.View;

/**
 *
 */
public abstract class MultiTypeAdapter extends BaseListAdapter {

	class BuilderType {
		public boolean enabled;
		public int type;
		public ItemBuilder builder;
	}

	private Hashtable builders = new Hashtable();

	/**
	 * 
	 */
	public MultiTypeAdapter() {
	}

	/**
	 * @param type
	 * @param enabled
	 * @param builder
	 */
	public void addItemType(int type, boolean enabled, ItemBuilder builder) {
		BuilderType t = new BuilderType();
		t.type = type;
		t.builder = builder;
		t.enabled = enabled;
		builders.put("" + type, t);
	}

	private BuilderType getBuilderType(int index) {
		return null;
	}

	private void updateItem(View convertView, int index) {
		ListViewItem item = (ListViewItem) convertView.getTag();
		if (item != null) {
			item.update(getModelAtIndex(index));
		}
	}

	private View buildItem(int index) {
		ItemBuilder itemBuilder = getBuilderType(index).builder;

		ListViewItem item = itemBuilder.buildItem();
		View view = item.getView();
		if (view.getTag() != null) {
			// ERROR
		}
		view.setTag(itemBuilder);
		return view;
	}

	public final View getView(int index, View convertView, View parentList) {
		if (convertView == null) {
			convertView = buildItem(index);
		}

		updateItem(convertView, index);

		return convertView;
	}

	public boolean areAllItemsEnabled() {
		boolean enabled = true;

		// accumulate areAllItemsEnabled() from all adapters
		Enumeration enu = builders.keys();

		while (enu.hasMoreElements()) {
			enabled &= ((BuilderType) enu.nextElement()).enabled;
			if (!enabled) {
				break;
			}
		}

		return enabled;
	}

	public boolean isEnabled(int index) {
		return ((BuilderType) builders.get("" + getItemViewType(index))).enabled;
	}

	public int getViewTypeCount() {
		return builders.size();
	}

}
