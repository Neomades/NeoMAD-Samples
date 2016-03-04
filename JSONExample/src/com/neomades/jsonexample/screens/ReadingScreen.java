package com.neomades.jsonexample.screens;

import com.neomades.app.Screen;
import com.neomades.app.ScreenParams;
import com.neomades.jsonexample.Res;
import com.neomades.ui.Button;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;

public class ReadingScreen extends Screen {

	// Listener handling JSON parsing methods
	private ClickListener mClickListener = new ClickListener() {
		public void onClick(View v) {
			ScreenParams params = new ScreenParams();
			if (v.getId() == Res.id.BUTTON_READ_JSONARRAY) {
				params.putInt(DiscussionScreen.READING_METHOD, DiscussionScreen.USE_JSONARRAY);
			} else {
				params.putInt(DiscussionScreen.READING_METHOD, DiscussionScreen.USE_JSONREADER);
			}
			controller.pushScreen(DiscussionScreen.class, params);
		}
	};

	protected void onCreate() {
		setTitle("ReadingScreen");

		// Set screen content
		setContent(Res.layout.READING_SCREEN);

		// Bind listener to screen buttons
		((Button) findView(Res.id.BUTTON_READ_JSONREADER)).setClickListener(mClickListener);
		((Button) findView(Res.id.BUTTON_READ_JSONARRAY)).setClickListener(mClickListener);
	}

}
