package com.neomades.xmlpullparserexample.screens;

import com.neomades.app.Screen;
import com.neomades.ui.Button;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;
import com.neomades.xmlpullparserexample.Res;

/**
 * Main screen. Here you can select the action to perform.
 */
public final class MainScreen extends Screen {

	protected void onCreate() {
		setTitle(Res.string.MAIN_TITLE);

		// Sets screen content
		setContent(Res.layout.MAIN_SCREEN);

		// Pushes ReadingScreen when clicking on "read" button
		((Button) findView(Res.id.BUTTON_READ_XML)).setClickListener(new ClickListener() {
			public void onClick(View view) {
				controller.pushScreen(ReadingScreen.class);
			}
		});
	}

}