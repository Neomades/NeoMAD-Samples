package com.neomades.locationexample.screen.location;

import com.neomades.location.LocationManager;
import com.neomades.locationexample.Res;

public class LastKnownLocationScreen extends AbstractLocationScreen {

	protected void startRequest() {
		// get the last known location and display it to the screen
		com.neomades.location.Location loc = LocationManager.getDefault().getLastKnownLocation();

		setLocationPoint(loc);
	}

	protected int getTitleId() {
		return Res.string.LAST_KNOWN_LOCATION;
	}
}
