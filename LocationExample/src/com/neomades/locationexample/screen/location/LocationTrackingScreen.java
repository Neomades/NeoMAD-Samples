package com.neomades.locationexample.screen.location;

import com.neomades.location.Location;
import com.neomades.location.LocationListener;
import com.neomades.location.LocationManager;
import com.neomades.locationexample.Res;

public class LocationTrackingScreen extends AbstractLocationScreen implements LocationListener {

	protected void startRequest() {

		// make the request : we want to track the current location
		LocationManager.getDefault().requestMyLocationChanges(getCurrentCriteria(), this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neomades.location.LocationListener#onLocationChanged(com.neomades
	 * .location.Location)
	 */
	public void onLocationChanged(final Location point) {
		controller.runOnUiThread(new Runnable() {
			public void run() {
				setLocationPoint(point);
			}
		});
	}

	protected int getTitleId() {
		return Res.string.TRACK_MY_LOCATION;
	}
}
