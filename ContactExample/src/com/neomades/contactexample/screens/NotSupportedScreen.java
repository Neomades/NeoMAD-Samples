package com.neomades.contactexample.screens;

import com.neomades.app.Screen;
import com.neomades.contactexample.Res;

/**
 * Screen displayed in platform that does not support the example feature.
 */
public class NotSupportedScreen extends Screen {
	
	protected void onCreate() {
		setContent(Res.layout.NOT_SUPPORTED_LAYOUT);
	}
}
