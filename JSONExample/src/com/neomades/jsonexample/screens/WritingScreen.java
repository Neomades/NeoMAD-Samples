package com.neomades.jsonexample.screens;

import java.io.IOException;

import com.neomades.app.Screen;
import com.neomades.json.JSONArray;
import com.neomades.json.JSONException;
import com.neomades.json.JSONObject;
import com.neomades.json.JSONWriter;
import com.neomades.jsonexample.Res;
import com.neomades.ui.CrossThreadException;
import com.neomades.ui.TextLabel;

public class WritingScreen extends Screen {

	// JSON node names
	private static final String TAG_ID = "id";
	private static final String TAG_TEXT = "text";
	private static final String TAG_USER = "user";
	private static final String TAG_NAME = "name";
	private static final String TAG_FOLLOWERS_COUNT = "followers_count";

	protected void onCreate() {
		setTitle("WritingScreen");

		// Set Screen content
		setContent(Res.layout.WRITING_SCREEN);

		// Create objects that will be represented as a JSON string
		User user1 = new User("neomad_newb", 41);
		User user2 = new User("NeoMAD support team", 2);

		Message message1 = new Message(912345678901L, "How do I write JSON on NeoMAD ?", user1);
		Message message2 = new Message(912345678902L, "@neomad_newb just use com.neomades.json.JSONWriter!", user2);
		Message message3 = new Message(912345678903L, "@neomad_newb you can also use com.neomades.json.JSONObject/JSONArray.", user2);

		Message[] messages = new Message[] { message1, message2, message3 };

		// Write JSON string using first method
		TextLabel textLabel1 = (TextLabel) findView(Res.id.TL_WRITING_WITH_JSONARRAY_CONTENT);
		try {
			textLabel1.setText(writeUsingJSONArray(messages));
		} catch (CrossThreadException e) {
			// Handle error here
			e.printStackTrace();
		} catch (JSONException e) {
			// Handle error here
			e.printStackTrace();
		}

		// Write JSON string using second method
		TextLabel textLabel2 = (TextLabel) findView(Res.id.TL_WRITING_WITH_JSONWRITER_CONTENT);
		try {
			textLabel2.setText(writeUsingJSONWriter(messages));
		} catch (CrossThreadException e) {
			// Handle error here
			e.printStackTrace();
		} catch (IOException e) {
			// Handle error here
			e.printStackTrace();
		}
	}

	/**
	 * Write a JSON encoded string using com.neomades.JSONArray and
	 * com.neomades.JSONObject
	 * 
	 * @param messages
	 * @return
	 * @throws JSONException
	 */
	private String writeUsingJSONArray(Message[] messages) throws JSONException {
		// Create root JSON array containing messages
		JSONArray array = new JSONArray();

		// Loop over each message
		for (int i = 0; i < messages.length; i++) {
			// Create a JSON object containing the message
			JSONObject messageObject = new JSONObject();

			// Append message id key/value pair
			messageObject.put(TAG_ID, messages[i].getId());

			// Append message text key/value pair
			messageObject.put(TAG_TEXT, messages[i].getText());

			// Create a JSON object containing the user
			JSONObject userObject = new JSONObject();

			// Append user name key/value pair
			userObject.put(TAG_NAME, messages[i].getUser().getName());

			// Append user followers count key/value pair
			userObject.put(TAG_FOLLOWERS_COUNT, messages[i].getUser().getFollowersCount());

			// Append user key/value pair
			messageObject.put(TAG_USER, userObject);

			// Append message JSON object to root JSON array
			array.put(messageObject);
		}

		// Return JSON encoded string
		return array.toString();
	}

	/**
	 * Write a JSON encoded string using com.neomades.JSONWriter
	 * 
	 * @param messages
	 * @return
	 * @throws IOException
	 */
	private String writeUsingJSONWriter(Message[] messages) throws IOException {
		// Create writer
		JSONWriter writer = new JSONWriter();

		// Create root JSON array containing messages
		writer.beginArray();

		// Loop over each message
		for (int i = 0; i < messages.length; i++) {
			// Create an object
			writer.beginObject();

			// Append message id key/value pair
			writer.name(TAG_ID);
			writer.value(messages[i].getId());

			// Append message text key/value pair
			writer.name(TAG_TEXT);
			writer.value(messages[i].getText());

			// Append message user key
			writer.name(TAG_USER);

			// Create an Object for storing user informations
			writer.beginObject();

			// Append user name key/value pair
			writer.name(TAG_NAME);
			writer.value(messages[i].getUser().getName());

			// Append user followers count key/value pair
			writer.name(TAG_FOLLOWERS_COUNT);
			writer.value(messages[i].getUser().getFollowersCount());

			// Close first object
			writer.endObject();

			// Close second object
			writer.endObject();
		}

		// Close array
		writer.endArray();

		// Return JSON encoded string
		return writer.toString();
	}

	/**
	 * Sample class to be converted into a JSON string
	 * 
	 */
	private class User {
		private String name;
		private int followersCount;

		public User(String name, int followersCount) {
			this.name = name;
			this.followersCount = followersCount;
		}

		public String getName() {
			return this.name;
		}

		public int getFollowersCount() {
			return this.followersCount;
		}
	}

	/**
	 * Sample class to be converted into a JSON string
	 * 
	 */
	private class Message {

		private long id;
		private String text;
		private User user;

		public Message(long id, String text, User user) {
			this.id = id;
			this.text = text;
			this.user = user;
		}

		public long getId() {
			return this.id;
		}

		public String getText() {
			return this.text;
		}

		public User getUser() {
			return this.user;
		}
	}

}
