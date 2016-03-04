package com.neomades.slidemenuexample.slidemenu.base;

/**
 * Model for an item in the ListView used in the left and right slide menu.
 */
public class SlidingMenuItem {

	private int id;
	private int icon;
	private String text;
	private int count = 0;

	public SlidingMenuItem(int id, String text, int image) {
		this.id = id;
		this.text = text;
		this.icon = image;
	}

	public int getId() {
		return id;
	}

	public int getIcon() {
		return icon;
	}

	public String getText() {
		return text;
	}

	public int getCount() {
		return count;
	}

}
