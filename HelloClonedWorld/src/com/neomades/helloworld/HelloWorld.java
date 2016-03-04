package com.neomades.helloworld;

import com.neomades.app.Application;
import com.neomades.app.Controller;

/**
 * Entry point
 */
public class HelloWorld extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes first screen
		controller.pushScreen(HelloWorldScreen.class);
	}

}