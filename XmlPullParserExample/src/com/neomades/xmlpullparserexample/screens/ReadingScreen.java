package com.neomades.xmlpullparserexample.screens;

import java.io.UnsupportedEncodingException;

import com.neomades.app.ResManager;
import com.neomades.app.Screen;
import com.neomades.ui.Button;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;
import com.neomades.xmlpullparserexample.Res;

/**
 * This screen will display the raw content of a XML file in the resource.
 */
public class ReadingScreen extends Screen {

	protected void onCreate() {
		setTitle(Res.string.READING_TITLE);

		// Sets screen content
		setContent(Res.layout.READING_SCREEN);

		// Gets "parse.xml" text content and displays it into a label
		byte[] fileContent = ResManager.getRawData(Res.raw.XML_FILE);
		String fileText;
		try {
			fileText = new String(fileContent, "utf-8");
		} catch (UnsupportedEncodingException e) {
			fileText = ResManager.getString(Res.string.ENCODING_ERROR);
		}
		((TextLabel) findView(Res.id.XML_FILE_ID)).setText(fileText);

		// Parse the file when clicking the "Parse" button
		((Button) findView(Res.id.PARSE_XML)).setClickListener(new ClickListener() {
			public void onClick(View view) {
				controller.pushScreen(DiscussionScreen.class);
			}
		});

	}

}
