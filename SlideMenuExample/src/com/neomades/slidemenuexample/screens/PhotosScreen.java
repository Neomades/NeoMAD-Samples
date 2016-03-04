package com.neomades.slidemenuexample.screens;

import com.neomades.app.Screen;
import com.neomades.slidemenuexample.Res;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.TextLabel;

public class PhotosScreen extends Screen {

	protected void onCreate() {
		setTitle("Photo");
		setContent(Res.layout.MAIN_SCREEN);
		((TextLabel)getContent().findView(Res.id.main_txt)).setText(Res.string.PHOTO);
		((ImageLabel)getContent().findView(Res.id.main_img)).setImage(Res.image.ic_photos);
	}

}
