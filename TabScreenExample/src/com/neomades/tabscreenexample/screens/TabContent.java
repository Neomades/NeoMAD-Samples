package com.neomades.tabscreenexample.screens;

import com.neomades.app.Screen;
import com.neomades.tabscreenexample.Res;
import com.neomades.ui.TextLabel;

public class TabContent extends Screen {

	protected void onCreate() {
		// Set the content view from XML layout definition
		setContent(Res.layout.TAB_SUB_SCREEN);

		// Modify the text into the layout with the received selected tab index
		// from the main TabScreen
		int selectedTab = getScreenParams().getInt("selectedtab");
		setTextNumber(selectedTab);
	}

	private void setTextNumber(int number) {
		TextLabel label = (TextLabel) findView(Res.id.TAB_SCREEN_CONTENT_LABEL);
		label.setText("This is the content of the tab: " + number);
	}

}
