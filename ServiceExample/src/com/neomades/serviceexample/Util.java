package com.neomades.serviceexample;

import com.neomades.notification.Notification;

public final class Util {

	private static final long[] VIBRATION_DURATION = new long[] { 0, 2000 };

	private Util() {
		// Hide the constructor because this is an utility class.
	}

	/**
	 * Builder for local notification generated in each service
	 * 
	 * @param title
	 *            the title of the notification
	 * @param text
	 *            the text of the notification
	 * @return the created local notification
	 */
	public static Notification buildNotification(String title, String text) {

		Notification localNotif = new Notification();
		localNotif.setTitle(title);
		localNotif.setText(text);
		localNotif.setIcon(Res.image.NOTIF_ICON);
		localNotif.setVibration(VIBRATION_DURATION);
		localNotif.setAccessoryIcon(Res.image.ACCESSORY_ICON);
		localNotif.setLaunchImage(Res.image.LAUNCH_IMG);
		localNotif.setSound(Res.music.SOUND_NOTIF);

		return localNotif;
	}

}
