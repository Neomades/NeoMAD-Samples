package com.neomades.animationexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.mad.TargetInfo;

/**
 * Example entry class, see {@link AnimationScreen} to have more details about
 * the example.
 * 
 */
public class AnimationApplication extends Application {

	protected void onStart(Controller controller) {
				
		controller.pushScreen(AnimationScreen.class);
	}

}
