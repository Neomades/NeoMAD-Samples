package com.neomades.notificationexample.screens;

import java.util.Calendar;
import java.util.Date;

import com.neomades.app.Screen;
import com.neomades.graphics.Color;
import com.neomades.mad.TargetInfo;
import com.neomades.notification.Notification;
import com.neomades.notification.NotificationManager;
import com.neomades.notificationexample.Res;
import com.neomades.ui.Button;
import com.neomades.ui.View;
import com.neomades.ui.dialog.AlertDialog;
import com.neomades.ui.listeners.ClickListener;

public class LocalNotificationScreen extends Screen implements ClickListener {

	protected void onCreate() {
		setTitle("Local Notifications");
		setContent(Res.layout.LOCAL_NOTIFICATION_SCREEN);

		attachClickListener(Res.id.buttonNotifyEvery30Minutes);
		attachClickListener(Res.id.buttonNotifyImmediate);
		attachClickListener(Res.id.buttonNotifyIn15Seconds);
		attachClickListener(Res.id.buttonCancelAll);
	}

	/**
	 * Finds button by Id and attach ClickListener to this screen
	 * 
	 * @param viewId
	 */
	private void attachClickListener(int viewId) {
		Button button = (Button) findView(viewId);
		if (button != null) {
			button.setClickListener(this);
		}
	}

	public void onClick(View view) {

		int id = view.getId();
		switch (id) {
		case Res.id.buttonNotifyImmediate:
			notifyImmediately();
			break;

		case Res.id.buttonNotifyIn15Seconds:
			if (TargetInfo.WINDOWS_PHONE) {
				AlertDialog alert = new AlertDialog();
				alert.setMessage("Windows Phone only enables scheduling of notifications every 30min");
				controller.showDialog(alert);
			} else {
				notifyIn15s();
			}
			break;

		case Res.id.buttonNotifyEvery30Minutes:
			notifyEvery30Minutes();
			break;

		case Res.id.buttonCancelAll:
			cancelAll();
			break;

		default:
			break;
		}
	}

	private void cancelAll() {
		NotificationManager.getDefault().cancelAll();
	}

	private void notifyEvery30Minutes() {
		Notification periodicNotification = new Notification();
		periodicNotification.setTitle("Periodic Notification every 30 minutes");
		periodicNotification.setText("Periodic notification scheduled almost every 30 minutes.");
		periodicNotification.setIcon(Res.image.NOTIF_ICON);
		periodicNotification.setDate(new Date(138461864L));
		periodicNotification.setLED(Color.CYAN, 4000, 1000);
		periodicNotification.setActionText("Do Action");
		periodicNotification.setVibration(new long[] { 0, 5000 });
		periodicNotification.setAccessoryIcon(Res.image.ACCESSORY_ICON);
		periodicNotification.setLaunchImage(Res.image.LAUNCH_IMG);
		if (TargetInfo.IOS) {
			periodicNotification.setSound(Res.music.SOUND_NOTIF_IOS);
		} else {
			periodicNotification.setSound(Res.music.SOUND_NOTIF);
		}
		// Schedule the local notification to notify every 30 minutes
		// because in WindowsPhone this is the minimal period which can be set
		NotificationManager.getDefault().schedule(periodicNotification, NotificationManager.INTERVAL_HALF_HOUR);
	}

	private void notifyIn15s() {
		Notification dateNotification = new Notification();
		dateNotification.setTitle("Date Notification 15 seconds");
		dateNotification.setText("Notification scheduled 15 seconds after creation time.");
		dateNotification.setIcon(Res.image.NOTIF_ICON);
		dateNotification.setDate(new Date(138461864L));
		dateNotification.setLED(Color.CYAN, 4000, 1000);
		dateNotification.setActionText("Do Action");
		dateNotification.setVibration(new long[] { 0, 5000 });
		dateNotification.setAccessoryIcon(Res.image.ACCESSORY_ICON);
		dateNotification.setLaunchImage(Res.image.LAUNCH_IMG);
		if (TargetInfo.IOS) {
			dateNotification.setSound(Res.music.SOUND_NOTIF_IOS);
		} else {
			dateNotification.setSound(Res.music.SOUND_NOTIF);
		}

		Calendar nowPlus15Sec = Calendar.getInstance();
		nowPlus15Sec.setTime(new Date(System.currentTimeMillis() + 15000));
		NotificationManager.getDefault().schedule(dateNotification, nowPlus15Sec);
	}

	private void notifyImmediately() {
		Notification notifyNow = new Notification();
		notifyNow.setTitle("Simple Local notification");
		notifyNow.setText("Notify now local notification");
		notifyNow.setIcon(Res.image.NOTIF_ICON);
		notifyNow.setDate(new Date(138461864L));
		notifyNow.setLED(Color.CYAN, 4000, 1000);
		notifyNow.setActionText("Do Action");
		notifyNow.setVibration(new long[] { 0, 5000 });
		notifyNow.setAccessoryIcon(Res.image.ACCESSORY_ICON);
		notifyNow.setLaunchImage(Res.image.LAUNCH_IMG);
		if (TargetInfo.IOS) {
			notifyNow.setSound(Res.music.SOUND_NOTIF_IOS);
		} else {
			notifyNow.setSound(Res.music.SOUND_NOTIF);
		}

		NotificationManager.getDefault().notify(notifyNow);
	}

}
