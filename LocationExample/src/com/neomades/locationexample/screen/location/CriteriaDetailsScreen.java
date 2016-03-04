package com.neomades.locationexample.screen.location;

import com.neomades.app.Screen;
import com.neomades.graphics.Color;
import com.neomades.location.Criteria;
import com.neomades.locationexample.Colors;
import com.neomades.locationexample.Res;
import com.neomades.locationexample.util.CriteriaPreferences;
import com.neomades.locationexample.util.NumberUtils;
import com.neomades.ui.CheckBox;
import com.neomades.ui.ComboBox;
import com.neomades.ui.TextField;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.dialog.AlertDialog;
import com.neomades.ui.listeners.CheckChangedListener;
import com.neomades.ui.menu.Menu;
import com.neomades.ui.menu.MenuItem;

/**
 * Application page screen
 */
public final class CriteriaDetailsScreen extends Screen {

	private static final int INDEX_POWER_HIGH = 3;
	private static final int INDEX_POWER_MEDIUM = 2;
	private static final int INDEX_POWER_LOW = 1;
	private static final int INDEX_POWER_NO_REQUIRED = 0;

	private static final int INDEX_NONE = -1;

	private static final int INDEX_ACCURACY_FINE = 1;
	private static final int INDEX_ACCURACY_DEFAULT = 0;

	private CheckBox useDefaultCriteriaCheckBox;
	private TextLabel accuracy;
	private ComboBox accuracyComboBox;
	private TextLabel minTime;
	private TextField minTimeResult;
	private TextLabel minDistance;
	private TextField minDistanceResult;
	private TextLabel powerRequirementText;
	private ComboBox powerRequirementComboBox;
	private CheckBox costCheckBox;
	private CheckBox altitudeCheckBox;

	public void onCreate() {
		setTitle(Res.string.PREFERENCES);
		setContent(Res.layout.CRITERIA_DETAILS_SCREEN);

		useDefaultCriteriaCheckBox = (CheckBox) findView(Res.id.ID_USE_DEFAULT_CRITERIA);
		accuracy = (TextLabel) findView(Res.id.ID_ACCURACY);
		accuracyComboBox = (ComboBox) findView(Res.id.ID_ACCURACY_RESULT);
		minTime = (TextLabel) findView(Res.id.ID_MIN_TIME);
		minTimeResult = (TextField) findView(Res.id.ID_MIN_TIME_RESULT);
		minDistance = (TextLabel) findView(Res.id.ID_MIN_DISTANCE);
		minDistanceResult = (TextField) findView(Res.id.ID_MIN_DISTANCE_RESULT);
		powerRequirementText = (TextLabel) findView(Res.id.ID_POWER_REQUIREMENT);
		powerRequirementComboBox = (ComboBox) findView(Res.id.ID_POWER_REQUIREMENT_RESULT);
		costCheckBox = (CheckBox) findView(Res.id.ID_COST_ALLOWED);
		altitudeCheckBox = (CheckBox) findView(Res.id.ID_ALTITUDE_REQUIRED);

		accuracyComboBox.addItem("DEFAULT");
		accuracyComboBox.addItem("FINE");

		powerRequirementComboBox.addItem("NO REQUIREMENT");
		powerRequirementComboBox.addItem("LOW");
		powerRequirementComboBox.addItem("MEDIUM");
		powerRequirementComboBox.addItem("HIGH");

		useDefaultCriteriaCheckBox.setCheckChangedListener(new CheckChangedListener() {
			public void onCheckChange(View view, boolean checked) {
				setFormEnabled(!checked);
			}
		});

		loadCriteria();

		setFormEnabled(!CriteriaPreferences.getDefault().isDefaultCriteria());
	}

	/**
	 * Enable or disable the form
	 * 
	 * @param enabled
	 */
	private void setFormEnabled(boolean enabled) {
		useDefaultCriteriaCheckBox.setChecked(!enabled);
		Color colorToSet = enabled ? Colors.ENABLED_COLOR : Colors.DISABLED_COLOR;
		accuracy.setTextColor(colorToSet);
		accuracyComboBox.setEnabled(enabled);
		powerRequirementComboBox.setEnabled(enabled);
		costCheckBox.setEnabled(enabled);
		altitudeCheckBox.setEnabled(enabled);
		minTime.setTextColor(colorToSet);
		minTimeResult.setEnabled(enabled);
		minDistance.setTextColor(colorToSet);
		minDistanceResult.setEnabled(enabled);
		powerRequirementText.setTextColor(colorToSet);
	}

	/**
	 * Select the correct power requirement in the ComboBox based on the given
	 * parameter
	 * 
	 * @param powerRequirement
	 */
	private static int toPowerRequirementComboBoxIndex(int powerRequirement) {
		switch (powerRequirement) {
		case Criteria.NO_REQUIREMENT:
			return INDEX_POWER_NO_REQUIRED;
		case Criteria.POWER_LOW:
			return INDEX_POWER_LOW;
		case Criteria.POWER_MEDIUM:
			return INDEX_POWER_MEDIUM;
		case Criteria.POWER_HIGH:
			return INDEX_POWER_HIGH;
		}
		return INDEX_NONE;
	}

