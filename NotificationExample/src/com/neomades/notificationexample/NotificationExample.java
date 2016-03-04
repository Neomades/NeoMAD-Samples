package com.neomades.notificationexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.app.ScreenParams;
import com.neomades.mad.TargetInfo;
import com.neomades.notification.Notification;
import com.neomades.notification.push.PushMessage;
import com.neomades.notification.push.PushServiceManager;
import com.neomades.notificationexample.screens.LocalNotificationDetailsScreen;
import com.neomades.notificationexample.screens.MainScreen;
import com.neomades.notificationexample.screens.NotSupportedScreen;
import com.neomades.notificationexample.screens.PushMessageDetailsScreen;
import com.neomades.notificationexample.screens.listener.PushRegistrationChangedListener;
import com.neomades.ui.dialog.AlertDialog;

public class NotificationExample extends Application {

	/**
	 * @return the shared instance of this example
	 */
	public static NotificationExample getExampleApplication() {
		return (NotificationExample) Application.getCurrent();
	}

	private PushRegistrationChangedListener pushRegistrationChangedListener;

	/*
	 * Called when a notification arrives and the application is not already
	 * started or called just before onStart()
	 */
	public void onCreate(Controller controller) {
		// Registering must be done each time the application starts
		PushServiceManager service = PushServiceManager.getDefault();
		service.register();

		setActionBarEnabled(true);
	}

	/*
	 * Called when the end-user will launch the application by clicking the
	 * icon.
	 */
	protected void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes first screen
		if (TargetInfo.WINDOWS) {
			controller.pushScreen(NotSupportedScreen.class);
		} else {
			controller.pushScreen(MainScreen.class);
		}
	}

	/*
	 * Called when Push Notification Service has changed its state.
	 */
	protected void onPushRegistrationChanged(int status, String message) {
		if (status == PUSH_FAILURE) {
			showErrorDialog(message);
		} else if (status == PUSH_REGISTERED || status == PUSH_UNREGISTERED) {
			// if there is a push registration changed listener
			// then notify it that push service has changed its state
			if (pushRegistrationChangedListener != null) {
				pushRegistrationChangedListener.onPushRegistrationChanged(PushServiceManager.getDefault().isRegistered());
			}
		}
	}

	private void showErrorDialog(String message) {
		AlertDialog dialog = new AlertDialog();
		dialog.setMessage(message);
		controller.showDialog(dialog);
	}

	/* 
	 * 
	 */
	protected void onPushMessageReceived(PushMessage message) {
		ScreenParams params = new ScreenParams();
		params.putObject(PushMessageDetailsScreen.PARAM_PUSH_MESSAGE, message);

		controller.pushScreen(PushMessageDetailsScreen.class, params);
	}

	/*
	 * 
	 */
	protected void onLocalNotificationReceived(Notification notification) {
		String message = "";
		message += "id : " + notification.getId() + "\n";
		message += "Title : " + notification.getTitle() + "\n";
		message += "Text : " + notification.getText() + "\n";
		message += "Extras: " + notification.getExtras() + "\n";

		ScreenParams params = new ScreenParams();
		params.putString(LocalNotificationDetailsScreen.PARAM_LOCAL_MESSAGE, message.toString());
		controller.pushScreen(LocalNotificationDetailsScreen.class, params);
	}

	public void setPushRegistrationChangedListener(PushRegistrationChangedListener pushRegistrationChangedListener) {
		this.pushRegistrationChangedListener = pushRegistrationChangedListener;
	}
}
