package com.neomades.asynclist.adapter.base;

import java.util.Vector;

import com.neomades.ui.View;

public final class CompositeListAdapter extends BaseListAdapter {

	/**
	 * List of adapters
	 */
	private Vector adapters = new Vector();

	private int currentRelativeIndex = -1;

	private int currentAbsIndex;

	private int currentTypeCountOffset;

	private int currentAdapterIndex;

	private BaseListAdapter currentAdapter;

	/**
	 * @param i
	 * @return
	 */
	private BaseListAdapter getAdapter(int i) {
		return (BaseListAdapter) adapters.elementAt(i);
	}

	/**
	 * @param absIndex
	 * @return
	 */
	private Section toRelativeSection(int absIndex) {
		int relativeIndex = absIndex;
		int count = 0;
		int i = -1;
		while (absIndex > count) {
			i++;
			int relCount = getAdapter(i).getCount();
			count += relCount;
			relativeIndex -= relCount;
		}
		Section s = new Section();
		s.adapterIndex = i;
		s.relativeIndex = relativeIndex;
		return s;
	}

	/**
	 * @param absIndex
	 */
	private void moveToPosition(int absIndex) {
		if (currentAbsIndex != absIndex) {
			currentAbsIndex = absIndex;

			Section section = toRelativeSection(absIndex);
			currentRelativeIndex = section.relativeIndex;
			int newAdapterIndex = section.adapterIndex;

			if (newAdapterIndex == currentAdapterIndex) {
				// nothing
			} else {
				if (newAdapterIndex == currentAdapterIndex + 1) {
					currentTypeCountOffset += getAdapter(currentAdapterIndex).getViewTypeCount();

				} else if (newAdapterIndex == currentAdapterIndex - 1) {
					currentTypeCountOffset -= getAdapter(currentAdapterIndex).getViewTypeCount();
				} else {
					// compute from zero
					// accumulate getViewTypeCount() from all adapters
					int count = 0;
					for (int i = 0; i < currentAdapterIndex; i++) {
						count += getAdapter(i).getViewTypeCount();
					}
					currentTypeCountOffset = count;
				}
				currentAdapterIndex = newAdapterIndex;
				currentAdapter = getAdapter(currentAdapterIndex);
			}

		}
	}

	/**
	 * Adds an adapter
	 * 
	 * @param adapter
	 */
	public void addAdapter(BaseListAdapter adapter) {
		adapters.addElement(adapter);
	}

	/*
	 * Called once
	 */
	public int getCount() {
		resetPosition();

		// accumulate getCount() from all adapters
		int count = 0;
		for (int i = 0; i < adapters.size(); i++) {
			count += getAdapter(i).getCount();
		}

		return count;
	}

	private void resetPosition() {
		currentAbsIndex = -1;
		currentAdapter = null;
		currentAdapterIndex = -1;
		currentRelativeIndex = -1;
		currentTypeCountOffset = 0;
	}

	/*
	 * Called once
	 */
	public boolean areAllItemsEnabled() {
		boolean enabled = true;

		// accumulate areAllItemsEnabled() from all adapters
		for (int i = 0; i < adapters.size(); i++) {
			enabled &= getAdapter(i).areAllItemsEnabled();
			if (!enabled) {
				break;
			}
		}

		return enabled;
	}

	/*
	 * Called once
	 */
	public int getViewTypeCount() {
		int count = 0;

		// accumulate getViewTypeCount() from all adapters
		for (int i = 0; i < adapters.size(); i++) {
			count += getAdapter(i).getViewTypeCount();
		}

		return count;
	}

	public View getView(int absIndex, View convertView, View parentView) {
		moveToPosition(absIndex);

		// switch the right adapter and give the right index
		return currentAdapter.getView(currentRelativeIndex, convertView, parentView);
	}

	public boolean isEnabled(int absIndex) {
		moveToPosition(absIndex);

		// compute with all adapters
		return currentAdapter.isEnabled(currentRelativeIndex);
	}

	public int getItemViewType(int absIndex) {
		moveToPosition(absIndex);

		return currentTypeCountOffset + currentAdapter.getItemViewType(currentRelativeIndex);
	}

	public Object getModelAtIndex(int absIndex) {
		moveToPosition(absIndex);

		return currentAdapter.getModelAtIndex(currentRelativeIndex);
	}

	/**
	 *  
	 */
	class Section {
		int adapterIndex;
		int relativeIndex;

	}
}
