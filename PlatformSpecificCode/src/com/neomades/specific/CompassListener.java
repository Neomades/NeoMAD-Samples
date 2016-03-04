package com.neomades.specific;

public interface CompassListener {
	/**
	 * This listener is called each time the direction of the compass changes
	 * 
	 * @param compass
	 *            the compass which direction has changed
	 * @param value
	 *            the new orientation value (should be from 0 to 359)
	 */
	void onDirectionChanged(Compass compass, int value);
}