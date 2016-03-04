package com.neomades.rssreader.screens;

import com.neomades.app.Screen;
import com.neomades.content.ContentResponse;
import com.neomades.event.ErrorEvent;
import com.neomades.rssreader.RSSConstants;
import com.neomades.rssreader.model.RSSFeedList;
import com.neomades.rssreader.queries.RSSQuery;
import com.neomades.rssreader.screens.list.RSSFeedListAdapter;
import com.neomades.ui.ListView;
import com.neomades.ui.dialog.AlertDialog;

/**
 * Main Screen that shows a list of feeds
 */
public class RSSMainScreen extends Screen {
	
	private static final String RSS_URL = "http://twitrss.me/twitter_user_to_rss/?user=neomades";

	private RSSFeedListAdapter adapter = new RSSFeedListAdapter();
	
	private ListView list;

	protected void onCreate() {
		// Build UI
		list = new ListView();
		list.setStretchMode(MATCH_PARENT, MATCH_PARENT);
		list.setListAdapter(adapter);
		setContent(list);		

		// Starting to listen RSS events 
		registerEvent(RSSConstants.EVENT_FEED_LIST);
		
		// Getting feeds
		actionGetFeeds();
	}

	/**
	 * Starts to get Feeds
	 */
	private void actionGetFeeds() {
		postQuery(new RSSQuery(RSS_URL));
	}

	/* 
	 * Called when Feeds have been received
	 */
	protected void onReceiveResponse(ContentResponse response) {
		if (response.hasType(RSSConstants.EVENT_FEED_LIST)) {
			onUpdateFeeds((RSSFeedList) response.getValue());
		}
	}

	/**
	 * Update ListView with Feeds
	 * 
	 * @param feeds
	 */
	private void onUpdateFeeds(RSSFeedList feeds) {
		adapter.setItems(feeds);
		list.notifyDataChanged();
	}

	/* 
	 * Called if getting feeds has failed
	 */
	protected void onReceiveError(ErrorEvent error) {
		controller.hideDialog();
		AlertDialog d = new AlertDialog();
		d.setMessage(error.getMessage());
		d.setButtonText("OK");
		controller.showDialog(d);
	}

}
