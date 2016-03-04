package com.neomades.locationexample.screen;

import com.neomades.app.Screen;
import com.neomades.locationexample.Res;

/**
 * Screen displayed in platform that does not support the example feature.
 */
public class NotSupportedScreen extends Screen {
	
	protected void onCreate() {
		setContent(Res.layout.NOT_SUPPORTED_LAYOUT);
	}
}
