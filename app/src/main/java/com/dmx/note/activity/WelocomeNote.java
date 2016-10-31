package com.dmx.note.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class WelocomeNote extends Activity {

	ImageView imageView;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome_note);
		context = this;

		/*
		 * Handler handler = new Handler();
		 * 
		 * Runnable upRunnable = new Runnable() {
		 * 
		 * @Override public void run() {
		 * 
		 * intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); finish(); } };
		 * handler.postDelayed(upRunnable, 1000);
		 */

		imageView = (ImageView) findViewById(R.id.id_ima);
		Animation animation = new AlphaAnimation(0.1f, 1f);
		animation.setDuration(2000);
		imageView.startAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				Intent intent = new Intent(WelocomeNote.this, MainNote.class);
				startActivity(intent);
				finish();
			}
		});

	}
}
