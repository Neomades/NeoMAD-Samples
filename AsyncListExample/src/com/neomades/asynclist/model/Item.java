package com.neomades.asynclist.model;

import com.neomades.asynclist.Res;

/**
 * model item
 */
public class Item extends Element {

	private String details;

	private int picture = Res.image.ITEM_NO_PICTURE;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getPicture() {
		return picture;
	}

	public void setPicture(int picture) {
		this.picture = picture;
	}

}
