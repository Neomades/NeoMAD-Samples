package com.neomades.locationexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.location.Location;
import com.neomades.location.ProximityRegion;
import com.neomades.locationexample.screen.MainScreen;
import com.neomades.locationexample.screen.NotSupportedScreen;
import com.neomades.mad.TargetInfo;
import com.neomades.notification.Notification;
import com.neomades.notification.NotificationManager;
import com.neomades.ui.dialog.AlertDialog;

/**
 * Entry point
 */
public class LocationExample extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes the first screen
		if (TargetInfo.WINDOWS) {
			controller.pushScreen(NotSupportedScreen.class);
		} else {
			controller.pushScreen(MainScreen.class);
		}
	}

	/**
	 * Converts region and status to human readable message.
	 * 
	 * @param region
	 * @param status
	 * 
	 * @return a readable message
	 */
	private static String toAlertMessage(ProximityRegion region, int status) {
		String message = "";
		switch (status) {
		case PROXIMITY_ENTER_REGION:
			message = "You have just entered this region : ";
			break;

		case PROXIMITY_EXIT_REGION:
			message = "You have just exited this region : ";
			break;

		default:
			break;
		}
		Location center = region.getCenter();
		message += center.getLatitude();
		message += ", ";
		message += center.getLongitude();
		return message;
	}

	/**
	 * Shows an alert dialog with region and status information.
	 * 
	 * @param region
	 * @param status
	 */
	private void popAlert(ProximityRegion region, int status) {
		AlertDialog dialog = new AlertDialog();
		dialog.setMessage(toAlertMessage(region, status));
		controller.showDialog(dialog);
	}

	/**
	 * Shows a notification in the phone status bar.
	 * 
	 * @param region
	 * @param status
	 */
	private void showNotification(ProximityRegion region, int status) {
		NotificationManager notificationManager = NotificationManager.getDefault();
		Notification notification = new Notification();
		notification.setTitle("Proximity alert !");
		notification.setText(toAlertMessage(region, status));
		notificationManager.showNotification(notification);
	}

	protected void onProximityChanged(Location myLocation, final ProximityRegion region, final int status) {
		if (TargetInfo.ANDROID || isBackground()) {
			showNotification(region, status);

		} else {
			// Notification API is not available
			controller.runOnUiThread(new Runnable() {
				public void run() {
					popAlert(region, status);
				}
			});
		}
	}

}
