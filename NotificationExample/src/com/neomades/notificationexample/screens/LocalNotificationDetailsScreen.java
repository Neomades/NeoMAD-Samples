package com.neomades.notificationexample.screens;

import com.neomades.app.Screen;
import com.neomades.app.ScreenParams;
import com.neomades.notificationexample.Res;
import com.neomades.ui.TextLabel;

public class LocalNotificationDetailsScreen extends Screen {

	public static final String PARAM_LOCAL_MESSAGE = "LocalNotification";

	protected void onCreate() {
		setTitle("Local Notification Details");
		setContent(Res.layout.LOCAL_NOTIFICATION_DETAILS_SCREEN);

		// Retrieve the local notification Message
		ScreenParams params = getScreenParams();
		String message = params.getString(PARAM_LOCAL_MESSAGE);

		// Update views from model
		TextLabel messageDescLabel = (TextLabel) findView(Res.id.labelMessageDesc);
		messageDescLabel.setText(message);

	}

}