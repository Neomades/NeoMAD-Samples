package com.neomades.slidemenuexample.screens;

import com.neomades.app.Screen;
import com.neomades.slidemenuexample.Res;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.TextLabel;

public class AboutScreen extends Screen {

	protected void onCreate() {
		setTitle("About");
		setContent(Res.layout.MAIN_SCREEN);
		((TextLabel)getContent().findView(Res.id.main_txt)).setText(Res.string.ABOUT);
		((ImageLabel)getContent().findView(Res.id.main_img)).setImage(Res.image.ic_about);
	}

}
