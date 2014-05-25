package com.gghackthonv2.activity;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.gghackthonv2.helper.CategoryList.Category;
import com.gghackthonv2.toronto_311_glassware.R;
import com.gghackthonv2.view.MainActionView.MainActionType;
import com.google.android.glass.app.Card;
import com.google.android.glass.app.Card.ImageLayout;

public class VerificationActivity extends Activity {

	private static String TAG = "VerificationActivity";
	
	private Card mCard;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		MainActionType action = (MainActionType) intent
				.getSerializableExtra(ServiceRequestTypeActivity.EXTRA_SERVICE_REQUEST_ACTION);
		Category category = (Category) intent
				.getSerializableExtra(ServiceRequestTypeActivity.EXTRA_SERVICE_REQUEST_CATEGORY);
		String type = intent.getStringExtra(ServiceRequestTypeActivity.EXTRA_SERVICE_REQUEST_TYPE);
		String pictureUrl = intent.getStringExtra(ServiceRequestTypeActivity.EXTRA_SERVICE_REQUEST_PICTURE_URL);

		mCard = new Card(this);
		mCard.setImageLayout(ImageLayout.FULL);

		mCard.setText(type);
		setBackgroundDrawable(pictureUrl);
		setCardFooter(this);

		setContentView(mCard.getView());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_verification, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection. Menu items typically start another
		// activity, start a service, or broadcast another intent.
		switch (item.getItemId()) {
		case R.id.verificationMenuItem_send:
			Log.i(TAG, "send is selected");
			return true;
		case R.id.verificationMenuItem_retake:
			Log.i(TAG, "retake is selected");
			return true;
		case R.id.verificationMenuItem_view:
			Log.i(TAG, "view is selected");
			return true;
		case R.id.verificationMenuItem_discard:
			Log.i(TAG, "discard is selected");
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
			openOptionsMenu();
			return true;
		}
		return false;
	}

	private void setBackgroundDrawable(final String pictureUrl) {
		runOnUiThread(new Runnable() {
			public void run() {
				File pictureFile = new File(pictureUrl);
				Drawable drawable = Drawable.createFromPath(pictureFile.getAbsolutePath());
				Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
				Drawable pictureDrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 2048,
						2048, true));
				mCard.addImage(pictureDrawable);
			}
		});
	}

	private void setCardFooter(final Context context) {
		runOnUiThread(new Runnable() {
			public void run() {
				try {
					LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
					Location lastKnownLoaction = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

					Geocoder geocoder = new Geocoder(context, Locale.ENGLISH);
					String addressString = "currently not avaiable";

					// Place your latitude and longitude
					List<Address> addresses = geocoder.getFromLocation(lastKnownLoaction.getLatitude(),
							lastKnownLoaction.getLongitude(), 1);

					if (addresses != null) {
						Address fetchedAddress = addresses.get(0);
						addressString = fetchedAddress.getLocality();
					}

					Date nowDate = new Date(lastKnownLoaction.getTime());
					DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
					mCard.setFootnote("Time: " + dateFormat.format(nowDate) + "       Location: " + addressString);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}
}
