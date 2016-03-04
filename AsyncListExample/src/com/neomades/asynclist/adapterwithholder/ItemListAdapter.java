package com.neomades.asynclist.adapterwithholder;

import java.util.Vector;

import com.neomades.asynclist.Fonts;
import com.neomades.asynclist.Res;
import com.neomades.asynclist.model.Item;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.ListAdapter;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;

/**
 * Adapts Vector<Item> to ListView.
 */
public class ItemListAdapter implements ListAdapter {

	/**
	 * ViewHolder pattern
	 */
	public static class ViewHolder {
		TextLabel titleTextLabel;
		TextLabel descTextLabel;
		ImageLabel pictureTextLabel;
		Item model;
	}

	/** model */
	private Vector items;

	// === ListAdapter callback methods === //

	/**
	 * Creates an adapter.
	 * 
	 * @param items
	 *            model
	 */
	public ItemListAdapter(Vector items) {
		this.items = items;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neomades.ui.ListAdapter#getCount()
	 */
	public int getCount() {
		// number of items inside the ListView
		return items.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neomades.ui.ListAdapter#getView(int, com.neomades.ui.View,
	 * com.neomades.ui.View)
	 */
	public View getView(int position, View convertView, View list) {

		// Build a new Item view or reuse the convertView parameter
		if (convertView == null) {
			convertView = buildListItemView();
		}

		// Update item from model
		updateListItemView(position, convertView);

		return convertView;
	}

	// === internal methods === //

	/**
	 * Updates a ListView's item with model at the specified position in the
	 * list.
	 * 
	 * @param position
	 *            position of the view inside the list
	 * @param convertView
	 *            the view to update
	 */
	private void updateListItemView(int position, View convertView) {
		ViewHolder holder = getHolderFromView(convertView);
		Item item = getItemAtPosition(position);

		holder.model = item;

		holder.titleTextLabel.setText(item.getName());
		holder.descTextLabel.setText(item.getDetails());
		holder.pictureTextLabel.setImage(item.getPicture());
	}

	/**
	 * Creates a new ListView's item.
	 * 
	 * @return a view with {@link ViewHolder}
	 */
	private View buildListItemView() {
		View convertView;
		convertView = View.inflateXML(Res.layout.ITEM);
		ViewHolder holder = new ViewHolder();
		convertView.setTag(holder);

		holder.titleTextLabel = (TextLabel) convertView.findView(Res.id.item_title);
		holder.titleTextLabel.setFont(Fonts.itemTitleFont);
		holder.descTextLabel = (TextLabel) convertView.findView(Res.id.item_desc);
		holder.pictureTextLabel = (ImageLabel) convertView.findView(Res.id.item_picture);
		return convertView;
	}

	/**
	 * Internal method.
	 * 
	 * @param position
	 *            position inside the list
	 * @return the model object.
	 */
	private Item getItemAtPosition(int position) {
		return (Item) items.elementAt(position);
	}

	/**
	 * Returns the model item from a ListView's item.
	 * 
	 * @param convertView
	 *            list view item
	 * @return the corresponding model object.
	 */
	public Item getModelFromView(View convertView) {
		return getHolderFromView(convertView).model;
	}

	/**
	 * Returns the view holder from view.
	 * 
	 * @param convertView
	 *            list view item
	 * @return the corresponding holder
	 */
	private ViewHolder getHolderFromView(View convertView) {
		return ((ViewHolder) convertView.getTag());
	}

}
