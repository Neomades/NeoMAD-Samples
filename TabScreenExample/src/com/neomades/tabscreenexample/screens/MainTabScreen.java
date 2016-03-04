package com.neomades.tabscreenexample.screens;

import com.neomades.app.ScreenParams;
import com.neomades.app.TabScreen;
import com.neomades.app.TabSpec;

/**
 * Application page screen.
 * <p>
 * In iOS and Android, a TabScreen shows tabs.
 * </p>
 * <p>
 * In Windows Phone, a TabScreen is represented by a Panorama native object.
 * 
 */
public final class MainTabScreen extends TabScreen {

	// For this example, each tab will have the same content
	// but the label will show a different text.
	// This is done thanks to ScreenParams to give extra information to a
	// screen of a Tab
	protected void onCreate() {
		setTitle("Main TabScreen");

		// Each tab contains a Screen and a text and/or a icon
		addTab("Stack", StackScreen.class);
		int i = 2;
		addTab(i++);
		addTab(i++);
		addTab(i++);
		addTab(i++);
		// The next tabs could be hidden into a "More" menu (e.g. in iOS
		// platform)
		addTab(i++);
		addTab(i++);
	}

	private void addTab(int number) {
		addTab(TabSpec.newTabSpec(TabContent.class).setText("Tab " + number).setParams(new ScreenParams().putInt("selectedtab", number)));
	}

	private void addTab(String text, Class screen) {
		addTab(TabSpec.newTabSpec(screen).setText(text));
	}

}