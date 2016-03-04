package com.neomades.serviceexample;

import com.neomades.mad.TargetInfo;

public class Constants implements TargetInfo {
	// Sound format is different of mp3 only for iOS platform
	public static String SOUND_FORMAT = "mp3";

	static {
		if (IOS) {
			SOUND_FORMAT = "caf";
		}
	}

}
