package com.neomades.animationexample;

import com.neomades.app.Screen;
import com.neomades.graphics.Display;
import com.neomades.ui.ImageLabel;
import com.neomades.ui.VerticalLayout;
import com.neomades.ui.View;
import com.neomades.ui.animation.Animation;
import com.neomades.ui.animation.AnimationListener;
import com.neomades.ui.listeners.ClickListener;

/**
 * This screen demonstrates how to use the Neomades API to animate views and
 * chain animations.
 * <p>
 * The animations for this example are divided in four phases:
 * <ul>
 * <li>The gray layout with a text will disappear using a fade effect.</li>
 * <li>A door will open from the middle of the screen. It is divided in two
 * parts, the first will translate to the top of the screen, the second one will
 * translate to the bottom of the screen.</li>
 * <li>When the door opened: it will trigger the second animation, a fabric door
 * which was behind the door will translate exactly as the door did.</li>
 * <li>When the fabric door opened, it triggers the third animation: a bug will
 * move between the left and the right limits of the screen.</li>
 * </ul>
 * </p>
 */
public class AnimationScreen extends Screen implements AnimationListener, ClickListener {
	
	/** Animation duration of the fade effect of the top layout (in ms) */
	private static final long FADE_DURATION_MS = 1000;

	/** Animation duration of the translation of the door and the fabric (in ms) */
	private static final long OPEN_TRANSLATION_DURATION_MS = 2000;
	
	/** Animation duration of the bug translations (in ms) */
	private static final long BUG_TRANSLATION_DURATION_MS = 1000;
	
	/** Animation duration of the bug rotations (in ms) */
	private static final long BUG_ROTATION_DURATION_MS = 1000;
	
	/** Angle of the rotation of the bug (in degree) */
	private static final long BUG_ROTATION_ANGLE = 180;

	private Animation doorTopAnimation;
	private Animation doorBottomAnimation;
	private Animation fabricTopAnimation;
	private Animation fabricBottomAnimation;
	private Animation bugGoToLeft;
	private Animation bugGoToRight;
	private Animation bugRotateLeft;
	private Animation bugRotateRight;
	private Animation layoutFadeAnimation;
	private boolean animationStarted;

	protected void onCreate() {

		// --- Load screen layout (see the layout xml in the res folder) --- //
		setContent(Res.layout.ANIMATION_LAYOUT);

		// --- Configure UI elements from the screen layout --- //
		
		// Layout at the top with the text that says to press to begin animations
		VerticalLayout fadeLayout = (VerticalLayout) getContent().findView(Res.id.layout_start);
		fadeLayout.setClickListener(this);
		
		// Top door image
		ImageLabel doorTop = (ImageLabel) getContent().findView(Res.id.door_top_image);
		doorTop.setHeight(Display.getHeightDP() / 2);
		
		// Bottom door image
		ImageLabel doorBottom = (ImageLabel) getContent().findView(Res.id.door_bottom_image);
		doorBottom.setHeight(Display.getHeightDP() / 2);
		
		// Top fabric image
		ImageLabel fabricTop = (ImageLabel) getContent().findView(Res.id.fabric_top_image);
		fabricTop.setHeight(Display.getHeightDP() / 2);
		
		// Bottom fabric image
		ImageLabel fabricBottom = (ImageLabel) getContent().findView(Res.id.fabric_bottom_image);
		fabricBottom.setHeight(Display.getHeightDP() / 2);
		
		// Bug image
		ImageLabel bug = (ImageLabel) getContent().findView(Res.id.bug_image);

		// --- Configure all the animations --- //
		
		// Fade effect on the top layout (make it transparent)
		layoutFadeAnimation = Animation.animate(fadeLayout)
				.alpha(0)
				.setDuration(FADE_DURATION_MS)
				.setListener(this);

		// Door opening animations: simple vertical translations. One will go out
		// by the top of screen, the other by the bottom.
		doorTopAnimation = Animation.animate(doorTop)
				.translationY(-Display.getHeightDP() / 2)
				.setDuration(OPEN_TRANSLATION_DURATION_MS)
				.setListener(this);
		doorBottomAnimation = Animation.animate(doorBottom)
				.translationY(Display.getHeightDP() / 2)
				.setDuration(OPEN_TRANSLATION_DURATION_MS)
				.setListener(this);

		// Fabric opening animations: same as door animations.
		fabricTopAnimation = Animation.animate(fabricTop)
				.translationY(-Display.getHeightDP() / 2)
				.setDuration(OPEN_TRANSLATION_DURATION_MS);
		fabricBottomAnimation = Animation.animate(fabricBottom)
				.translationY(Display.getHeightDP() / 2)
				.setDuration(OPEN_TRANSLATION_DURATION_MS)
				.setListener(this);
		
		// Bug animation: first part -> translate to the left of the screen
		bugGoToLeft = Animation.animate(bug)
				.translationX(-Display.getWidthDP() + bug.getImage().getWidthDP())
				.setDuration(BUG_TRANSLATION_DURATION_MS)
				.setListener(this);
		// Bug animation: second part -> rotate 180 degrees
		bugRotateRight = Animation.animate(bug)
				.rotation(BUG_ROTATION_ANGLE)
				.setDuration(BUG_ROTATION_DURATION_MS)
				.setListener(this);
		// Bug animation: third part -> translate to the right of the screen
		bugGoToRight = Animation.animate(bug)
				.translationX(0)
				.setDuration(BUG_TRANSLATION_DURATION_MS)
				.setListener(this);
		// Bug animation: last part -> rotate to 0 degree
		bugRotateLeft = Animation.animate(bug)
				.rotation(0)
				.setDuration(BUG_ROTATION_DURATION_MS)
				.setListener(this);
	}

	/*
	 * We will link the animation together thanks to the AnimationListener.
	 * 
	 * @see
	 * com.neomades.ui.animation.AnimationListener#onAnimationEnd(com.neomades
	 * .ui.animation.Animation)
	 */
	public void onAnimationEnd(Animation animation) {
		if (animation.equals(layoutFadeAnimation)) {
			// Top layout disappears, start translation of doors 
			doorTopAnimation.start();
			doorBottomAnimation.start();
		} else if (animation.equals(doorTopAnimation)) {
			// Top door is opened, open top fabric element
			fabricTopAnimation.start();
		} else if (animation.equals(doorBottomAnimation)) {
			// Bottom door is opened, open bottom fabric element
			fabricBottomAnimation.start();
		} else if (animation.equals(fabricBottomAnimation) || animation.equals(bugRotateLeft)) {
			// Fabric is opened, start the bug animation (first translate left).
			// If we are at the last animation (left rotation of the bug),
			// restart all.
			bugGoToLeft.start();
		} else if (animation.equals(bugGoToLeft)) {
			// End left translation, rotate right
			bugRotateRight.start();
		} else if (animation.equals(bugRotateRight)) {
			// End right rotation, translate right
			bugGoToRight.start();
		} else if (animation.equals(bugGoToRight)) {
			// End right translation, rotate left
			bugRotateLeft.start();
		}
	}

	public void onAnimationRepeat(Animation animation) {
	}

	public void onAnimationStart(Animation animation) {
	}

	public void onAnimationCancel(Animation animation) {
	}

	/*
	 * When the top layout is touch, start animation chain.
	 * 
	 * @see com.neomades.ui.listeners.ClickListener#onClick(com.neomades.ui.View)
	 */
	public void onClick(View view) {
		if (!animationStarted) {
			animationStarted = true;
			//Launch the first animations (fade effect)		
			layoutFadeAnimation.start();
		}		
	}

}
