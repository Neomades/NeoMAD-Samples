package com.neomades.tabscreenexample.screens;

import com.neomades.app.Screen;
import com.neomades.app.ScreenParams;
import com.neomades.tabscreenexample.Res;
import com.neomades.ui.Button;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;

/**
 * StackScreen is a screen push many times in one tab of TabScreen.
 */
public class StackScreen extends Screen {
	/** ScreenParams key */
	private static final String PARAMS_CURRENT_INDEX = "stack.index";
	/** Current index of the StackScreen instance */
	private int currentIndex;

	protected void onCreate() {
		// show layout content
		setContent(Res.layout.SCREEN_WITH_BUTTON);

		// read the current index
		// because the same screen is pushed many times in the stack
		if (getScreenParams() != null && getScreenParams().contains(PARAMS_CURRENT_INDEX)) {
			currentIndex = getScreenParams().getInt(PARAMS_CURRENT_INDEX);
		}

		// update label with the current index
		TextLabel label = (TextLabel) findView(Res.id.LABEL);
		label.setText("" + currentIndex);

		// a new screen is pushed to the stack on the Button's click event
		Button button = (Button) findView(Res.id.BUTTON);
		button.setClickListener(new ClickListener() {
			public void onClick(View arg0) {
				pushNewScreen();
			}
		});
	}

	/**
	 * Action called when the button is clicked
	 */
	private void pushNewScreen() {
		controller.pushScreen(StackScreen.class, new ScreenParams().putInt(PARAMS_CURRENT_INDEX, ++currentIndex));
	}

}
