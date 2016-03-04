package com.neomades.xmlpullparserexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.xmlpullparserexample.screens.MainScreen;

/**
 * This application will show how to access and parse a XML file from the
 * resources of the application.
 * <p>
 * It is composed of 3 screens:
 * <ul>
 * <li>the main screen of the application to select the action to do: MainScreen
 * </li>
 * <li>a screen which displays the raw content of a XML file in the resources:
 * ReadingScreen</li>
 * <li>a screen which displays the result of the parsing: DiscussionScreen</li>
 * </ul>
 * </p>
 */
public class XmlPullParserApplication extends Application {

	public void onStart(Controller controller) {
		setActionBarEnabled(true);
		// Pushes the first screen
		controller.pushScreen(MainScreen.class);
	}

}