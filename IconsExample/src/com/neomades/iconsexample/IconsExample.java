package com.neomades.iconsexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;

/**
 * Entry point
 */
public class IconsExample extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes first screen
		controller.pushScreen(IconsExampleScreen.class);
	}

}