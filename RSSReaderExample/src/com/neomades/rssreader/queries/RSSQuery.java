package com.neomades.rssreader.queries;

import com.neomades.content.ContentQuery;
import com.neomades.content.Method;
import com.neomades.rssreader.RSSConstants;

/**
 * A {@link ContentQuery} that get RSS Feeds.
 */
public class RSSQuery extends ContentQuery {

	public RSSQuery(String url) {
		super(Method.GET, url);
		// Use a special Cache
		setCacheType(RSSConstants.RSS_CACHE);
		
		// Use a network pipe
		setNetworkType(RSSConstants.HTTP);
		
		// Use RSS Parsers
		setResponseParserType(RSSConstants.FEED_PARSER);
		
		// Sends response over RSS Event
		setContentResponseType(RSSConstants.EVENT_FEED_LIST);
	}

}
