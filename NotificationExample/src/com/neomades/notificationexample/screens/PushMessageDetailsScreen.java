package com.neomades.notificationexample.screens;

import com.neomades.app.Screen;
import com.neomades.app.ScreenParams;
import com.neomades.notification.push.PushMessage;
import com.neomades.notificationexample.Res;
import com.neomades.ui.TextLabel;

public class PushMessageDetailsScreen extends Screen {

	public static final String PARAM_PUSH_MESSAGE = "pmContent";

	protected void onCreate() {
		setTitle("Push Notification Screen");
		setContent(Res.layout.PUSH_MESSAGE_DETAILS_SCREEN);

		// Retrieve the push Message
		ScreenParams params = getScreenParams();
		PushMessage message = (PushMessage) params.getObject(PARAM_PUSH_MESSAGE);
		String messageDescription = "";
		messageDescription += "Message : " + message.getAlertMessage() + "\n";
		messageDescription += "Action : " + message.getAlertAction() + "\n";
		messageDescription += "Badge : " + message.getBadge() + "\n";
		messageDescription += "Sound : " + message.getSound() + "\n";
		messageDescription += "Data : " + message.getData() + "\n";

		// Update views from model
		TextLabel messageDescLabel = (TextLabel) findView(Res.id.labelMessageDesc);
		messageDescLabel.setText(messageDescription);

		TextLabel payloadLabel = (TextLabel) findView(Res.id.labelPayload);
		payloadLabel.setText(message.getPayload());

	}
}
