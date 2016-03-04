package com.neomades.example.sensor;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.example.sensor.screen.MenuScreen;

/**
 * 
 * This application uses sensors supported by NeoMAD framework. It shows the
 * following operations :
 * <p>
 * <ul>
 * <li>Get a sensor instance from the sensor manager</li>
 * <li>Start and stop acquisition</li>
 * <li>Check that a sensor is supported</li>
 * <li>Check if the sensor is currently activated</li>
 * <li>Get data each time they have changed and specify a rate for the
 * acquisition</li>
 * <li>How to update the UI</li>
 * </ul>
 * </p>
 */
public class SensorApplication extends Application {

	protected void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Push first screen
		controller.pushScreen(MenuScreen.class);
	}
}
