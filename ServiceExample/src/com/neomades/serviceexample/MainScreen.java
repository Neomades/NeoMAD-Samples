package com.neomades.serviceexample;

import com.neomades.app.Screen;
import com.neomades.app.Service;
import com.neomades.mad.TargetInfo;
import com.neomades.serviceexample.backgroundservices.ServiceEvery30Minutes;
import com.neomades.serviceexample.backgroundservices.ServiceEveryMinute;
import com.neomades.serviceexample.backgroundservices.ServiceImmediate;
import com.neomades.ui.Button;
import com.neomades.ui.View;
import com.neomades.ui.dialog.AlertDialog;
import com.neomades.ui.listeners.ClickListener;

/**
 * Application page screen
 */
public final class MainScreen extends Screen implements ClickListener {

	protected void onCreate() {
		setTitle("Service Example");
		setContent(Res.layout.SERVICE_SCREEN);

		attachClickListener(Res.id.button_immediate);
		attachClickListener(Res.id.button_schedule_minute);
		attachClickListener(Res.id.button_schedule_30_minutes);
		attachClickListener(Res.id.button_stop_services);
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
		case Res.id.button_immediate:
			startServiceImmediately();
			break;

		case Res.id.button_schedule_minute:
			if (TargetInfo.WINDOWS_PHONE) {
				AlertDialog alert = new AlertDialog();
				alert.setMessage("Windows Phone only enables scheduling of services every 30min");
				controller.showDialog(alert);
			} else {
				scheduleServiceEveryMinute();
			}
			break;

		case Res.id.button_schedule_30_minutes:
			scheduleServiceEvery30Minutes();
			break;

		case Res.id.button_stop_services:
			stopServices();
			break;

		default:
			break;
		}
	}

	/**
	 * Start the corresponding service immediately
	 */
	private void startServiceImmediately() {
		controller.startService(ServiceImmediate.class);
	}

	/**
	 * Schedule the corresponding service to be run every minute
	 */
	private void scheduleServiceEveryMinute() {
		controller.scheduleService(ServiceEveryMinute.class, Service.INTERVAL_MINUTE);
	}

	/**
	 * Schedule the corresponding service to be run every 30 minutes 30 minutes
	 * is the default parameter of scheduleService() because in WindowsPhone
	 * this is the minimal interval which can be set
	 */
	private void scheduleServiceEvery30Minutes() {
		controller.scheduleService(ServiceEvery30Minutes.class);
	}

	/**
	 * Stop all services
	 */
	private void stopServices() {
		controller.stopService(ServiceImmediate.class);
		controller.stopService(ServiceEveryMinute.class);
		controller.stopService(ServiceEvery30Minutes.class);
	}

}