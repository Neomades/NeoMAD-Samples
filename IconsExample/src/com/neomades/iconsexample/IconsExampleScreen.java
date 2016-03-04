package com.neomades.iconsexample;

import com.neomades.app.Screen;
import com.neomades.ui.TextLabel;

/**
 * Application page screen
 */
public final class IconsExampleScreen extends Screen {

	protected void onCreate() {
		TextLabel message = new TextLabel("The application icon is adapted to each platform.");
		setContent(message);
	}

}