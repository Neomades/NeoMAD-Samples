package com.neomades.serviceexample.backgroundservices;

import com.neomades.app.Service;
import com.neomades.notification.Notification;
import com.neomades.notification.NotificationManager;
import com.neomades.serviceexample.Util;

public class ServiceImmediate extends Service {

	/**
	 * Called by the system each time the Service must be run.
	 */
	public void onExecute() {
		// Create local notification and notify it
		Notification immediate = Util.buildNotification("Immediate", "This local notification has been sent by the service started immediately.");
		NotificationManager.getDefault().notify(immediate);
	}

}
