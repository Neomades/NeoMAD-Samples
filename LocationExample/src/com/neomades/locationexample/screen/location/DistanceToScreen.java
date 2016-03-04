package com.neomades.locationexample.screen.location;

import com.neomades.app.Screen;
import com.neomades.location.Location;
import com.neomades.locationexample.Res;
import com.neomades.ui.TextLabel;
import com.neomades.ui.VerticalLayout;

public class DistanceToScreen extends Screen {

	protected void onCreate() {
		setTitle(Res.string.DISTANCE_TO);
		VerticalLayout content = new VerticalLayout();
		Location from = new Location(43.446651, -1.552697);
		Location to = new Location(43.493983, -1.480879);
		content.addView(new TextLabel("Distance from work to my home (should be around 7835.44 meters) :"));
		content.addView(new TextLabel(Float.toString(from.distanceTo(to)) + " meters"));
		setContent(content);
	}

}
