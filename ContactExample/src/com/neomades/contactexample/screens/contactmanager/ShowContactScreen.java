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

public class ShowContactScreen extends Screen implements ClickListener, ContactResultListener {

	private Contact contact;

	private Button showContactButton;

	private TextLabel nameField;
	private TextLabel phoneField;
	private TextLabel emailField;
	private TextLabel resultMessageField;

	protected void onCreate() {
		setTitle(Res.string.SHOW_TITLE);
		setContent(Res.layout.SHOW_CONTACT_SCREEN);

		// Disable "Show Contact" button
		showContactButton = (Button) findView(Res.id.button_show_contact);
		showContactButton.setEnabled(false);
		showContactButton.setClickListener(this);

		resultMessageField = (TextLabel) findView(Res.id.operation_result);
		nameField = (TextLabel) findView(Res.id.name);
		phoneField = (TextLabel) findView(Res.id.phone_number);
		emailField = (TextLabel) findView(Res.id.email);

		Button button = (Button) findView(Res.id.button_pick_contact);
		button.setClickListener(this);
	}


	public void onContactResult(ContactResult result) {
		if (result.isSuccess()) {
			switch (result.getResultType()) {
				case ContactResult.TYPE_PICK_SINGLE:
					onContactPicked( (Contact) result.getData());
					break;
					
				case ContactResult.TYPE_SHOW:
					onContactShown(result.getMessage());
					break;
	
				default:
					// this case is not possible
					break;
			}
		} else {
			onContactError(result.getMessage());
		}
	}

	private void onContactError(String message) {
		// An error has occurred,
		// display error's stacktrace
		resultMessageField.setText(ResManager.getString(Res.string.OP_RESULT_ERROR) + message);
	}

	private void onContactShown(String message) {
		// Show contact operation is successful

		// Empty text labels
		nameField.setText("");
		phoneField.setText("");
		emailField.setText("");

		// Display operation's result
		resultMessageField.setText(ResManager.getString(Res.string.OP_RESULT) + message);

		// Enable "Show Contact" button
		showContactButton.setEnabled(false);
	}

	private void onContactPicked(Contact result) {
		// Contact picker operation is successful
		contact = result;
		
		String displayName;
		String phoneNumber;
		String emailAddress;
		if (contact != null) {
			displayName = contact.getDisplayName();
			phoneNumber = contact.getPhoneNumber();
			emailAddress = contact.getEmailAddress();
		} else {
			displayName = "";
			phoneNumber = "";
			emailAddress = "";
		}

		// Populate text labels
		nameField.setText(displayName);
		phoneField.setText(phoneNumber);
		emailField.setText(emailAddress);

		// Enable "Show Contact" button
		showContactButton.setEnabled(true);
	}

	public void onClick(View view) {
		int id = view.getId();
		ContactManager manager = ContactManager.getDefault();
		switch (id) {
			case Res.id.button_pick_contact:
				manager.pickSingleContact(this);
				break;
	
			case Res.id.button_show_contact:
				manager.showContact(contact, this);
				break;
	
			default:
				break;
		}
	}

}
