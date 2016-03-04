package com.neomades.asynclist.adapter;

import com.neomades.asynclist.Fonts;
import com.neomades.asynclist.Res;
import com.neomades.asynclist.adapter.base.ListViewItem;
import com.neomades.asynclist.model.Item;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;

public class UserItem implements ListViewItem {

	public TextLabel titleTextLabel;
	public TextLabel descTextLabel;
	public ImageLabel pictureTextLabel;

	private View view;

	public UserItem() {
		view = View.inflateXML(Res.layout.ITEM);
		titleTextLabel = (TextLabel) view.findView(Res.id.item_title);
		titleTextLabel.setFont(Fonts.itemTitleFont);
		descTextLabel = (TextLabel) view.findView(Res.id.item_desc);
		pictureTextLabel = (ImageLabel) view.findView(Res.id.item_picture);
	}

	public void update(Object p) {
		titleTextLabel.setText(((Item) p).getName());
		descTextLabel.setText(((Item) p).getDetails());
		pictureTextLabel.setImage(((Item) p).getPicture());
	}

	public View getView() {
		// return view
		return view;
	}

}
