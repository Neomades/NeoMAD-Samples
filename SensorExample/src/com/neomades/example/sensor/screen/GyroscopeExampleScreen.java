package com.neomades.example.sensor.screen;

import com.neomades.app.ResManager;
import com.neomades.app.Screen;
import com.neomades.example.sensor.Res;
import com.neomades.graphics.Font;
import com.neomades.io.sensor.Sensor;
import com.neomades.io.sensor.SensorData;
import com.neomades.io.sensor.SensorListener;
import com.neomades.io.sensor.SensorManager;
import com.neomades.io.sensor.categories.GyroscopeData;
import com.neomades.io.sensor.categories.GyroscopeSensor;
import com.neomades.ui.Button;
import com.neomades.ui.ComboBox;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;
import com.neomades.ui.listeners.ItemSelectedListener;

/**
 * Displays data coming from the gyroscope sensor updating the screen at a rate
 * corresponding to the chosen speed acquisition.
 */
public class GyroscopeExampleScreen extends Screen implements SensorListener {

	// Gyroscope sensor
	private GyroscopeSensor gyroscope;

	// Speed rate acquisition, here initialized to Normal speed (enough for
	// updating UI in basic application)
	private int period = Sensor.PERIOD_NORMAL;

	protected void onCreate() {

		setTitle(Res.string.TITRE_GYROSCOPE);

		// true if the sensor is available
		boolean sensorAvailable = true;

		// Creation of a SensorManager thanks to the method getDefault().
		// The SensorManager is useful to get sensor instances and checks if
		// sensors are available on the device.
		// Note: you will be able to create only one and unique SensorManager.
		SensorManager manager = SensorManager.getDefault();

		// Checks that a gyroscope is available.
		// Note: make sure before using a sensor that the sensor is available on
		// the device
		if (manager.isGyroscopeSupported()) {
			// Creation of a gyroscope
			gyroscope = manager.getGyroscope();
			// Sets the listener, allows to update the values when they have
			// changed.
			gyroscope.setListener(this);
		} else {
			sensorAvailable = false;
		}

		if (!sensorAvailable) {
			// The sensor is not available on the device
			setContent(Res.layout.NO_SENSOR);
			// Loads only one TextLabel
			Font font = Font.createFont(Font.DEFAULT, Font.STYLE_BLACK, 30);
			((TextLabel) findView(Res.id.ERROR_SENSOR_LABEL)).setText(Res.string.ERROR_GYROSCOPE);
			((TextLabel) findView(Res.id.ERROR_SENSOR_LABEL)).setFont(font);

		} else {
			// The sensor is available on the device
			// Loads all the UI
			setContent(Res.layout.SENSOR_EXAMPLE_SCREEN);
			((TextLabel) findView(Res.id.DESCRIPTION_LABEL)).setText(Res.string.DESCRIPTION_GYROSCOPE);

			// Load Fonts
			Font dataLabelFont = Font.createFont(Font.DEFAULT, Font.STYLE_BLACK, 22);
			Font decriptionFont = Font.createFont(Font.DEFAULT, Font.STYLE_EXTRA_BLACK, 16);
			((TextLabel) findView(Res.id.X_LABEL)).setFont(dataLabelFont);
			((TextLabel) findView(Res.id.Y_LABEL)).setFont(dataLabelFont);
			((TextLabel) findView(Res.id.Z_LABEL)).setFont(dataLabelFont);
			((TextLabel) findView(Res.id.DESCRIPTION_LABEL)).setFont(decriptionFont);
			((TextLabel) findView(Res.id.SPEED_LABEL)).setFont(decriptionFont);

			// Starts gyroscope when "Start" button is pushed
			((Button) findView(Res.id.START_BUTTON)).setClickListener(new ClickListener() {
				public void onClick(View view) {
					if (gyroscope != null) {
						gyroscope.start(period);
					}

				}
			});

			// Stops gyroscope when "Stop" button is pushed
			((Button) findView(Res.id.STOP_BUTTON)).setClickListener(new ClickListener() {
				public void onClick(View view) {
					if (gyroscope != null) {
						gyroscope.stop();
					}

				}
			});

			// Picks a speed acquisition
			((ComboBox) findView(Res.id.COMBO)).setItemSelectedListener(new ItemSelectedListener() {

				public void onItemSelected(int index, String item) {
					// You need to give a speed acquisition when you
					// want to start the gyroscope.
					// Here, changes the argument of the start() method
					// to the four possible speed acquisition
					switch (index) {
					case 1:
						period = Sensor.PERIOD_LOW;
						break;
					case 2:
						period = Sensor.PERIOD_GAME;
						break;
					case 3:
						period = Sensor.PERIOD_FASTEST;
						break;
					default:
						period = Sensor.PERIOD_NORMAL;
						break;
					}
					// Checks if a gyroscope is currently running.
					// Enables to change the speed acquisition even if
					// the sensor is running
					if (gyroscope.isActive()) {
						gyroscope.start(period);
					}
				}
			});
		}
	}

	protected void onPause() {

		super.onPause();
		// Forces the sensor to stop and avoid to run a unwanted sensor
		// acquisition in a background thread
		if (gyroscope != null) {
			gyroscope.stop();
		}

	}

	public void onSensorChanged(Sensor sensor, SensorData data) {
		// Creation of GyroscopeData to get values from the gyroscope
		final GyroscopeData gyroscopeData = (GyroscopeData) data;

		// By default sensor acquisition is done in a background thread.
		// If you need to update the UI use runOnUiThread().
		controller.runOnUiThread(new Runnable() {

			public void run() {
				// Gets the last values from the gyroscope. Updates the text
				// labels in the UI thread.
				((TextLabel) findView(Res.id.X_LABEL)).setText(ResManager.getString(Res.string.X_) + Double.toString(gyroscopeData.getX()));
				((TextLabel) findView(Res.id.Y_LABEL)).setText(ResManager.getString(Res.string.Y_) + Double.toString(gyroscopeData.getY()));
				((TextLabel) findView(Res.id.Z_LABEL)).setText(ResManager.getString(Res.string.Z_) + Double.toString(gyroscopeData.getZ()));
			}
		});

	}

}
