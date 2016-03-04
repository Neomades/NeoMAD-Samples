package com.neomades.rssreader.screens.list;

import com.neomades.rssreader.model.RSSFeedList;
import com.neomades.ui.ListAdapter;
import com.neomades.ui.View;

/**
 *
 */
public class RSSFeedListAdapter implements ListAdapter {

	private RSSFeedList model = new RSSFeedList();

	/**
	 * @param list
	 */
	public void setItems(RSSFeedList list) {
		RSSFeedList plist = list;
		if (plist == null) {
			plist = new RSSFeedList();
		}
		model = plist;
	}

	public View getView(int atIndex, View itemView, View parent) {

		RSSFeedItem item;
		if (itemView == null) {
			// creates a new one
			item = new RSSFeedItem();
			itemView = item.getUI();
		} else {
			// re-use the view
			item = (RSSFeedItem) itemView.getTag();
		}

		item.update(model.get(atIndex));
		return itemView;
	}

	public int getCount() {
		return model.size();
	}

}
