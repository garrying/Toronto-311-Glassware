package com.gghackthonv2.activity;

import com.gghackthonv2.toronto_311_glassware.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VerificationActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		// Get intent extras for the img and description
		// intent.getParcelableExtra(MainActivity.EXTRA_SELECT_ACTION_TYPE);

		setContentView(R.layout.activity_verification);
		
		TextView serviceType = (TextView) findViewById(R.id.VerificationView_descriptionOne);
		serviceType.setText("Service Type: "); //add in value
	}
	

}
