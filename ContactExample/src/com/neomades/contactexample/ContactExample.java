package com.neomades.contactexample;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.contactexample.screens.contactmanager.ContactManagerScreen;

/**
 * Application page screen
 */
public final class ContactExample extends Application {

	protected void onStart(Controller controller) {
		setActionBarEnabled(true);
		controller.pushScreen(ContactManagerScreen.class);
	}

}