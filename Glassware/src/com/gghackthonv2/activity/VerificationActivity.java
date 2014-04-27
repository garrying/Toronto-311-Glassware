package com.gghackthonv2.activity;

import com.gghackthonv2.helper.CategoryList.Category;
import com.gghackthonv2.toronto_311_glassware.R;
import com.gghackthonv2.view.MainActionView.MainActionType;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VerificationActivity extends Activity {

	private ImageView mReportImageIV;
	private String mMainActionIcon;
	private String mReportCategoryIcon;
	private TextView mReportTitleView;
	private TextView mReportLocationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		MainActionType action = (MainActionType) intent.getSerializableExtra(ServiceRequestTypeActivity.EXTRA_SERVICE_REQUEST_ACTION);
		Category category = (Category) intent.getSerializableExtra(ServiceRequestTypeActivity.EXTRA_SERVICE_REQUEST_CATEGORY);
		String type = intent.getStringExtra(ServiceRequestTypeActivity.EXTRA_SERVICE_REQUEST_TYPE);
		String pictureUrl = intent.getStringExtra(ServiceRequestTypeActivity.EXTRA_SERVICE_REQUEST_PICTURE_URL);
		//ICONS
		mMainActionIcon = (String) intent.getSerializableExtra(ServiceRequestTypeActivity.EXTRA_MAIN_ACTION_ICON);
		mReportCategoryIcon = (String) intent.getSerializableExtra(ServiceRequestTypeActivity.EXTRA_CATEGORY_ICON);
		
		int actionIconID = getResources().getIdentifier(mMainActionIcon , "drawable", getPackageName());
		ImageView actionIconIV = (ImageView) findViewById(R.id.verificationView_actionIcon);
		actionIconIV.setImageResource(actionIconID);
		
		int categoryIconID = getResources().getIdentifier(mReportCategoryIcon , "drawable", getPackageName());
		ImageView categoryIconIV = (ImageView) findViewById(R.id.verificationView_categoryIcon);
		categoryIconIV.setImageResource(categoryIconID);
		
		
		setContentView(R.layout.activity_verification);

		mReportImageIV = (ImageView) findViewById(R.id.verificationView_reportImage);
	
		mReportTitleView = (TextView) findViewById(R.id.verificationView_title);
		mReportLocationView = (TextView) findViewById(R.id.verificationView_location);
		
		
		
		if(pictureUrl.length() > 1){
			mReportImageIV.setImageBitmap(BitmapFactory.decodeFile(pictureUrl));
		}
	}
}
