package com.gghackthonv2.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.gghackthonv2.helper.CategoryList.Category;
import com.gghackthonv2.model.ActionCategoryType;
import com.gghackthonv2.view.TypeView;
import com.gghackthonv2.view.MainActionView.MainActionType;
import com.google.android.glass.media.CameraManager;
import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.FileObserver;
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
	private MainActionType mMainAction;
	private Category mCategory;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		mMainAction = (MainActionType) intent.getSerializableExtra(ServiceRequestCategoryActivity.EXTRA_SELECTED_ACTION);
		mCategory = (Category) intent.getSerializableExtra(ServiceRequestCategoryActivity.EXTRA_SELECTED_CATEGORY);

		ActionCategoryType actionCategoryType = new ActionCategoryType();
		mTypeList = actionCategoryType.getTypeList(mMainAction, mCategory);
		createActionViews(mTypeList);
		
		verificationIntent = new Intent (this, VerificationActivity.class);
		verificationIntent.putExtra(EXTRA_SERVICE_REQUEST_ACTION, mMainAction);
		verificationIntent.putExtra(EXTRA_SERVICE_REQUEST_CATEGORY, mCategory);
		
		CardScrollViewAdapter adapter = new CardScrollViewAdapter();

		CardScrollView cardScrollView = new CardScrollView(this);
		cardScrollView.setHorizontalScrollBarEnabled(true);
		cardScrollView.setAdapter(adapter);
		cardScrollView.activate();
		cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				selectedOption(position);
				((AudioManager) getSystemService(AUDIO_SERVICE)).playSoundEffect(Sounds.TAP);
			}
		});

		// set the view of this activity
		setContentView(cardScrollView);
	}
	private void createActionViews(List<String> types) {
		mTypeViews = new ArrayList<TypeView>();
		for (String type : types) {
			TypeView typeView = new TypeView(this, type, mMainAction.getIconId(), mCategory.getIconId());
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
	        String picturePath = data.getStringExtra(CameraManager.EXTRA_PICTURE_FILE_PATH);
	        
	        processPictureWhenReady(picturePath);	
	    }
	    super.onActivityResult(requestCode, resultCode, data);
	}
	
	private void startVerificationActivity(final String picturePath) {
		verificationIntent.putExtra(EXTRA_SERVICE_REQUEST_PICTURE_URL, picturePath);
		startActivity(verificationIntent);
	}
	
	private void processPictureWhenReady(final String picturePath) {
	    final File pictureFile = new File(picturePath);

	    if (pictureFile.exists()) {
	        // The picture is ready; process it.
	    	Log.i("service request type activity", "pic is ready");
	    	startVerificationActivity(picturePath);
	    } else {
	        // The file does not exist yet. Before starting the file observer, you
	        // can update your UI to let the user know that the application is
	        // waiting for the picture (for example, by displaying the thumbnail
	        // image and a progress indicator).
	    	Log.i("service request type activity", "pic is not ready");

	        final File parentDirectory = pictureFile.getParentFile();
	        FileObserver observer = new FileObserver(parentDirectory.getPath(),
	                FileObserver.CLOSE_WRITE | FileObserver.MOVED_TO) {
	            // Protect against additional pending events after CLOSE_WRITE
	            // or MOVED_TO is handled.
	            private boolean isFileWritten;

	            @Override
	            public void onEvent(int event, String path) {
	                if (!isFileWritten) {
	                    // For safety, make sure that the file that was created in
	                    // the directory is actually the one that we're expecting.
	                    File affectedFile = new File(parentDirectory, path);
	                    isFileWritten = affectedFile.equals(pictureFile);

	                    if (isFileWritten) {
	                        stopWatching();

	                        // Now that the file is ready, recursively call
	                        // processPictureWhenReady again (on the UI thread).
	                        runOnUiThread(new Runnable() {
	                            @Override
	                            public void run() {
	                                processPictureWhenReady(picturePath);
	                            }
	                        });
	                    }
	                }
	            }
	        };
	        observer.startWatching();
	    }
	}
}
