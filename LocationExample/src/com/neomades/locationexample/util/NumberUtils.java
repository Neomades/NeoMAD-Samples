package com.neomades.locationexample.util;

public final class NumberUtils {

	// Hide the constructor because this is an utility class.
	private NumberUtils() {
	}

	/**
	 * Convert a text to a numeric value.
	 * 
	 * @param input
	 * @return the value corresponding to the text, -1 if the text is not a
	 *         number
	 */
	public static int verifyInteger(String input) {
		int result = -1;
		try {
			result = Integer.parseInt(input);
		} catch (Exception e) {
			// the exception is ignored
		}
		return result;
	}

	/**
	 * Convert a text to a numeric value.
	 * 
	 * @param input
	 * @return the value corresponding to the text, -1 if the text is not a
	 *         number
	 */
	public static double verifyDouble(String input) {
		double result = -1;
		try {
			result = Double.parseDouble(input);
		} catch (Exception e) {
			// the exception is ignored
		}
		return result;
	}

	/**
	 * Convert a text to a numeric value.
	 * 
	 * @param input
	 * @return the value corresponding to the text, -1 if the text is not a
	 *         number
	 */
	public static float verifyFloat(String input) {
		float result = -1;
		try {
			result = Float.parseFloat(input);
		} catch (Exception e) {
			// the exception is ignored
		}
		return result;
	}
}