	/**
	 * Get the power requirement level, based on the ComboBox selected index
	 * 
	 * @param powerRequirementIndex
	 * @return
	 */
	private static int toPowerRequirement(int powerRequirementIndex) {
		int powerRequirementResult = Criteria.NO_REQUIREMENT;
		switch (powerRequirementIndex) {
		case INDEX_POWER_NO_REQUIRED:
			powerRequirementResult = Criteria.NO_REQUIREMENT;
			break;
		case INDEX_POWER_LOW:
			powerRequirementResult = Criteria.POWER_LOW;
			break;
		case INDEX_POWER_MEDIUM:
			powerRequirementResult = Criteria.POWER_MEDIUM;
			break;
		case INDEX_POWER_HIGH:
			powerRequirementResult = Criteria.POWER_HIGH;
			break;
		}
		return powerRequirementResult;
	}

	/**
	 * Select the correct accuracy in the ComboBox based on the given parameter
	 * 
	 * @param accuracy
	 */
	private static int toAccuracyComboBoxIndex(int accuracy) {
		switch (accuracy) {
		case Criteria.ACCURACY_DEFAULT:
			return INDEX_ACCURACY_DEFAULT;
		case Criteria.ACCURACY_FINE:
			return INDEX_ACCURACY_FINE;
		}
		return INDEX_NONE;
	}

	/**
	 * Get the accuracy, based on the ComboBox selected index
	 * 
	 * @param accuracyIndex
	 * @return
	 */
	private static int toAccuracy(int accuracyIndex) {
		int accuracyResult = Criteria.NO_REQUIREMENT;
		switch (accuracyIndex) {
		case INDEX_ACCURACY_DEFAULT:
			accuracyResult = Criteria.ACCURACY_DEFAULT;
			break;
		case INDEX_ACCURACY_FINE:
			accuracyResult = Criteria.ACCURACY_FINE;
			break;
		default:
			accuracyResult = Criteria.NO_REQUIREMENT;
			break;
		}
		return accuracyResult;
	}

	/**
	 * Shows an alert dialog with the given message
	 * 
	 * @param msg
	 */
	private void showDialog(String msg) {
		AlertDialog dialog = new AlertDialog();
		dialog.setMessage(msg);
		controller.showDialog(dialog);
	}

	protected void onMenuCreate(Menu menu) {
		MenuItem saveItem = new MenuItem(Res.string.SAVE);
		menu.addItem(saveItem);
	}

	protected void onMenuAction(MenuItem menuItem) {
		// only one item
		saveCriteria();
		controller.popScreen();
	}

	/**
	 * Fill the form with the Criteria currently set in the preferences
	 * 
	 * @param criteria
	 */
	private void loadCriteria() {
		Criteria criteria = CriteriaPreferences.getDefault().getCurrentCriteria();
		accuracyComboBox.setSelectedIndex(toAccuracyComboBoxIndex(criteria.getAccuracy()));
		powerRequirementComboBox.setSelectedIndex(toPowerRequirementComboBoxIndex(criteria.getPowerRequirement()));
		minDistanceResult.setText(criteria.getMinDistance() + "");
		minTimeResult.setText(criteria.getMinTime() + "");
		costCheckBox.setChecked(criteria.isCostAllowed());
		altitudeCheckBox.setChecked(criteria.isAltitudeRequired());
	}

	/**
	 * Fill the Criteria currently set in the preferences with values from the
	 * form
	 */
	private void saveCriteria() {
		Criteria criteria = new Criteria();
		if (!useDefaultCriteriaCheckBox.isChecked()) {
			criteria.setAccuracy(toAccuracy(accuracyComboBox.getSelectedIndex()));
			int requiredMinTime = NumberUtils.verifyInteger(minTimeResult.getText());
			if (requiredMinTime == -1) {
				showDialog("Minimum time must be a positive integer !");
			} else {
				criteria.setMinTime(requiredMinTime);
			}

			int requiredMinDistance = NumberUtils.verifyInteger(minDistanceResult.getText());
			if (requiredMinDistance == -1) {
				showDialog("Minimum distance must be a positive integer !");
			} else {
				criteria.setMinDistance(requiredMinDistance);
			}
			criteria.setPowerRequirement(toPowerRequirement(powerRequirementComboBox.getSelectedIndex()));
			criteria.setCostAllowed(costCheckBox.isChecked());
			criteria.setAltitudeRequired(altitudeCheckBox.isChecked());
		}

		// update the preferences
		CriteriaPreferences criteriaPreferences = CriteriaPreferences.getDefault();
		criteriaPreferences.setDefaultCriteria(useDefaultCriteriaCheckBox.isChecked());
		criteriaPreferences.setCurrentCriteria(criteria);
	}

}
