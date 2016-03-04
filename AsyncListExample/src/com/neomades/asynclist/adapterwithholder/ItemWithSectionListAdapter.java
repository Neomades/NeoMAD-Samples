package com.neomades.asynclist.adapterwithholder;

import java.util.Vector;

import com.neomades.asynclist.model.Element;
import com.neomades.asynclist.model.Item;
import com.neomades.asynclist.model.Section;
import com.neomades.ui.ItemTypeAdapter;
import com.neomades.ui.ListAdapter;
import com.neomades.ui.View;

public class ItemWithSectionListAdapter implements ListAdapter, ItemTypeAdapter {

	private static final int TYPE_ITEM = 0;

	private static final int TYPE_SECTION = 1;

	// Contains Item or Section
	private Vector items;

	public ItemWithSectionListAdapter(Vector items) {
		this.items = items;
	}

	public boolean areAllItemsEnabled() {
		// sections are disabled, items are enabled
		return false;
	}

	public boolean isEnabled(int position) {
		// items are enabled
		return getItemViewType(position) == TYPE_ITEM;
	}

	public int getItemViewType(int position) {
		return getModelAtPosition(position).hasChildren() ? TYPE_SECTION : TYPE_ITEM;
	}

	public int getViewTypeCount() {
		// TYPE_SECTION or TYPE_ITEM
		return 2;
	}

	public int getCount() {
		return items.size();
	}

	public View getView(int position, View convertView, View list) {
		int type = getItemViewType(position);

		if (type == TYPE_ITEM) {

			ItemViewHolder viewHolder;
			if (convertView == null) {
				convertView = ItemViewHolder.buildConvertView();
			}
			viewHolder = (ItemViewHolder) convertView.getTag();
			Item model = (Item) getModelAtPosition(position);
			viewHolder.updateView(model);

		} else if (type == TYPE_SECTION) {

			SectionViewHolder viewHolder;
			if (convertView == null) {
				convertView = SectionViewHolder.buildConvertView();
			}
			viewHolder = (SectionViewHolder) convertView.getTag();
			Section model = (Section) getModelAtPosition(position);
			viewHolder.updateView(model);

		}

		return convertView;
	}

	private Element getModelAtPosition(int position) {
		return (Element) items.elementAt(position);
	}

	public Item getModelFromView(View view) {
		return ((ItemViewHolder) view.getTag()).model;
	}
}
