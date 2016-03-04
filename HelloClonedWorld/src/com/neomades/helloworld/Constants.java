package com.neomades.helloworld;

import com.neomades.mad.TargetInfo;

public class Constants implements TargetInfo {

	/*************************************************************************/
	/** Let's define some resources for our application */
	/*************************************************************************/

	/* Application background color */
	public static int MAIN_SCREEN_BACKGROUND_COLOR;

	/* Application specific icon file */
	public static String ICON_NAME;

	/* Application identifier */
	public static String APP_ID;

	/* Application name */
	public static String APP_NAME;

	/* Application binary name */
	public static String BINARY_NAME;

	/*************************************************************************/
	/** Let's compute the resource's values given command line defines */
	/*************************************************************************/

	/*
	 * When specified with -d option, sets the application "red" or "green"
	 * Default is "blue"
	 */
	public static boolean RED = false;
	public static boolean GREEN = false;

	/* The static block allows us to compute values of static variables */
	static {
		if (GREEN) {
			MAIN_SCREEN_BACKGROUND_COLOR = 0x3c7b5c;
			ICON_NAME = "green";
			APP_ID = "hellogreenworld";
			APP_NAME = "HelloGreenWorld";
		} else if (RED) {
			MAIN_SCREEN_BACKGROUND_COLOR = 0xb90000;
			ICON_NAME = "red";
			APP_ID = "helloredworld";
			APP_NAME = "HelloRedWorld";
		} else {
			MAIN_SCREEN_BACKGROUND_COLOR = 0x146da7;
			ICON_NAME = "blue";
			APP_ID = "helloblueworld";
			APP_NAME = "HelloBlueWorld";
		}

		/*
		 * The default value for BINARY_NAME is computed with the given template
		 * : $PRODUCTNAME_$TARGET_$VERSION_$LANGUAGE Let's put the APP_NAME in
		 * it to distinguish our applications This name must be compute after
		 * APP_NAME has been computed
		 */
		BINARY_NAME = APP_NAME + "_$TARGET_$VERSION_$LANGUAGE";
	}

	/*************************************************************************/

	public static String ICON_PATH;
	static {
		ICON_PATH = "@icon/" + ICON_NAME;
	}

}
