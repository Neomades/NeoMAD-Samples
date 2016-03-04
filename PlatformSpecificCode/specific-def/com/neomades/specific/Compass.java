package com.neomades.specific;

public class Compass {

	/**
	 * We set the visibility to protected, because this attribute will be
	 * accessed by the class extending the generated abstract class
	 */
	protected CompassListener listener;

	/**
	 * This method is used to know if the compass is supported on the target
	 * platform.
	 * 
	 * @return true if the compass is supported (for the moment only on iOS,
	 *         Android, Windows Phone and Windows) and false if not supported
	 */
	public boolean isSupported() {
		return false;
	}

	/**
	 * Sets a listener, that will be called every time the compass orientation
	 * changes.
	 * 
	 * @param listener
	 */
	public void setCompassListener(CompassListener listener) {
		this.listener = listener;
	}
}