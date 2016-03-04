package com.neomades.rssreader.model;

public class RSSFeed {

	private String title;
	private String link;
	private String description;
	private String published;
	private String id;
	private String author;
	private String content;

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public String getPublished() {
		return published;
	}

	public String getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	public String getEntry() {
		return entry;
	}

	private String entry;

	public void setTitle(String ptitle) {
		// Split title to the first ':'
		int end = ptitle.indexOf(':');
		String title;
		if (end != -1) {
			title = ptitle.substring(0, end);
		} else {
			title = ptitle;
		}
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getImageUrl() {
		// return always the same url in our example
		return "https://pbs.twimg.com/profile_images/525656682139889664/6S-3B9_k_normal.png";
	}

}
