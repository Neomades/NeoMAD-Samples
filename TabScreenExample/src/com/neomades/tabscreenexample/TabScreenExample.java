package com.neomades.tabscreenexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.mad.TargetInfo;
import com.neomades.tabscreenexample.screens.MainTabScreen;
import com.neomades.tabscreenexample.screens.NotSupportedScreen;

/**
 * Entry point
 */
public class TabScreenExample extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// first screen
		if (TargetInfo.WINDOWS) {
			controller.pushScreen(NotSupportedScreen.class);
		} else {
			controller.pushScreen(MainTabScreen.class);
		}
	}

}