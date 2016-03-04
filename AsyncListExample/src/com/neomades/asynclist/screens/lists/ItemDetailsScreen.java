package com.neomades.asynclist.screens.lists;

import com.neomades.app.Screen;
import com.neomades.asynclist.Res;
import com.neomades.asynclist.model.Item;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.TextLabel;

public class ItemDetailsScreen extends Screen {

	public static final String PARAMS_ITEM = "PARAMS_ITEM";

	protected void onCreate() {
		setContent(Res.layout.ITEM);
		setTitle("Item Details");

		Item item = (Item) getScreenParams().getObject(PARAMS_ITEM);

		TextLabel title = (TextLabel) findView(Res.id.item_title);
		TextLabel desc = (TextLabel) findView(Res.id.item_desc);
		ImageLabel picture = (ImageLabel) findView(Res.id.item_picture);

		if (item != null) {
			title.setText(item.getName());
			desc.setText(item.getDetails());
			picture.setImage(item.getPicture());

		} else {
			title.setText("No Name");
			desc.setText("No desc");
			picture.setImage(Res.image.ITEM_NO_PICTURE);

		}
	}

}
