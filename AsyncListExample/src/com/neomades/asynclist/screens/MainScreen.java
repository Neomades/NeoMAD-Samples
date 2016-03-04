package com.neomades.asynclist.screens;

import com.neomades.app.Screen;
import com.neomades.asynclist.screens.lists.AsyncListScreen;
import com.neomades.asynclist.screens.lists.AsyncListWithSectionScreen;
import com.neomades.ui.ListView;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ItemClickedListener;

public class MainScreen extends Screen implements ItemClickedListener {

	protected void onCreate() {
		setTitle("Async List Example");
		ListView list = new ListView();
		list.setItemClickedListener(this);
		setContent(list);

		list.addView(buildItem("List with simple items", AsyncListScreen.class));
		list.addView(buildItem("List with item and section", AsyncListWithSectionScreen.class));
	}

	private TextLabel buildItem(String text, Class screen) {
		TextLabel label = new TextLabel(text);
		label.setPaddingTop(20);
		label.setPaddingBottom(20);
		label.setTag(screen);
		return label;
	}

	public void onItemClicked(int index, View element) {
		Class screen = (Class) element.getTag();
		if (screen != null) {
			controller.pushScreen(screen);
		}
	}

}
