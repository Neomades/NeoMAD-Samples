package com.neomades.helloworld;

import com.neomades.app.Screen;
import com.neomades.graphics.Color;
import com.neomades.ui.TextLabel;
import com.neomades.ui.VerticalLayout;

/**
 * Application page screen
 */
public final class HelloWorldScreen extends Screen {

	protected void onCreate() {
		// Initialize the UI at screen creation

		// *** Main Layout *** //
		// a VerticalLayout aligns its content vertically
		VerticalLayout layout = new VerticalLayout();
		// we want the VerticalLayout to fill all the screen size
		layout.setStretchMode(MATCH_PARENT, MATCH_PARENT);
		// we want the content to be centered into the VerticalLayout
		layout.setContentAlignment(HCENTER | VCENTER);
		// set the background color of the layout
		layout.setBackgroundColor(Color.rgb(Constants.MAIN_SCREEN_BACKGROUND_COLOR));
		// set the VerticalLayout as content for this screen
		setContent(layout);

		// *** Text Label *** //
		// a TextLabel allows to display a simple text on the screen.
		// It can be initialized using a resource id or a text.
		TextLabel helloWorldLabel = new TextLabel(Res.string.TXT_HELLO_WORLD);
		// we want the TextLabel size to match the text
		helloWorldLabel.setStretchMode(MATCH_CONTENT, MATCH_CONTENT);
		// add the TextLabel to the VerticalLayout
		layout.addView(helloWorldLabel);
	}

}