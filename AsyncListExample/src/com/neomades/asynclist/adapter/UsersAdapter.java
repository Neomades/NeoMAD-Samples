package com.neomades.asynclist.adapter;

import java.util.Vector;

import com.neomades.asynclist.adapter.base.ItemBuilder;
import com.neomades.asynclist.adapter.base.ListViewItem;
import com.neomades.asynclist.adapter.base.SimpleListAdapter;

public class UsersAdapter extends SimpleListAdapter {

	private Vector items;

	public UsersAdapter() {
		setItemBuilder(new ItemBuilder() {
			public ListViewItem buildItem() {
				return new UserItem();
			}
		});
	}

	public void setModel(Vector items) {
		this.items = items;
	}

	public ListViewItem buildItem() {
		return new UserItem();
	}

	public int getCount() {
		return items.size();
	}

	public Object getModelAtIndex(int index) {
		return items.elementAt(index);
	}
}
