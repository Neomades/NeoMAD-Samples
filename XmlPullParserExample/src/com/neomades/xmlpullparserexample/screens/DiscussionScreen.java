package com.neomades.xmlpullparserexample.screens;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.neomades.app.ResManager;
import com.neomades.app.Screen;
import com.neomades.graphics.Font;
import com.neomades.ui.TextLabel;
import com.neomades.ui.VerticalLayout;
import com.neomades.ui.View;
import com.neomades.xml.XmlPullParserFactory;
import com.neomades.xmlpullparserexample.Res;

/**
 * This screen displays the result of the parsing of a XML file as a little
 * discussion.
 */
public class DiscussionScreen extends Screen {

	private static final int FONT_SIZE = 13;

	// Variables to handle discussion information
	private String nameUser1, message;
	private String nameUser2, message2;

	protected void onCreate() {
		setTitle(Res.string.DISCUSSION_TITLE);

		// Sets screen content
		setContent(Res.layout.DISCUSSION_SCREEN);

		// Gets the content of the ScrollView, where we will display the
		// discussion
		VerticalLayout scrollViewContent = (VerticalLayout) findView(Res.id.DISCUSSION_LAYOUT);

		// Loads and parses the XML file
		byte[] b = ResManager.getRawData(Res.raw.XML_FILE);
		InputStreamReader xmlFileStream = new InputStreamReader(new ByteArrayInputStream(b));
		try {
			parseXml(xmlFileStream, scrollViewContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Parses the XML file and displays the content of "name" and "text" tags
	 * into text labels.
	 * 
	 * @param xmlFileStream
	 *            the content of the XML file as a stream reader
	 * @param scrollViewContent
	 *            the layout where to display the result of the parsing
	 * @throws XmlPullParserException
	 *             if an error occurred during parsing
	 * @throws IOException
	 *             if an error occurred during parsing
	 */
	private void parseXml(InputStreamReader xmlFileStream, VerticalLayout scrollViewContent) throws IOException, XmlPullParserException {

		// Initializes the factory and the parser
		XmlPullParserFactory factory = null;
		XmlPullParser parser = null;

		// Creates a new instance of the parser
		factory = XmlPullParserFactory.newInstance();
		// Specifies that the parser produced by this factory will provide
		// support for XML namespaces
		factory.setNamespaceAware(true);
		parser = factory.newPullParser();

		// Sets the file to parse into the parser
		parser.setInput(xmlFileStream);
		parser.nextTag();

		// Analyzes the XML file
		while (parser.nextTag() == XmlPullParser.START_TAG) {
			String action = parser.getName();

			// Goes through "user1" tag
			// First method, we just go tag by tag, it supposes we know exactly
			// the XML structure
			if ("user1".equals(action)) {
				parser.nextTag(); // <id> - Start tag
				parser.next(); // 912345678901
				parser.nextTag(); // </id> - End tag
				parser.nextTag(); // <text> - Start tag
				parser.next(); // How do I read...

				// Gets text of the current tag
				message = parser.getText(); // message = "How do I read..."

				parser.nextTag(); // </text> - End tag
				parser.nextTag();
				parser.next();
				nameUser1 = parser.getText(); // nameUser1 = "neomades_newb"

				parser.nextTag();
				parser.nextTag();
				parser.next();
				parser.nextTag();
				parser.nextTag();
				parser.next();

				// Adds item to the UI elements
				appendItemView(scrollViewContent, nameUser1, message);
			}

			String action2 = parser.getName();

			// Goes trough "user2" tag
			// Second method, we use a loop to look for "name" and "text" tags
			// and save their content
			if ("user2".equals(action2)) {
				int eventType;
				do {
					// Goes to next XML element (tag or text in our case)
					eventType = parser.next();

					if (parser.getName() != null && parser.getName().equals("text") && eventType == XmlPullParser.START_TAG) {
						// We are at the beginning of a "text" tag
						// Goes to the text of the tag
						parser.next();
						// Gets the text
						message2 = parser.getText();

					} else if (parser.getName() != null && parser.getName().equals("name") && eventType == XmlPullParser.START_TAG) {
						// We are at the beginning of a "name" tag
						// Goes to the text of the tag
						parser.next();
						// Gets the text
						nameUser2 = parser.getText();
					}
				} while (nameUser2 == null || message2 == null);

				// Adds item to the UI elements
				appendItemView(scrollViewContent, nameUser2, message2);
			}
		}
	}

	/**
	 * Formats the discussion and adds it into a layout into a layout.
	 * 
	 * @param scrollViewContent
	 *            the part of the discussion to add to the main layout
	 * @param userName
	 *            the name of the user, from the XML file
	 * @param message
	 *            the message of the user, from the XML file
	 */
	private void appendItemView(VerticalLayout scrollViewContent, String userName, String message) {

		VerticalLayout itemLayout = (VerticalLayout) View.inflateXML(Res.layout.DISCUSSION_ITEM);

		TextLabel userNameTextLabel = (TextLabel) itemLayout.findView(Res.id.DISCUSSION_USER_NAME);
		userNameTextLabel.setFont(Font.createFont(Font.DEFAULT, Font.STYLE_ITALIC, FONT_SIZE));
		userNameTextLabel.setText(userName + ResManager.getString(Res.string.SAY));

		TextLabel contentTextLabel = (TextLabel) itemLayout.findView(Res.id.DISCUSSION_TEXT);
		contentTextLabel.setFont(Font.createFont(Font.DEFAULT, Font.STYLE_BOLD, FONT_SIZE));
		contentTextLabel.setText(message);

		scrollViewContent.addView(itemLayout);
	}

}
