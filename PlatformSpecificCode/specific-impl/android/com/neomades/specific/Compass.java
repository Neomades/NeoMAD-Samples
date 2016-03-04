package com.neomades.specific;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.neomades.app.Application;
import com.neomades.platform.SpecificUtils;

public class Compass extends AbstractGeneratedCompass implements SensorEventListener {
	
	public Compass() {
		// we get the current context with the SpecificUtils class
		Context context = SpecificUtils.getSpecificApplication(Application.getCurrent());
		
		// then we use this context to get the sensor
		SensorManager mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);

		Sensor accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		Sensor magnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

		mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
		mSensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_UI);
	}
	
	public boolean isSupported() {
		return true;
	}

	float[] mGravity;
	float[] mGeomagnetic;
	
	public void onSensorChanged(SensorEvent event) {
		if (this.listener != null) {
			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
				mGravity = event.values;
			if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
				mGeomagnetic = event.values;
			if (mGravity != null && mGeomagnetic != null) {
				float R[] = new float[9];
				float I[] = new float[9];
				boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);
				if (success) {
					float orientation[] = new float[3];
					SensorManager.getOrientation(R, orientation);
					float azimut = -orientation[0]*360/(2*3.14159f);
					//calculation to obtain the correct orientation
					listener.onDirectionChanged(this, ((int) azimut + 360) % 360);
				}
			}
		}
	}

	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// unused callback
	}
}