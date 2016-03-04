package com.neomades.rssreader.screens.list;

import com.neomades.ui.View;

public interface Item {

	/**
	 * @return the item view
	 */
	View getUI();

	/**
	 * Updates View from Model
	 * 
	 * @param model
	 */
	void update(Object model);

}
