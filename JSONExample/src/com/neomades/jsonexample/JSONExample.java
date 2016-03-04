package com.neomades.jsonexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.jsonexample.screens.MainScreen;

/**
 * Entry point
 */
public class JSONExample extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes first screen
		controller.pushScreen(MainScreen.class);
	}

}