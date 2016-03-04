package com.neomades.locationexample.screen.location;

import com.neomades.location.Location;
import com.neomades.location.LocationListener;
import com.neomades.location.LocationManager;
import com.neomades.locationexample.Res;

public class MyLocationScreen extends AbstractLocationScreen implements LocationListener {

	protected void startRequest() {
		// make the request : we want to get a single update of the current
		// location
		LocationManager.getDefault().requestMyLocation(getCurrentCriteria(), this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neomades.location.LocationListener#onLocationChanged(com.neomades
	 * .location.Location)
	 */
	public void onLocationChanged(final Location point) {

		// onLocationChanged in background thread
		controller.runOnUiThread(new Runnable() {
			public void run() {
				setLocationPoint(point);
			}
		});
	}

	protected int getTitleId() {
		return Res.string.LOCATE_ME;
	}

}
