package com.neomades.specific;

import com.neomades.app.Application;
import com.neomades.app.Controller;

public class CompassApplication extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes the first screen
		controller.pushScreen(CompassScreen.class);
	}
}
