package com.neomades.slidemenuexample.screens;

import com.neomades.app.Screen;
import com.neomades.graphics.Color;
import com.neomades.slidemenuexample.Res;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.TextLabel;
import com.neomades.ui.VerticalLayout;

public class FindPeopleScreen extends Screen {

	protected void onCreate() {
		setTitle("Find people");
		setContent(Res.layout.MAIN_SCREEN);
		((VerticalLayout)getContent().findView(Res.id.main_layout)).setBackgroundColor(Color.BLACK);
		TextLabel description = (TextLabel)getContent().findView(Res.id.main_txt);
		description.setText(Res.string.FIND_PEOPLE);
		description.setTextColor(Color.WHITE);
		((ImageLabel)getContent().findView(Res.id.main_img)).setImage(Res.image.ic_people);
	}

}
