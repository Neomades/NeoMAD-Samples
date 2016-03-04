package com.neomades.jsonexample.screens;

import com.neomades.app.Screen;
import com.neomades.jsonexample.Res;
import com.neomades.ui.Button;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;

/**
 * Application page screen
 */
public final class MainScreen extends Screen {

	protected void onCreate() {
		setTitle("MainScreen");

		// Set screen content
		setContent(Res.layout.MAIN_SCREEN);

		// Handle "reading" button
		((Button) findView(Res.id.BUTTON_READ_JSON)).setClickListener(new ClickListener() {
			public void onClick(View arg0) {
				controller.pushScreen(ReadingScreen.class);
			}
		});

		// Handle "writing" button
		((Button) findView(Res.id.BUTTON_WRITE_JSON)).setClickListener(new ClickListener() {
			public void onClick(View arg0) {
				controller.pushScreen(WritingScreen.class);
			}
		});
	}

}