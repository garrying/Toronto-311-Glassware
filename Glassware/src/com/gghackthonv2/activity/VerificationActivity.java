package com.gghackthonv2.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gghackthonv2.toronto_311_glassware.R;
import com.gghackthonv2.view.MainActionView;
import com.gghackthonv2.view.MainActionView.MainActionType;
import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

public class VerificationActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.customview_verification);		
	}


}
