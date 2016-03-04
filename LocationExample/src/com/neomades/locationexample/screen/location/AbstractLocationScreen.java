package com.neomades.locationexample.screen.location;

import com.neomades.app.Screen;
import com.neomades.location.Criteria;
import com.neomades.location.LocationManager;
import com.neomades.locationexample.Res;
import com.neomades.locationexample.util.CriteriaPreferences;
import com.neomades.ui.Button;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;
import com.neomades.ui.menu.Menu;
import com.neomades.ui.menu.MenuItem;

public abstract class AbstractLocationScreen extends Screen implements ClickListener {

	private TextLabel latitudeResult;
	private TextLabel longitudeResult;
	private TextLabel altitudeResult;
	private TextLabel speedResult;
	private TextLabel bearingResult;
	private TextLabel timestampResult;

	/**
	 * 
	 * @return the id of the string resource for the screen title
	 */
	protected abstract int getTitleId();

	/**
	 * Make the actual request for location
	 */
	protected abstract void startRequest();

	protected Criteria getCurrentCriteria() {
		// get the criteria to use for the request
		return CriteriaPreferences.getDefault().getCurrentCriteria();
	}

	public void onCreate() {
		setTitle(getTitleId());
		setContent(Res.layout.LOCATION_SCREEN);

		latitudeResult = (TextLabel) findView(Res.id.ID_LATITUDE_RESULT);
		longitudeResult = (TextLabel) findView(Res.id.ID_LONGITUDE_RESULT);
		altitudeResult = (TextLabel) findView(Res.id.ID_ALTITUDE_RESULT);
		speedResult = (TextLabel) findView(Res.id.ID_SPEED_RESULT);
		bearingResult = (TextLabel) findView(Res.id.ID_BEARING_RESULT);
		timestampResult = (TextLabel) findView(Res.id.ID_TIMESTAMP_RESULT);
		Button startButton = (Button) findView(Res.id.ID_BUTTON_START);
		Button stopButton = (Button) findView(Res.id.ID_BUTTON_STOP);
		startButton.setClickListener(this);
		stopButton.setClickListener(this);

	}

	public void onClick(View view) {
		int viewId = view.getId();
		switch (viewId) {
		case Res.id.ID_BUTTON_START:
			startRequest();
			break;

		case Res.id.ID_BUTTON_STOP:
			stopRequest();
			break;

		default:
			break;
		}
	}

	/**
	 * Stop the current request
	 */
	protected void stopRequest() {
		LocationManager.getDefault().stop();
	}

	/**
	 * Changes the text of the screen based on the given Location point
	 * 
	 * @param point
	 *            the new location point, or null
	 */
	protected void setLocationPoint(com.neomades.location.Location point) {
		if (point == null) {
			setTexts("", "", "", "", "", "");
		} else {
			setTexts(Double.toString(point.getLatitude()) + "", Double.toString(point.getLongitude()) + "", Double.toString(point.getAltitude()) + "",
					Float.toString(point.getSpeed()) + "", Float.toString(point.getBearing()) + "", Long.toString(point.getTime()) + "");
		}
	}

	private void setTexts(String latitude, String longitude, String altitude, String speed, String bearing, String time) {
		latitudeResult.setText(latitude);
		longitudeResult.setText(longitude);
		altitudeResult.setText(altitude);
		speedResult.setText(speed);
		bearingResult.setText(bearing);
		timestampResult.setText(time);
	}

	protected void onMenuCreate(Menu menu) {
		MenuItem preferencesItem = new MenuItem(Res.string.PREFERENCES);
		menu.addItem(preferencesItem);
	}

	protected void onMenuAction(MenuItem menuItem) {
		// only one item
		controller.pushScreen(CriteriaDetailsScreen.class);
	}
}
