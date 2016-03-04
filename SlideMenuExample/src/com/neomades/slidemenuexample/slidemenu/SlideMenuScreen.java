package com.neomades.slidemenuexample.slidemenu;

import com.neomades.app.SlideScreen;
import com.neomades.slidemenuexample.screens.HomeScreen;

/**
 * Main screen of the application. It is a SlideScreen with 3 screens. In this
 * example, the left and the right screen do the same things.
 */
public final class SlideMenuScreen extends SlideScreen {

	protected void onCreate() {

		// SlideScreen has three screens. The middle screen is the main screen,
		// it occupies all the device screen. Left and right screens are not
		// visible when the screen appears, they can be opened by sliding the
		// left and right screen edges.
		setMiddleScreen(HomeScreen.class);
		setRightScreen(RightScreen.class);
		setLeftScreen(LeftScreen.class);

		// Opening right screen will "push" middle screen
		setRightContentSlidingEnabled(true);
		// Disable shadow effect on middle screen when one of the slide menu is
		// opened
		setRightShadowEnabled(false);

	}

}
