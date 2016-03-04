package com.neomades.conditionalcoding;

import com.neomades.mad.TargetInfo;

public class Constants implements TargetInfo {
	public static boolean SAY_GOODBYE = true;

	/**
	 * RESOLUTION is used in the images path, in order to use the right images
	 * for each target depending on the resolution of the screen.
	 */
	public static String RESOLUTION = "";

	static {
		if (SCREEN_WIDTH <= 320) {
			RESOLUTION = "320x480";
		} else {
			RESOLUTION = "480x800";
		}

		if (WINDOWS_PHONE) {
			SAY_GOODBYE = false;
		}
	}


}
