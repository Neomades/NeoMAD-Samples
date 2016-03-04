package com.neomades.locationexample.screen;

import com.neomades.app.Screen;
import com.neomades.location.AuthorizationStatus;
import com.neomades.location.AuthorizationStatusListener;
import com.neomades.location.LocationManager;
import com.neomades.locationexample.Res;
import com.neomades.locationexample.screen.location.DistanceToScreen;
import com.neomades.locationexample.screen.location.LastKnownLocationScreen;
import com.neomades.locationexample.screen.location.LocationStatusScreen;
import com.neomades.locationexample.screen.location.LocationTrackingScreen;
import com.neomades.locationexample.screen.location.MyLocationScreen;
import com.neomades.locationexample.screen.proximity.ProximityScreen;
import com.neomades.ui.ListView;
import com.neomades.ui.View;
import com.neomades.ui.dialog.AlertDialog;
import com.neomades.ui.listeners.ItemClickedListener;

/**
 * Application page screen
 */
public final class MainScreen extends Screen implements ItemClickedListener, AuthorizationStatusListener {

	private static final int INDEX_DISTANCE_TO = 5;
	private static final int INDEX_PROXIMITY = 4;
	private static final int INDEX_LAST_KNOWN_LOCATION = 3;
	private static final int INDEX_TRACK_ME = 2;
	private static final int INDEX_MY_LOCATION = 1;
	private static final int INDEX_LOCATION_STATUS = 0;

	public void onCreate() {
		setTitle(Res.string.LOCATION_EXAMPLE);
		setContent(Res.layout.MAIN_SCREEN);

		ListView list = (ListView) findView(Res.id.ID_LISTVIEW);
		list.setItemClickedListener(this);
		
		// Required for iOS to enable location in the application. This will
		// display a popup for the user to choose if he enables or not the
		// location. The text of the popup is set in the urs under the
		// "location" tag. We will use an AuthorizationStatusListener to track
		// the user answer and display a dialog if he disables the location.
		LocationManager locationManager = LocationManager.getDefault();
		locationManager.setAuthorizationStatusListener(this);
		locationManager.requestWhenInUseAuthorization();
	}

	public void onItemClicked(int index, View view) {
		switch (index) {
		case INDEX_LOCATION_STATUS:
			controller.pushScreen(LocationStatusScreen.class);
			break;
		case INDEX_MY_LOCATION:
			controller.pushScreen(MyLocationScreen.class);
			break;
		case INDEX_TRACK_ME:
			controller.pushScreen(LocationTrackingScreen.class);
			break;
		case INDEX_LAST_KNOWN_LOCATION:
			controller.pushScreen(LastKnownLocationScreen.class);
			break;
		case INDEX_PROXIMITY:
			controller.pushScreen(ProximityScreen.class);
			break;
		case INDEX_DISTANCE_TO:
			controller.pushScreen(DistanceToScreen.class);
			break;

		default:
			break;
		}
	}

	/*
	 * AuthorizationStatusListener callback
	 */
	public void onAuthorizationStatusChanged(AuthorizationStatus status) {
		if (status == AuthorizationStatus.Denied || status == AuthorizationStatus.Restricted) {
			AlertDialog alert = new AlertDialog();
			alert.setMessage(Res.string.LOCATION_DISABLED_BY_USER);
			controller.showDialog(alert);
		}
	}
}
