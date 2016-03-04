package com.neomades.locationexample.screen.proximity;

import com.neomades.app.Screen;
import com.neomades.location.Location;
import com.neomades.location.LocationManager;
import com.neomades.location.ProximityRegion;
import com.neomades.locationexample.Res;
import com.neomades.locationexample.util.NumberUtils;
import com.neomades.ui.Button;
import com.neomades.ui.TextField;
import com.neomades.ui.View;
import com.neomades.ui.dialog.AlertDialog;
import com.neomades.ui.listeners.ClickListener;

public class ProximityRegionDetailsScreen extends Screen implements ClickListener {

	private static int regionId = 0;

	/**
	 * Builds a new unique region id
	 * 
	 * @return a new unique region id
	 */
	private static int newRegionId() {
		return regionId++;
	}

	private TextField latitude;
	private TextField longitude;
	private TextField radius;

	/** set only when in display mode */
	private ProximityRegion regionToDisplay;

	private LocationManager locationManager = LocationManager.getDefault();

	public void onCreate() {
		setContent(Res.layout.PROXIMITY_REGION_DETAILS_SCREEN);

		latitude = (TextField) findView(Res.id.ID_PROXIMITY_LATITUDE_RESULT);
		longitude = (TextField) findView(Res.id.ID_PROXIMITY_LONGITUDE_RESULT);
		radius = (TextField) findView(Res.id.ID_PROXIMITY_RADIUS_RESULT);
		Button cancelButton = (Button) findView(Res.id.ID_BUTTON_CANCEL);
		Button saveButton = (Button) findView(Res.id.ID_BUTTON_SAVE);
		cancelButton.setClickListener(this);
		saveButton.setClickListener(this);

		loadRegion(saveButton, cancelButton);
	}

	public void onClick(View view) {
		int viewId = view.getId();
		boolean success = true;
		switch (viewId) {
		case Res.id.ID_BUTTON_SAVE:
			success = saveRegion();
			break;

		case Res.id.ID_BUTTON_CANCEL:
			cancel();
			break;

		default:
			break;
		}
		if (success) {
			controller.popScreen();
		}
	}

	/**
	 * Detaches region
	 */
	private void cancel() {
		if (regionToDisplay != null) {
			locationManager.unregisterProximityRegion(regionToDisplay);
		}
	}

	/**
	 * Saves a ProximityRegion in the LocationManager, by reading the values
	 * filled in the form.
	 * 
	 * @return
	 */
	private boolean saveRegion() {
		ProximityRegion newRegion = buildRegionFromUI();
		if (newRegion != null) {
			// optional
			newRegion.setId(newRegionId());
			locationManager.registerProximityRegion(newRegion);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Loads region (if there is one) and show its details to UI.
	 * 
	 * @param saveButton
	 *            the save button in order to show/hide it and change its text
	 * @param cancelButton
	 *            the cancel button to change
	 */
	private void loadRegion(Button saveButton, Button cancelButton) {
		// get the region to display for the ScreenParams
		if (getScreenParams() != null) {
			regionToDisplay = (ProximityRegion) getScreenParams().getObject("region");
		}

		if (regionToDisplay == null) {
			setTitle(Res.string.ADD);
			cancelButton.setText(Res.string.CANCEL);
		} else {
			setTitle("Region " + regionToDisplay.getId());
			cancelButton.setText(Res.string.DELETE);
			saveButton.setVisible(false);

			// fill the different TextFields and make them disabled
			latitude.setText(Double.toString(regionToDisplay.getCenter().getLatitude()) + "");
			latitude.setEnabled(false);
			longitude.setText(Double.toString(regionToDisplay.getCenter().getLongitude()) + "");
			longitude.setEnabled(false);
			radius.setText(Float.toString(regionToDisplay.getRadius()) + "");
			radius.setEnabled(false);
		}
	}

	/**
	 * Shows an alert dialog with the given message
	 * 
	 * @param msg
	 */
	private void showDialog(String msg) {
		AlertDialog dialog = new AlertDialog();
		dialog.setMessage(msg);
		dialog.setTitle("Error");
		controller.showDialog(dialog);
	}

	/**
	 * Builds the proximity region currently set in the preferences with values
	 * from the form
	 * 
	 * @return the built region
	 */
	private ProximityRegion buildRegionFromUI() {
		double requiredLatitude = NumberUtils.verifyDouble(latitude.getText());
		double requiredLongitude = NumberUtils.verifyDouble(longitude.getText());
		float requiredRadius = NumberUtils.verifyFloat(radius.getText());

		if (requiredRadius <= 0) {
			showDialog("Radius must have a positive value !");
			return null;
		} else {
			try {
				Location location = new Location(requiredLatitude, requiredLongitude);
				return new ProximityRegion(location, requiredRadius);
			} catch (IllegalArgumentException e) {
				showDialog(e.getMessage());
				return null;
			}
		}
	}
}
