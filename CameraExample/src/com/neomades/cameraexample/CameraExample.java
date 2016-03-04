package com.neomades.cameraexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;

/**
 * Entry point
 */
public class CameraExample extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes first screen
		controller.pushScreen(MainScreen.class);
	}

}