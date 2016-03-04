package com.neomades.conditionalcoding;

import com.neomades.app.Screen;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.TextLabel;
import com.neomades.ui.VerticalLayout;

/**
 * Application page screen
 */
public final class HelloWorldScreen extends Screen {

	protected void onCreate() {
		// Initialize the UI at screen creation

		// *** Main Layout *** //
		// a VerticalLayout aligns its content vertically
		VerticalLayout layout = new VerticalLayout();
		// we want the VerticalLayout to fill all the screen size
		layout.setStretchMode(MATCH_PARENT, MATCH_PARENT);
		// we want the content to be centered into the VerticalLayout
		layout.setContentAlignment(HCENTER | VCENTER);
		// set the VerticalLayout as content for this screen
		setContent(layout);

		// *** Text Label *** //
		// a TextLabel allows to display a simple text on the screen.
		// It can be initialized using a resource id or a text.
		TextLabel helloWorldLabel = new TextLabel(Res.string.TXT_HELLO_WORLD);
		if (Constants.SAY_GOODBYE) {
			helloWorldLabel.setText(Res.string.TXT_GOODBYE_WORLD);
		}
		// we want the TextLabel size to match the text
		helloWorldLabel.setStretchMode(MATCH_CONTENT, MATCH_CONTENT);
		// add the TextLabel to the VerticalLayout
		layout.addView(helloWorldLabel);

		// *** Image Label *** //
		// an ImageLabel allows to display a simple image on the screen.
		// It can be initialized using a resource id or an Image object.
		ImageLabel sunImage = new ImageLabel(Res.image.IMAGE_SUN);
		if (Constants.SAY_GOODBYE) {
			sunImage.setImage(Res.image.IMAGE_MOON);
		}
		// we want the ImageLabel size to match the image
		sunImage.setStretchMode(MATCH_CONTENT, MATCH_CONTENT);
		// add the ImageLabel to the VerticalLayout
		layout.addView(sunImage);

	}

}