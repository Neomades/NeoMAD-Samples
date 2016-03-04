package com.neomades.rssreader.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Vector;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.neomades.content.parser.Parser;
import com.neomades.rssreader.model.RSSFeed;
import com.neomades.rssreader.model.RSSFeedList;
import com.neomades.xml.XmlPullParserFactory;

/**
 * RSS Feeds parser (parse Neomades twitter rss stream)
 */
public class FeedParser implements Parser {

	private static final String XML_RSS_ITEM = "item";

	private static final Vector feedAttributes = new Vector();

	static {
		String[] attr = { "title", "link", "description", "published", "id", "author", "content", "entry" };
		for (int j = 0; j < attr.length; j++) {
			feedAttributes.addElement(attr[j]);
		}

	}

	private static final String ENCODING = null;

	/**
	 * If the name is an attribute of Feed class
	 * 
	 * @param name
	 *            attribute name
	 * @return true if it is attribute to read from XML
	 */
	public static boolean isTag(String name) {
		return feedAttributes.contains(name);
	}

	/**
	 * @param a
	 *            first string
	 * @param b
	 *            second string
	 * @return true if are equals
	 */
	private static boolean equalsIgnoreCase(String a, String b) {
		return a.trim().toLowerCase().equals(b.trim().toLowerCase());
	}

	public byte[] serialize(Object object) {
		// not used for upload data
		return null;
	}

	public Object deserialize(byte[] data) {
		try {
			return toRSSFeedList(data, ENCODING);
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Converts XML String to RSSFeed list.
	 * 
	 * @param data
	 *            XML string byte array
	 * @param encoding
	 *            string encoding
	 * 
	 * @return RSSFeed list
	 * @throws XmlPullParserException
	 *             if a XML error happens
	 * @throws IOException
	 *             a XML tag error happens
	 */
	private RSSFeedList toRSSFeedList(byte[] data, String encoding) throws XmlPullParserException, IOException {
		ByteArrayInputStream xmlData = new ByteArrayInputStream(data);

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(false);
		XmlPullParser xpp = factory.newPullParser();
		xpp.setInput(xmlData, encoding);

		RSSFeedList rssList = new RSSFeedList();
		RSSFeed rssItem = null;

		int eventType = xpp.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			String xppName = xpp.getName();
			if (eventType == XmlPullParser.START_TAG) {

				if (equalsIgnoreCase(xppName, XML_RSS_ITEM)) {
					// Declares a new RSSFeed
					rssItem = new RSSFeed();
					rssList.add(rssItem);

				} else if (rssItem != null) {
					// Fill RSSFeed
					readTag(xppName, xpp.nextText(), rssItem);

				}

			} else if (rssItem != null && eventType == XmlPullParser.END_TAG && equalsIgnoreCase(xppName, XML_RSS_ITEM)) {
				rssItem = null;
			}
			// move to next element
			eventType = xpp.next();
		}

		return rssList;
	}

	/**
	 * Calls the Feed setter corresponding to XML attribute.
	 * 
	 * @param name
	 *            XML attribute name
	 * @param value
	 *            XML attribute value
	 * @param feed
	 *            Feed model
	 */
	private void readTag(String name, String value, RSSFeed feed) {
		if (isTag(name) && feed != null) {
			if (equalsIgnoreCase("title", name)) {
				feed.setTitle(value);
			} else if (equalsIgnoreCase("description", name)) {
				feed.setDescription(value);
			} else if (equalsIgnoreCase("link", name)) {
				feed.setLink(value);
			} else if (equalsIgnoreCase("author", name)) {
				feed.setAuthor(value);
			} else if (equalsIgnoreCase("content", name)) {
				feed.setContent(value);
			} else if (equalsIgnoreCase("entry", name)) {
				feed.setEntry(value);
			} else if (equalsIgnoreCase("id", name)) {
				feed.setId(value);
			} else if (equalsIgnoreCase("published", name)) {
				feed.setPublished(value);
			}

		}
	}

}
