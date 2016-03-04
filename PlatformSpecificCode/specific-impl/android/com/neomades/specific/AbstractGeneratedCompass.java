package com.neomades.specific;

public abstract class AbstractGeneratedCompass {

	protected com.neomades.specific.CompassListener listener;

	public boolean isSupported() {
		return false;
	}

	public void setCompassListener(com.neomades.specific.CompassListener listener) {
		this.listener = listener;
	}

}