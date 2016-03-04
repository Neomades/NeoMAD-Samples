package com.neomades.asynclist.screens.lists;

import java.util.Random;
import java.util.Vector;

import com.neomades.app.Screen;
import com.neomades.app.ScreenParams;
import com.neomades.asynclist.Res;
import com.neomades.asynclist.adapterwithholder.ItemWithSectionListAdapter;
import com.neomades.asynclist.model.Element;
import com.neomades.asynclist.model.Item;
import com.neomades.asynclist.model.Section;
import com.neomades.ui.Button;
import com.neomades.ui.ListView;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;
import com.neomades.ui.listeners.ItemClickedListener;

public class AsyncListWithSectionScreen extends Screen implements ItemClickedListener, ClickListener {

	private static String[] names = { "Martin Luther King", "Abraham Lincoln", "Mother Teresa", "Albert Einstein", "George Washington", "Thomas Edison", "Benjamin Franklin",
			"William Shakespeare", "Bill Gates", "Christopher Columbus", "Ludwig van Beethoven", "Steve Jobs", "Neil Armstrong", "Mohammad Ali" };

	// model
	private Vector items = new Vector();

	// views
	private ItemWithSectionListAdapter listAdapter;

	private ListView list;

	protected void onCreate() {

		populateData();

		listAdapter = new ItemWithSectionListAdapter(items);
		setContent(Res.layout.ASYNC_LIST_SCREEN);
		setTitle("Async List with Sections");

		// Set up the list with ListAdapter
		list = (ListView) findView(Res.id.list);
		list.setListAdapter(listAdapter);

		// IMPORTANT : ItemTypeAdapter will enable using many types of view
		// (item, section, header, footer...)
		list.setItemTypeAdapter(listAdapter);
		list.setItemClickedListener(this);

		// Button is displayed and will be used for reloading ListView's content
		Button reload = (Button) findView(Res.id.button_reload);
		reload.setClickListener(this);

	}

	// === ListView item click === //

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neomades.ui.listeners.ItemClickedListener#onItemClicked(int,
	 * com.neomades.ui.View)
	 */
	public void onItemClicked(int position, View itemView) {
		// position or itemView.getTag are two ways to access model
		// Item item = getItemAtPosition(position);
		Item item = listAdapter.getModelFromView(itemView);
		showItemDetails(item);
	}

	// === Reload button click === //

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neomades.ui.listeners.ClickListener#onClick(com.neomades.ui.View)
	 */
	public void onClick(View arg0) {
		reloadList();
	}

	// === internal methods === //

	/**
	 * Internal method.
	 * 
	 * Populate model with fake data.
	 */
	private void populateData() {
		Random r = new Random(System.currentTimeMillis());
		int count = 100;
		int sectionCount = 0;

		for (int i = 0; i < count; i++) {
			int type = r.nextInt(4);
			Element element;
			if (type == 1) {
				Section section = new Section();
				section.setName("Section " + sectionCount++);
				element = section;
			} else {
				Item item = new Item();
				item.setName(names[r.nextInt(names.length)]);
				item.setDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
						+ "Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.");

				element = item;
			}

			items.addElement(element);
		}
	}

	// === user action methods === //

	/**
	 * Action method.
	 * 
	 * Reloads the List content from model.
	 */
	private void reloadList() {
		// Change model content
		items.removeAllElements();
		populateData();

		// Reload ListView items from model
		list.notifyDataChanged();
	}

	/**
	 * Action method.
	 * 
	 * Shows a new Screen with details of the selected item.
	 * 
	 * @param item
	 *            item object from model
	 */
	private void showItemDetails(Item item) {
		ScreenParams itemParams = new ScreenParams();
		itemParams.putObject(ItemDetailsScreen.PARAMS_ITEM, item);
		controller.pushScreen(ItemDetailsScreen.class, itemParams);
	}

}
