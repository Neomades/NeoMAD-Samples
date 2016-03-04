package com.neomades.locationexample.screen.proximity;

import com.neomades.app.Screen;
import com.neomades.location.Location;
import com.neomades.location.LocationListener;
import com.neomades.location.LocationManager;
import com.neomades.locationexample.Res;
import com.neomades.locationexample.util.CriteriaPreferences;
import com.neomades.ui.Button;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;

public class ProximityScreen extends Screen implements ClickListener, LocationListener {

	private TextLabel latitudeResult;
	private TextLabel longitudeResult;

	public void onCreate() {
		setTitle(Res.string.PROXIMITY);
		setContent(Res.layout.PROXIMITY_SCREEN);

		Button manageButton = (Button) findView(Res.id.ID_BUTTON_MANAGE);
		manageButton.setClickListener(this);
		latitudeResult = (TextLabel) findView(Res.id.ID_LATITUDE_RESULT);
		longitudeResult = (TextLabel) findView(Res.id.ID_LONGITUDE_RESULT);

		startRequest();
	}

	public void onDestroy() {
		stopRequest();
	}

	public void onClick(View view) {
		manageProximityRegions();
	}

	public void onLocationChanged(final Location point) {
		controller.runOnUiThread(new Runnable() {
			public void run() {
				setLocationPoint(point);
			}
		});
	}

	private void setLocationPoint(Location point) {
		if (point == null) {
			latitudeResult.setText("");
			longitudeResult.setText("");
		} else {
			latitudeResult.setText(Double.toString(point.getLatitude()) + "");
			longitudeResult.setText(Double.toString(point.getLongitude()) + "");
		}
	}

	private void manageProximityRegions() {
		controller.pushScreen(ProximityRegionListScreen.class);
	}

	private void startRequest() {
		LocationManager.getDefault().requestMyLocationChanges(CriteriaPreferences.getDefault().getCurrentCriteria(), this);
	}

	private void stopRequest() {
		LocationManager.getDefault().stop();
	}
}
