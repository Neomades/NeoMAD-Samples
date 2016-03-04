package com.neomades.notificationexample.screens;

import com.neomades.app.Screen;
import com.neomades.ui.ListView;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ItemClickedListener;

public class MainScreen extends Screen implements ItemClickedListener {

	private static final int VERTICAL_PADDING = 12;

	private static final String TAG_LOCAL_NOTIFICATION = "TAG_LOCAL_NOTIFICATION";

	private static final String TAG_PUSH_NOTIFICATION = "TAG_PUSH_NOTIFICATION";

	/**
	 * @param text
	 * @param tag
	 * @return
	 */
	private static View buildItem(String text, String tag) {
		TextLabel label = new TextLabel(text);
		label.setTag(tag);
		label.setPaddingTop(VERTICAL_PADDING);
		label.setPaddingBottom(VERTICAL_PADDING);

		return label;
	}

	protected void onCreate() {
		setTitle("Notification Example");

		ListView list = new ListView();
		list.setStretchMode(MATCH_PARENT, MATCH_PARENT);
		list.addView(buildItem("Local Notification", TAG_LOCAL_NOTIFICATION));
		list.addView(buildItem("Push Notification", TAG_PUSH_NOTIFICATION));
		list.setItemClickedListener(this);
		setContent(list);
	}

	public void onItemClicked(int index, View child) {
		Object tag = child.getTag();
		if (TAG_LOCAL_NOTIFICATION.equals(tag)) {
			controller.pushScreen(LocalNotificationScreen.class);

		} else if (TAG_PUSH_NOTIFICATION.equals(tag)) {
			controller.pushScreen(PushNotificationScreen.class);

		}
	}

}
