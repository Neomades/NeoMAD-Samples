package com.neomades.conditionalcoding;

import com.neomades.app.Application;
import com.neomades.app.Controller;

/**
 * Entry point
 */
public class ConditionalCoding extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes first screen
		controller.pushScreen(HelloWorldScreen.class);
	}

}