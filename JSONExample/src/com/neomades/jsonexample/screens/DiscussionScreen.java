package com.neomades.jsonexample.screens;

import java.io.IOException;

import com.neomades.app.ResManager;
import com.neomades.app.Screen;
import com.neomades.app.ScreenParams;
import com.neomades.graphics.Font;
import com.neomades.json.JSONArray;
import com.neomades.json.JSONException;
import com.neomades.json.JSONObject;
import com.neomades.json.JSONReader;
import com.neomades.jsonexample.Res;
import com.neomades.ui.TextLabel;
import com.neomades.ui.VerticalLayout;
import com.neomades.ui.View;
import com.neomades.ui.dialog.AlertDialog;

public class DiscussionScreen extends Screen {

	// Params for choosing the JSON reading method
	protected static final String READING_METHOD = "ReadingMethod";
	protected static final int USE_JSONREADER = 0;
	protected static final int USE_JSONARRAY = 1;

	// JSON node names
	private static final String TAG_OBJECT_TEXT = "text";
	private static final String TAG_OBJECT_USER = "user";
	private static final String TAG_OBJECT_USERNAME = "name";

	protected void onCreate() {
		setTitle("DiscussionScreen");

		// Display DISCUSSION_SCREEN layout
		setContent(Res.layout.DISCUSSION_SCREEN);

		// Get the content of the ScrollView
		VerticalLayout scrollViewContent = (VerticalLayout) findView(Res.id.DISCUSSION_LAYOUT);

		// Get the JSON encoded string
		String jsonString = ResManager.getString(Res.string.JSON_STRING);

		// Create an AlertDialog to display prospective errors
		AlertDialog dialog = new AlertDialog();
		dialog.setTitle("Error");
		dialog.setMessage("Unable to read JSON string.");

		// Get ScreenParams to select the wanted JSON reading method
		ScreenParams params = getScreenParams();

		// Parse JSON string and display the content in a new Screen
		// In case of failure, display an error AlertDialog
		if (params.contains(READING_METHOD)) {
			switch (params.getInt(READING_METHOD)) {
			case USE_JSONARRAY:
				try {
					readJsonUsingJSONArray(jsonString, scrollViewContent);
				} catch (JSONException e) {
					controller.showDialog(dialog);
					controller.popScreen();
				}
				break;

			case USE_JSONREADER:
				try {
					readJsonUsingJSONReader(jsonString, scrollViewContent);
				} catch (Exception e) {
					controller.showDialog(dialog);
					controller.popScreen();
				}
				break;

			default:
				controller.popScreen();
			}
		} else {
			controller.popScreen();
		}
	}

	/**
	 * Reads a JSON encoded string using com.neomades.JSONArray and
	 * com.neomades.JSONObject
	 * 
	 * @throws JSONException
	 */
	private void readJsonUsingJSONArray(String jsonString, VerticalLayout scrollViewContent) throws JSONException {
		// The root element of the string is a JSON array
		JSONArray jsonArray = new JSONArray(jsonString);

		// The array contains JSON objects
		// Loop over each object to get the wanted informations
		for (int i = 0; i < jsonArray.length(); i++) {

			// Get the relevant JSON object
			JSONObject jsonObject = jsonArray.getJSONObject(i);

			// Get the value of the key "name" from the JSON
			// object corresponding to the key "user"
			String userName = jsonObject.getJSONObject(TAG_OBJECT_USER).getString(TAG_OBJECT_USERNAME);

			// Get the value of the key "text"
			String message = jsonObject.getString(TAG_OBJECT_TEXT);

			// Append the content in the ScrollView
			appendItemView(scrollViewContent, userName, message);
		}
	}

	/**
	 * Reads a JSON encoded string using com.neomades.JSONReader
	 * 
	 * @throws JSONException
	 */
	private void readJsonUsingJSONReader(String jsonString, VerticalLayout scrollViewContent) throws IOException {

		// Create a JSONReader
		JSONReader reader = new JSONReader(jsonString);

		// The root element of the string is a JSON array
		reader.beginArray();

		// The array contains JSON objects
		// Loop over each object to get the wanted informations
		while (reader.hasNext()) {

			// Enter JSONObject
			reader.beginObject();

			// Skip id key and its value
			reader.skipValue();
			reader.skipValue();

			// Skip "text" key and get value
			reader.skipValue();
			String message = reader.nextString();

			// Skip "user" key and enter the JSON object value
			reader.skipValue();
			reader.beginObject();

			// Skip "name" key and get value
			reader.skipValue();
			String userName = reader.nextString();

			// Skip "followers_count" key and its value
			reader.skipValue();
			reader.skipValue();

			// Exit JSON objects
			reader.endObject();
			reader.endObject();

			// Append the content in the ScrollView
			appendItemView(scrollViewContent, userName, message);
		}
		// Exit JSON array
		reader.endArray();

		// Close reader
		reader.close();
	}

	/**
	 * Append a VerticalLayout containing the give user name and message in the
	 * given VerticalLayout
	 * 
	 * @param userName
	 * @param message
	 * @return
	 */
	private void appendItemView(VerticalLayout scrollViewContent, String userName, String message) {
		VerticalLayout itemLayout = (VerticalLayout) View.inflateXML(Res.layout.DISCUSSION_ITEM);

		TextLabel userNameTextLabel = (TextLabel) itemLayout.findView(Res.id.DISCUSSION_USER_NAME);
		userNameTextLabel.setFont(Font.createFont(Font.DEFAULT, Font.STYLE_ITALIC, 13));
		userNameTextLabel.setText(userName + " says :");

		TextLabel contentTextLabel = (TextLabel) itemLayout.findView(Res.id.DISCUSSION_TEXT);
		contentTextLabel.setFont(Font.createFont(Font.DEFAULT, Font.STYLE_BOLD, 13));
		contentTextLabel.setText(message);

		scrollViewContent.addView(itemLayout);
	}

}
