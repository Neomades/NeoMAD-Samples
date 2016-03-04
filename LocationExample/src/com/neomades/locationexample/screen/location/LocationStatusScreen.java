package com.neomades.locationexample.screen.location;

import com.neomades.app.Screen;
import com.neomades.location.LocationManager;
import com.neomades.locationexample.Res;
import com.neomades.ui.TextLabel;
import com.neomades.ui.VerticalLayout;

public class LocationStatusScreen extends Screen {

	protected void onCreate() {
		setTitle(Res.string.LOCATION_STATUS);
		LocationManager manager = LocationManager.getDefault();
		VerticalLayout content = new VerticalLayout();
		content.addView(new TextLabel("Status of LocationManager"));
		content.addView(new TextLabel("isSupported: " + manager.isSupported()));
		content.addView(new TextLabel("isLocationEnabledByUser: " + manager.isLocationEnabledByUser()));
		setContent(content);
	}

}
