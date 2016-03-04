package com.neomades.cameraexample;

import java.io.InputStream;

import com.neomades.app.Screen;
import com.neomades.graphics.Image;
import com.neomades.media.Camera;
import com.neomades.media.CameraListener;
import com.neomades.ui.Button;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.View;
import com.neomades.ui.dialog.AlertDialog;
import com.neomades.ui.listeners.ClickListener;

/**
 * Main screen class. Implements:
 * <ul>
 * <li>ClickListener: used to trigger the camera event when the button is
 * clicked</li>
 * <li>CameraListener: used to handle the returned picture or the cancel event</li>
 * </ul>
 */
public final class MainScreen extends Screen implements ClickListener, CameraListener {

	private ImageLabel imageLabel;
	
	protected void onCreate() {
		this.setContent(Res.layout.MAINSCREEN);
		((Button) this.findView(Res.id.CAMERA_BUTTON)).setClickListener(this);
		imageLabel = ((ImageLabel) this.findView(Res.id.MAINSCREEN_IMAGELABEL));
	}

	public void onClick(View view) {
		// Create a default camera and start dialog
		// allowing to select gallery or built-in
		// camera applications
		// Dialog may be customized using :
		// - setActionTitle()
		// - setCameraActionText()
		// - setGalleryActionText()
		// - setCancelActionText()
		Camera mCamera = Camera.getDefault();
		
		// detach old picture to release heap memory
		imageLabel.setImage(null);
		
		mCamera.takePicture(this);
	}

	/*
	 * Called when the user successfully select a picture.
	 */
	public void onMediaCaptured(InputStream data) {
		Image selectedPicture = Image.createImage(data);
		imageLabel.setImage(selectedPicture);
	}

	/*
	 * Called when the user cancels the action.
	 */
	public void onMediaCaptureCancelled() {
		AlertDialog d = new AlertDialog();
		d.setTitle("Camera Example");
		d.setButtonText("OK");
		d.setMessage("You cancelled the action !");
		controller.showDialog(d);
	}

}