package com.neomades.notificationexample.screens;

import com.neomades.app.Screen;
import com.neomades.notificationexample.Res;

/**
 * Screen displayed in platform that does not support the example feature.
 */
public class NotSupportedScreen extends Screen {
	
	protected void onCreate() {
		setContent(Res.layout.NOT_SUPPORTED_LAYOUT);
	}
}
