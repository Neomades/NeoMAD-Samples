package com.neomades.serviceexample;

import com.neomades.app.Screen;

/**
 * Screen displayed in platform that does not support the example feature.
 */
public class NotSupportedScreen extends Screen {
	
	protected void onCreate() {
		setContent(Res.layout.NOT_SUPPORTED_LAYOUT);
	}
}
