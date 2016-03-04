package com.neomades.locationexample.screen.proximity;

import java.util.Vector;

import com.neomades.app.Screen;
import com.neomades.app.ScreenParams;
import com.neomades.location.LocationManager;
import com.neomades.location.ProximityRegion;
import com.neomades.locationexample.Res;
import com.neomades.ui.Button;
import com.neomades.ui.ListView;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.listeners.ClickListener;
import com.neomades.ui.listeners.ItemClickedListener;

public class ProximityRegionListScreen extends Screen implements ClickListener, ItemClickedListener {

	private static final int LIST_ITEM_PADDING = 20;

	private LocationManager locationManager = LocationManager.getDefault();

	private ListView list;

	public void onCreate() {
		setTitle(Res.string.MONITORED_REGIONS);
		setContent(Res.layout.PROXIMITY_REGION_LIST_SCREEN);
		Button buttonAddRegion = (Button) findView(Res.id.ID_BUTTON_ADD_REGION);
		buttonAddRegion.setClickListener(this);
		list = (ListView) findView(Res.id.ID_REGION_LISTVIEW);
		list.setItemClickedListener(this);
	}

	public void onResume() {
		// fill the list with the region names
		loadRegions();
	}

	/*
	 * Raised when the "Add Region" button is clicked. We push the screen
	 * containing the form to add a new region.
	 */
	public void onClick(View view) {
		addRegion();
	}

	/*
	 * Raised when an item of the list is clicked. We push the screen to show
	 * the details of the clicked region.
	 */
	public void onItemClicked(int index, View view) {
		// get the clicked region
		ProximityRegion toEdit = (ProximityRegion) locationManager.getProximityRegions().elementAt(index);
		editRegion(toEdit);
	}

	/**
	 * Pushes another screen to add a new region
	 */
	private void addRegion() {
		controller.pushScreen(ProximityRegionDetailsScreen.class);
	}

	/**
	 * Pushes another to edit the selected region
	 * 
	 * @param region
	 *            the selected region
	 */
	private void editRegion(ProximityRegion region) {

		// put the region to edit as a parameter
		ScreenParams params = new ScreenParams();
		params.putObject("region", region);

		// push the details screen
		controller.pushScreen(ProximityRegionDetailsScreen.class, params);

	}

	/**
	 * Loads proximity regions and show them in a ListView
	 */
	private void loadRegions() {
		list.removeAllViews();
		final Vector monitoredRegions = locationManager.getProximityRegions();
		for (int i = 0; i < monitoredRegions.size(); i++) {
			final ProximityRegion region = (ProximityRegion) monitoredRegions.elementAt(i);
			TextLabel regionLabel = new TextLabel("Region " + region.getId());
			regionLabel.setPadding(LIST_ITEM_PADDING);
			list.addView(regionLabel);
		}
	}

}
