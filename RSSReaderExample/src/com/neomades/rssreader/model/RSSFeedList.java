package com.neomades.rssreader.model;

import java.util.Vector;

public class RSSFeedList {

	private final Vector items = new Vector();
	
	public void add(RSSFeed rssItem) {
		items.addElement(rssItem);
	}

	public RSSFeed get(int i) {
		return (RSSFeed)items.elementAt(i);
	}

	public int size() {
		return items.size();
	}
}
