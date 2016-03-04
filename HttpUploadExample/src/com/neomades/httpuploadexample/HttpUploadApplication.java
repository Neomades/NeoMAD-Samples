package com.neomades.httpuploadexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.httpuploadexample.screen.MainScreen;

/**
 * Entry point
 */
public class HttpUploadApplication extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes first screen
		controller.pushScreen(MainScreen.class);
	}

}