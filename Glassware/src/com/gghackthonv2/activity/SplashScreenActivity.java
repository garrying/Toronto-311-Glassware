package com.gghackthonv2.activity;

import com.gghackthonv2.toronto_311_glassware.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {

	// Splash screen timer
	private static long TIME_OUT = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Handler handler = new Handler();
		setContentView(R.layout.activity_splashscreen);

		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
				startActivity(i);
			}
		}, TIME_OUT);
	}
}