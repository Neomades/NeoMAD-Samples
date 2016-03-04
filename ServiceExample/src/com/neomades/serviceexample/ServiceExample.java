package com.neomades.serviceexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.mad.TargetInfo;
import com.neomades.notification.Notification;
import com.neomades.ui.dialog.AlertDialog;

/**
 * Entry point
 */
public class ServiceExample extends Application {

	/**
	 * Called when the end-user will launch the application by clicking the
	 * icon.
	 */
	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes first screen
		if (TargetInfo.WINDOWS) {
			controller.pushScreen(NotSupportedScreen.class);
		} else {
			controller.pushScreen(MainScreen.class);
		}
	}

	protected void onLocalNotificationReceived(Notification notification) {
		// Show dialog corresponding to the notification sent by the service
		final AlertDialog dialog = new AlertDialog();
		dialog.setTitle(notification.getTitle());
		dialog.setMessage(notification.getText());
		controller.runOnUiThread(new Runnable() {
			public void run() {
				controller.showDialog(dialog);
			}
		});
	}

}