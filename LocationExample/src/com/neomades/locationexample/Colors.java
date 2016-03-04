package com.neomades.locationexample;

import com.neomades.graphics.Color;
import com.neomades.mad.TargetInfo;

public final class Colors {

	public static final Color ENABLED_COLOR;

	public static final Color DISABLED_COLOR = Color.GRAY;

	static {
		if (TargetInfo.IOS) {
			// white background by default on these platforms
			ENABLED_COLOR = Color.BLACK;
		} else {
			ENABLED_COLOR = Color.WHITE;
		}
	}

	// Hide the constructor because this is an utility class.
	private Colors() {
	}

}
