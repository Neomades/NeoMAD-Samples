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
 * Native contact creation example's screen
 */
public class AddContactScreen extends Screen implements ClickListener, ContactResultListener {

	private Contact contactPrefilled;

	private TextLabel contactNameField;
	private TextLabel contactPhoneField;
	private TextLabel contactEmailField;
	private TextLabel operationResultField;

	protected void onCreate() {
		setTitle(Res.string.ADD_TITLE);
		setContent(Res.layout.ADD_CONTACT_SCREEN);

		// Attach ClickListener to buttons
		attachClickListener(Res.id.button_add_contact);
		attachClickListener(Res.id.button_add_prefill_contact);

		operationResultField = (TextLabel) findView(Res.id.operation_result);
		contactNameField = (TextLabel) findView(Res.id.name);
		contactPhoneField = (TextLabel) findView(Res.id.phone_number);
		contactEmailField = (TextLabel) findView(Res.id.email);

		// Create and fill contactPrefilled object
		contactPrefilled = new Contact();
		contactPrefilled.setNamePrefix("MR.");
		contactPrefilled.setFirstName("John");
		contactPrefilled.setLastName("Doe");
		contactPrefilled.setPhoneNumber("0102030405");
		contactPrefilled.setStreet("12 rue du code");
		contactPrefilled.setCity("Bidart");
		contactPrefilled.setCountry("France");
		contactPrefilled.setEmailAddress("john.doe@neomades.com");
	}

	private void setContact(Contact c) {
		String displayName;
		String phoneNumber;
		String emailAddress;
		if (c != null) {
			displayName = c.getDisplayName();
			phoneNumber = c.getPhoneNumber();
			emailAddress = c.getEmailAddress();
		} else {
			displayName = "";
			phoneNumber = "";
			emailAddress = "";
		}
		
		// Populate text labels
		contactNameField.setText(displayName);
		contactPhoneField.setText(phoneNumber);
		contactEmailField.setText(emailAddress);
	}
	
	private void setResultMessage(String message) {
		operationResultField.setText(message);
	}

	private void attachClickListener(int viewId) {
		Button button = (Button) findView(viewId);

		if (button != null) {
			button.setClickListener(this);
		}
	}
	
	public void onContactResult(ContactResult result) {
		if (result.isSuccess()) {
			setContact((Contact) result.getData());
			setResultMessage(ResManager.getString(Res.string.OP_RESULT) + result.getMessage());
		} else if (result.isCancelled()) {
			// User has cancelled the operation
			setContact(null);
			setResultMessage(ResManager.getString(Res.string.OP_RESULT) + result.getMessage());
		} else {
			// An error has occurred,
			// we display error's stacktrace
			setContact(null);
			setResultMessage(ResManager.getString(Res.string.OP_RESULT_ERROR) + result.getMessage());
		}
	}

	public void onClick(View view) {
		ContactManager manager = ContactManager.getDefault();
		switch (view.getId()) {
		case Res.id.button_add_contact:
			manager.addContact(this);
			break;

		case Res.id.button_add_prefill_contact:
			manager.addContact(this.contactPrefilled, this);
			break;

		default:
			break;
		}
	}
}
