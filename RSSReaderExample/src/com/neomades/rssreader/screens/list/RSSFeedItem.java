package com.neomades.rssreader.screens.list;

import com.neomades.content.image.ImageLoader;
import com.neomades.content.image.ImageUrlLabel;
import com.neomades.content.image.MemoryImageCache;
import com.neomades.graphics.Font;
import com.neomades.rssreader.Res;
import com.neomades.rssreader.model.RSSFeed;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;

/**
 *
 */
public class RSSFeedItem implements Item {
	
	// There is only one image url to load.
	private static final int NB_IMAGES_IN_LRU = 1;
	
	private TextLabel title;
	private TextLabel description;
	private ImageUrlLabel image;

	// Keep Last recent used images in memory cache
	private static ImageLoader loader = new ImageLoader(new MemoryImageCache(NB_IMAGES_IN_LRU));

	public View getUI() {
		// load feed item from Layout XML
		View convertView = View.inflateXML(Res.layout.feedItem);
		convertView.setTag(this);
		
		// reference views to be updated with model
		title = (TextLabel)convertView.findView(Res.id.item_title);
		Font font = Font.createFont(Font.DEFAULT, Font.STYLE_BOLD, 12);
		title.setFont(font);
		
		description = (TextLabel)convertView.findView(Res.id.item_desc);
		
		image = (ImageUrlLabel)convertView.findView(Res.id.item_picture);
		
		return convertView;
	}

	public void update(Object model) {
		RSSFeed feed = (RSSFeed)model;
		
		title.setText(feed.getTitle());
		description.setText(feed.getDescription());
		image.setImageUrl(feed.getImageUrl(), loader);
	}

}
