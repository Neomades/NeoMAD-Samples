package com.neomades.asynclist.adapter.base;

import com.neomades.ui.View;

/**
 *
 */
public interface ListViewItem {

	/**
	 * @param model
	 */
	public void update(Object model);

	/**
	 * @return
	 */
	public View getView();

}
