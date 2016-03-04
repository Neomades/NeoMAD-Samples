package com.neomades.notificationexample.screens;

import com.neomades.app.Screen;
import com.neomades.graphics.Color;
import com.neomades.notification.push.PushServiceManager;
import com.neomades.notificationexample.NotificationExample;
import com.neomades.notificationexample.Res;
import com.neomades.notificationexample.screens.listener.PushRegistrationChangedListener;
import com.neomades.ui.Button;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.dialog.WaitDialog;
import com.neomades.ui.listeners.ClickListener;

public class PushNotificationScreen extends Screen implements ClickListener, PushRegistrationChangedListener {

	private PushServiceManager pushService;

	private TextLabel textlabelStatus;
	private TextLabel textlabelCurrentID;
	private Button buttonRegister;

	protected void onCreate() {
		setTitle("Push Notifications");
		setContent(Res.layout.PUSH_NOTIFICATION_SCREEN);

		// Link view to listeners and screen
		textlabelStatus = (TextLabel) findView(Res.id.labelPushServiceStatus);
		textlabelCurrentID = (TextLabel) findView(Res.id.labelPushServiceCurrentID);
		buttonRegister = (Button) findView(Res.id.buttonRegister);
		buttonRegister.setClickListener(this);

		// attach push service state listener to this screen
		NotificationExample.getExampleApplication().setPushRegistrationChangedListener(this);

		// update view from service state
		pushService = PushServiceManager.getDefault();
		setServiceRegistered(pushService.isRegistered());
	}

	protected void onDestroy() {
		super.onDestroy();

		// detach it from application
		NotificationExample.getExampleApplication().setPushRegistrationChangedListener(null);
	}

	public void onPushRegistrationChanged(final boolean isRegistered) {
		controller.runOnUiThread(new Runnable() {
			public void run() {
				// start by hiding the wait dialog if present
				controller.hideDialog();

				// update the UI
				setServiceRegistered(isRegistered);
			}
		});
	}

	/**
	 * Called by Application to notify service status changes.
	 * 
	 * @param isRegistered
	 */
	private void setServiceRegistered(boolean isRegistered) {

		String status = null;
		String buttonRegisterText = null;
		String currentRegistrationId = "";
		Color statusColor;

		if (isRegistered) {
			status = "REGISTERED";
			statusColor = Color.BLUE;
			buttonRegisterText = "Unregister";
			currentRegistrationId = "" + pushService.getCurrentID();
		} else {
			status = "NOT REGISTERED";
			statusColor = Color.RED;
			buttonRegisterText = "Register";
		}

		textlabelStatus.setText(status);
		textlabelStatus.setTextColor(statusColor);
		textlabelCurrentID.setText(currentRegistrationId);
		buttonRegister.setText(buttonRegisterText);
	}

	public void onClick(View view) {
		registerPushService();
	}

	private void registerPushService() {
		WaitDialog alert = new WaitDialog();
		if (pushService.isRegistered()) {
			alert.setMessage("Unregistration pending...");
			controller.showDialog(alert);
			pushService.unregister();
		} else {
			alert.setMessage("Registration pending...");
			controller.showDialog(alert);
			pushService.register();
		}
	}

}