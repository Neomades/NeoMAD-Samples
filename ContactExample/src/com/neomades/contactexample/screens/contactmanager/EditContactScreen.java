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

public class EditContactScreen extends Screen implements ClickListener, ContactResultListener {

	private Contact contact;

	private Button editButton;

	private TextLabel nameField;
	private TextLabel phoneField;
	private TextLabel emailField;
	private TextLabel operationResultField;


	protected void onCreate() {
		setTitle(Res.string.EDIT_TITLE);
		setContent(Res.layout.EDIT_CONTACT_SCREEN);

		// Disable "Edit Contact" button
		editButton = (Button) findView(Res.id.button_edit_contact);
		editButton.setEnabled(false);
		editButton.setClickListener(this);

		operationResultField = (TextLabel) findView(Res.id.operation_result);
		nameField = (TextLabel) findView(Res.id.name);
		phoneField = (TextLabel) findView(Res.id.phone_number);
		emailField = (TextLabel) findView(Res.id.email);

		// Attach ClickListener to buttons
		Button pickButton = (Button) findView(Res.id.button_pick_contact);
		pickButton.setClickListener(this);
	}

	public void onContactResult(ContactResult result) {
		Contact contact = null;
		String message = result.getMessage();
		if (result.isSuccess()) {
			switch (result.getResultType()) {
				case ContactResult.TYPE_PICK_SINGLE:
				case ContactResult.TYPE_EDIT:
					contact = (Contact) result.getData();
					message = "";
					break;
	
				default:
					break;
			}
		}
		setContact(contact);
		operationResultField.setText(ResManager.getString(Res.string.OP_RESULT) + message);

	}

	private void setContact(Contact contact) {
		this.contact = contact;

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

		editButton.setEnabled(contact != null);
		
		// Populate text labels
		nameField.setText(displayName);
		phoneField.setText(phoneNumber);
		emailField.setText(emailAddress);
	}

	public void onClick(View view) {
		int id = view.getId();
		ContactManager manager = ContactManager.getDefault();
		switch (id) {
			case Res.id.button_pick_contact:
				manager.pickSingleContact(this);
				break;
	
			case Res.id.button_edit_contact:
				if (contact != null) {
					manager.editContact(contact, this);
				}
				break;
	
			default:
				break;
		}
	}

}
