package com.neomades.contactexample.screens.contactmanager;

import com.neomades.app.ResManager;
import com.neomades.app.Screen;
import com.neomades.contact.Contact;
import com.neomades.contact.ContactManager;
import com.neomades.contact.ContactResult;
import com.neomades.contact.ContactResultListener;
import com.neomades.contactexample.Res;
import com.neomades.ui.Button;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;

/**
 * Native contact picker example's screen
 */
public class PickContactScreen extends Screen implements ClickListener, ContactResultListener {

	private TextLabel nameField;
	private TextLabel phoneField;
	private TextLabel emailField;
	private TextLabel resultMessageField;

	protected void onCreate() {
		setTitle(Res.string.PICK_TITLE);
		setContent(Res.layout.PICK_CONTACT_SCREEN);

		resultMessageField = (TextLabel) findView(Res.id.operation_result);
		nameField = (TextLabel) findView(Res.id.name);
		phoneField = (TextLabel) findView(Res.id.phone_number);
		emailField = (TextLabel) findView(Res.id.email);

		// Attach ClickListener to button
		Button button = (Button) findView(Res.id.button_pick_contact);
		button.setClickListener(this);

	}

	public void onContactResult(ContactResult result) {
		if (result.isSuccess()) {
			onContactPicked((Contact) result.getData(), result.getMessage());
		} else if (result.isCancelled()) {
			onContactPickCancelled(result.getMessage());
		} else {
			onContactPickError(result.getMessage());
		}
	}

	private void onContactPickCancelled(String message) {
		// User has cancelled the operation,
		// we display operation's result
		resultMessageField.setText(ResManager.getString(Res.string.OP_RESULT) + message);
	}

	private void onContactPickError(String message) {
		// An error has occurred,
		// we display error's stacktrace
		resultMessageField.setText(Res.string.OP_RESULT_ERROR + message);
	}

	private void onContactPicked(Contact contact, String message) {
		// Contact picker operation is successful
		// Populate text fields
		nameField.setText(contact.getDisplayName());
		phoneField.setText(contact.getPhoneNumber());
		emailField.setText(contact.getEmailAddress());
		resultMessageField.setText(ResManager.getString(Res.string.OP_RESULT) + message);
	}

	public void onClick(View view) {
		switch (view.getId()) {
			case Res.id.button_pick_contact:
				ContactManager.getDefault().pickSingleContact(this);
				break;
	
			default:
				break;
		}
	}
}