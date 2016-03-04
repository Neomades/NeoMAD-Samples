package com.neomades.slidemenuexample.slidemenu.base;

import com.neomades.slidemenuexample.Res;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;

/**
 * Visual representation of an item in the ListView in the left and right slide
 * menu.
 */
public class SlidingMenuItemHolder {

	private ImageLabel imgIcon;
	private TextLabel txtTitle;

	private SlidingMenuItem model;

	/**
	 * Update an existing SlidingMenuItemHolder (update image and text).
	 * 
	 * @param item
	 *            the new model for this SlidingMenuItemHolder
	 */
	public void update(SlidingMenuItem item) {
		// Link holder with model
		this.model = item;

		// Update view
		this.imgIcon.setImage(item.getIcon());
		this.txtTitle.setText(item.getText());

	}

	/**
	 * Build the view (the ListView item).
	 * 
	 * @return the view corresponding to this SlidingMenuItemHolder
	 */
	public View buildView() {
		// Create the view
		View v = View.inflateXML(Res.layout.SLIDING_ITEM);
		this.imgIcon = (ImageLabel) v.findView(Res.id.icon);
		this.txtTitle = (TextLabel) v.findView(Res.id.title);

		// Associate holder to view
		v.setTag(this);

		return v;
	}

	/**
	 * Returns the model corresponding to this SlidingMenuItemHolder.
	 * 
	 * @return the model corresponding to this SlidingMenuItemHolder
	 */
	public SlidingMenuItem getModel() {
		return model;
	}

}
