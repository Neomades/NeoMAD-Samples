package com.neomades.asynclist.adapter;

import java.util.Vector;

import com.neomades.asynclist.adapter.base.ItemBuilder;
import com.neomades.asynclist.adapter.base.ListViewItem;
import com.neomades.asynclist.adapter.base.MultiTypeAdapter;
import com.neomades.asynclist.model.Item;

public class UsersWithSectionAdapter extends MultiTypeAdapter {

	private static final int USER = 0;
	private static final int SECTION = 1;
	private Vector items = new Vector();

	public UsersWithSectionAdapter() {
		addItemType(USER, true, new ItemBuilder() {
			public ListViewItem buildItem() {
				return new UserItem();
			}
		});
		addItemType(SECTION, false, new ItemBuilder() {
			public ListViewItem buildItem() {
				return new SectionItem();
			}
		});
	}

	public void setModel(Vector items) {
		this.items = items;
	}

	public int getCount() {
		return items.size();
	}

	public int getItemViewType(int index) {
		Item item = (Item) getModelAtIndex(index);
		if (item.hasChildren()) {
			return SECTION;
		} else {
			return USER;
		}
	}

	public Object getModelAtIndex(int index) {
		return items.elementAt(index);
	}

}
