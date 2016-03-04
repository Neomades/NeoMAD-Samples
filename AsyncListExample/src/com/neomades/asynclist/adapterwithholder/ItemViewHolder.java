package com.neomades.asynclist.adapterwithholder;

import com.neomades.asynclist.Fonts;
import com.neomades.asynclist.Res;
import com.neomades.asynclist.model.Item;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;

public class ItemViewHolder {
	public TextLabel titleTextLabel;
	public TextLabel descTextLabel;
	public ImageLabel pictureTextLabel;
	public Item model;

	public void updateView(Item model) {
		this.model = model;

		titleTextLabel.setText(model.getName());
		descTextLabel.setText(model.getDetails());
		pictureTextLabel.setImage(model.getPicture());
	}

	public static View buildConvertView() {
		View convertView;
		convertView = View.inflateXML(Res.layout.ITEM);
		ItemViewHolder holder = new ItemViewHolder();
		convertView.setTag(holder);

		holder.titleTextLabel = (TextLabel) convertView.findView(Res.id.item_title);
		holder.titleTextLabel.setFont(Fonts.itemTitleFont);
		holder.descTextLabel = (TextLabel) convertView.findView(Res.id.item_desc);
		holder.pictureTextLabel = (ImageLabel) convertView.findView(Res.id.item_picture);
		return convertView;
	}
}
