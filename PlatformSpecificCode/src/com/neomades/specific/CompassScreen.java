package com.neomades.specific;

import com.neomades.app.Screen;
import com.neomades.graphics.Color;
import com.neomades.ui.TextLabel;
import com.neomades.ui.VerticalLayout;

public class CompassScreen extends Screen implements CompassListener {

	private TextLabel compassLabel;
	private static final String TRUE_HEADING_TEXT = "Compass true heading : ";
	
	public void onCreate() {
		Compass compass = new Compass();
		compass.setCompassListener(this);

		VerticalLayout container = new VerticalLayout();
		container.setStretchMode(MATCH_PARENT, MATCH_PARENT);
		container.setContentAlignment(VCENTER | HCENTER);

		compassLabel = new TextLabel(compass.isSupported() ? (TRUE_HEADING_TEXT + 0) : "Compass is not supported on this device");
		compassLabel.setBackgroundColor(Color.WHITE);
		compassLabel.setTextColor(Color.BLACK);
		compassLabel.setStretchMode(MATCH_CONTENT, MATCH_CONTENT);

		container.addView(compassLabel);
		setContent(container);
	}

	public void onDirectionChanged(Compass compass, final int value) {
		if (compass.isSupported()) {
			// we make sure the UI update is done on the UI-Thread
			controller.runOnUiThread(new Runnable() {
				public void run() {
					compassLabel.setText(TRUE_HEADING_TEXT + value);
				}
			});
		}
	}
}