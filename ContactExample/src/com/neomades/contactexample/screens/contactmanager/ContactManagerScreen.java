package com.neomades.contactexample.screens.contactmanager;

import com.neomades.app.Screen;
import com.neomades.contactexample.Res;
import com.neomades.ui.ListView;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ItemClickedListener;

/**
 *
 */
public final class ContactManagerScreen extends Screen implements ItemClickedListener {

	protected void onCreate() {
		setTitle(Res.string.CONTACT_MANAGER_TITLE);
		setContent(Res.layout.CONTACT_MANAGER_SCREEN);
		
		ListView list = (ListView)findView(Res.id.contact_manager_screen_list);
		list.setItemClickedListener(this);
	}

	public void onItemClicked(int index, View child) {
		switch (child.getId()) {
			case Res.id.add_contact_item:
				controller.pushScreen(AddContactScreen.class);
				break;
				
			case Res.id.edit_contact_item:
				controller.pushScreen(EditContactScreen.class);
				break;
				
			case Res.id.show_contact_item:
				controller.pushScreen(ShowContactScreen.class);
				break;
				
			case Res.id.pick_contact_item:
				controller.pushScreen(PickContactScreen.class);
				break;
	
			default:
				// not possible
				break;
		}
	}

}
