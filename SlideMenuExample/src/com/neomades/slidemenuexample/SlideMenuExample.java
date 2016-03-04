package com.neomades.slidemenuexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.mad.TargetInfo;
import com.neomades.slidemenuexample.slidemenu.SlideMenuScreen;

/**
 * Example entry point. See {@link SlideMenuScreen} to have more details about
 * the example.
 * 
 */
public class SlideMenuExample extends Application {

	public void onStart(Controller controller) {
		
		// Enable Action for Android device
		setActionBarEnabled(true);
		
		// Push the first screen (the SlideScreen)
		controller.pushScreen(SlideMenuScreen.class);
	}

}
