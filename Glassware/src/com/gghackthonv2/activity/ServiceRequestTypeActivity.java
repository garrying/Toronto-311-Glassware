package com.gghackthonv2.activity;

import java.util.ArrayList;
import java.util.List;

import com.gghackthonv2.helper.CategoryList.Category;
import com.gghackthonv2.model.ActionCategoryType;
import com.gghackthonv2.view.TypeView;
import com.gghackthonv2.view.MainActionView.MainActionType;
import com.google.android.glass.media.CameraManager;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

public class ServiceRequestTypeActivity extends Activity {

	
	public static final String EXTRA_SERVICE_REQUEST_ACTION = "extra_service_request_action";
	public static final String EXTRA_SERVICE_REQUEST_CATEGORY = "extra_service_request_category";
	public static final String EXTRA_SERVICE_REQUEST_TYPE = "extra_service_request_type";
	public static final String EXTRA_SERVICE_REQUEST_PICTURE_URL = "extra_service_request_picture_url";
	public static final String EXTRA_CATEGORY_ICON = "extra_category_icon";
	public static final String EXTRA_MAIN_ACTION_ICON = "extra_main_action_icon";
	
	private static final int TAKE_PICTURE_REQUEST = 1;
	
	private class CardScrollViewAdapter extends CardScrollAdapter {

		@Override
		public int getCount() {
			return mTypeViews.size();
		}

		@Override
		public Object getItem(int position) {
			return mTypeViews.get(position);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return mTypeViews.get(position);
		}

		@Override
		public int getPosition(Object item) {
			return mTypeViews.indexOf(item);
		}
	}
	
	private Intent verificationIntent;

	private List<String> mTypeList;
	private List<TypeView> mTypeViews;
	private String mMainActionIcon;
	private String mCategoryIcon;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		MainActionType action = (MainActionType) intent.getSerializableExtra(ServiceRequestCategoryActivity.EXTRA_SELECTED_ACTION);
		Category category = (Category) intent.getSerializableExtra(ServiceRequestCategoryActivity.EXTRA_SELECTED_CATEGORY);
		mMainActionIcon = (String) intent.getSerializableExtra(ServiceRequestCategoryActivity.EXTRA_MAIN_ACTION_ICON);
		mCategoryIcon = (String) intent.getSerializableExtra(ServiceRequestCategoryActivity.EXTRA_CATEGORY_ICON);
		
		ActionCategoryType actionCategoryType = new ActionCategoryType();
		mTypeList = actionCategoryType.getTypeList(action, category);
		createActionViews(mTypeList);
		
		verificationIntent = new Intent (this, VerificationActivity.class);
		verificationIntent.putExtra(EXTRA_SERVICE_REQUEST_ACTION, action);
		verificationIntent.putExtra(EXTRA_SERVICE_REQUEST_CATEGORY, category);
		verificationIntent.putExtra(EXTRA_MAIN_ACTION_ICON, mMainActionIcon);
		verificationIntent.putExtra(EXTRA_CATEGORY_ICON, mCategoryIcon);
		
		CardScrollViewAdapter adapter = new CardScrollViewAdapter();

		CardScrollView cardScrollView = new CardScrollView(this);
		cardScrollView.setHorizontalScrollBarEnabled(true);
		cardScrollView.setAdapter(adapter);
		cardScrollView.activate();
		cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				selectedOption(position);
			}
		});

		// set the view of this activity
		setContentView(cardScrollView);
	}
	private void createActionViews(List<String> types) {
		mTypeViews = new ArrayList<TypeView>();
		for (String type : types) {
			TypeView typeView = new TypeView(this, type, mMainActionIcon, mCategoryIcon);
			mTypeViews.add(typeView);
		}
	}
	
	private void selectedOption(int position) {
		verificationIntent.putExtra(EXTRA_SERVICE_REQUEST_TYPE, mTypeList.get(position));
		takePicture();
	}
	
	private void takePicture() {
	    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    startActivityForResult(intent, TAKE_PICTURE_REQUEST);
	}
	
	private void takeVideo() {
	    Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
	    startActivityForResult(intent, TAKE_PICTURE_REQUEST);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == TAKE_PICTURE_REQUEST && resultCode == RESULT_OK) {
	        String picturePath = data.getStringExtra(
	                CameraManager.EXTRA_PICTURE_FILE_PATH);
	        Log.i("ServiceRequestTypeActivity", "Picture path : " + picturePath);
	        
	        verificationIntent.putExtra(EXTRA_SERVICE_REQUEST_PICTURE_URL, picturePath);
	        
	        startActivity(verificationIntent);
	    }

	    super.onActivityResult(requestCode, resultCode, data);
	}
}
