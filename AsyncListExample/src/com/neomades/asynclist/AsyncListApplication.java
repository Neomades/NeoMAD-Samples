package com.neomades.asynclist;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.asynclist.screens.MainScreen;

/**
 * Entry point
 */
public class AsyncListApplication extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes first screen
		controller.pushScreen(MainScreen.class);
	}

}