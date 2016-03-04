package com.neomades.slidemenuexample.slidemenu;

import com.neomades.slidemenuexample.Res;
import com.neomades.slidemenuexample.screens.AboutScreen;
import com.neomades.slidemenuexample.screens.FindPeopleScreen;
import com.neomades.slidemenuexample.screens.HomeScreen;
import com.neomades.slidemenuexample.screens.PhotosScreen;
import com.neomades.slidemenuexample.slidemenu.base.SlidingMenuItem;
import com.neomades.slidemenuexample.slidemenu.base.SlidingPaneScreen;

/**
 * Shows a List of items (SlidingMenu). Selecting one of these items will push a
 * screen in the middle screen or in the menu screen, depending on the item.
 */
public class LeftScreen extends SlidingPaneScreen {

	private static final int HOME = 0;
	private static final int FIND_PEOPLE = 1;
	private static final int PHOTOS = 2;
	private static final int ABOUT = 3;

	protected void onCreate() {
		super.onCreate();
		setTitle("Left menu");
	}

	/*
	 * Called when an item of the ListView in the screen is selected.
	 * 
	 * @see
	 * com.neomades.slidemenuexample.slidemenu.base.SlidingPaneScreen#onItemClicked
	 * (com.neomades.slidemenuexample.slidemenu.base.SlidingMenuItem)
	 */
	public void onItemClicked(SlidingMenuItem item) {
		switch (item.getId()) {
		case HOME:
			showHome();
			break;
		case FIND_PEOPLE:
			showFindPeople();
			break;
		case PHOTOS:
			showPhotos();
			break;
		case ABOUT:
			showAbout();
			break;
		}
	}

	/*
	 * Initializes the item of the ListView in the screen.
	 * 
	 * @see
	 * com.neomades.slidemenuexample.slidemenu.base.SlidingPaneScreen#onCreateItems
	 * ()
	 */
	protected void onCreateItems() {
		addItem(new SlidingMenuItem(HOME, "Home", Res.image.ic_home));
		addItem(new SlidingMenuItem(FIND_PEOPLE, "Find People", Res.image.ic_people));
		addItem(new SlidingMenuItem(PHOTOS, "Photos", Res.image.ic_photos));
		addItem(new SlidingMenuItem(ABOUT, "About", Res.image.ic_about));
	}

	/**
	 * Opens "About screen" in the middle screen.
	 */
	private void showAbout() {
		controller.getParentController().pushScreen(AboutScreen.class);
	}

	/**
	 * Opens "Photos screen" in the middle screen.
	 */
	private void showPhotos() {
		controller.getRootController().pushScreen(PhotosScreen.class);
	}

	/**
	 * Opens "Find people screen" in the menu screen.
	 */
	private void showFindPeople() {
		controller.pushScreen(FindPeopleScreen.class);
	}

	/**
	 * Opens "Home screen" in the middle screen. All the screen stack is
	 * destroyed.
	 */
	private void showHome() {
		controller.getParentController().resetScreenStack(HomeScreen.class);
	}

}
