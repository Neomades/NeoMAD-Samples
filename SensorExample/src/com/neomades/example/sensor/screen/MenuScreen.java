package com.neomades.example.sensor.screen;

import com.neomades.app.Screen;
import com.neomades.example.sensor.Res;
import com.neomades.graphics.Font;
import com.neomades.ui.ListView;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ItemClickedListener;

/**
 * 
 * Display the list of sensors supported by the NeoMAD framework. You can pick
 * one of them and start sensor acquisition. If the sensor is not supported on
 * the current device you will be inform.
 * 
 */
public class MenuScreen extends Screen {

	protected void onCreate() {

		setTitle(Res.string.TITRE_MENU);

		// Sets screen content
		setContent(Res.layout.MENU_SCREEN);

		// Loads font
		Font font = Font.createFont(Font.DEFAULT, Font.STYLE_MEDIUM, 28);
		((TextLabel) findView(Res.id.ACCELEROMETER_LABEL)).setFont(font);
		((TextLabel) findView(Res.id.GYROSCOPE_LABEL)).setFont(font);
		((TextLabel) findView(Res.id.MAGNETOMETER_LABEL)).setFont(font);

		// Sets list click listener
		((ListView) findView(Res.id.LIST)).setItemClickedListener(new ItemClickedListener() {

			public void onItemClicked(int index, View child) {
				switch (index) {
				case 0:
					controller.pushScreen(AccelerometerExampleScreen.class);
					break;
				case 1:
					controller.pushScreen(GyroscopeExampleScreen.class);
					break;
				case 2:
					controller.pushScreen(MagnetometerExampleScreen.class);
				default:
					break;
				}

			}
		});

	}

}
