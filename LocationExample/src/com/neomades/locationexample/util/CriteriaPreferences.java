package com.neomades.locationexample.util;

import com.neomades.location.Criteria;

/**
 * Singleton class containing the preferences about the Criteria for location
 * requests.
 *
 */
public class CriteriaPreferences {

	private static CriteriaPreferences instance = new CriteriaPreferences();

	public static CriteriaPreferences getDefault() {
		return instance;
	}

	private Criteria current = new Criteria();

	private boolean isDefaultCriteria = true;

	public Criteria getCurrentCriteria() {
		return current;
	}

	public void setCurrentCriteria(Criteria newCriteria) {
		current = newCriteria;
	}

	public boolean isDefaultCriteria() {
		return isDefaultCriteria;
	}

	public void setDefaultCriteria(boolean check) {
		isDefaultCriteria = check;
	}
}
