package com.gghackthonv2.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.gghackthonv2.view.MainActionView;
import com.gghackthonv2.view.MainActionView.MainActionType;
import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

public class MainActivity extends Activity {

	public static final String EXTRA_SELECTED_ACTION_TYPE = "extra_select_action_type";

	// Predefine MainAction Object
	private final List<MainActionType> mainActions = Arrays.asList(MainActionType.SIDEWALK, MainActionType.ROAD,
			MainActionType.CITY_PROPERTY, MainActionType.NOISE, MainActionType.CONTACT, MainActionType.MY_ISSUES);

	private class CardScrollViewAdapter extends CardScrollAdapter {

		@Override
		public int getCount() {
			return mActionViews.size();
		}

		@Override
		public Object getItem(int position) {
			return mActionViews.get(position);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return mActionViews.get(position);
		}

		@Override
		public int getPosition(Object item) {
			return mActionViews.indexOf(item);
		}
	}

	private List<MainActionView> mActionViews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		createActionViews();

		CardScrollViewAdapter adapter = new CardScrollViewAdapter();

		CardScrollView cardScrollView = new CardScrollView(this);
		cardScrollView.setHorizontalScrollBarEnabled(true);
		cardScrollView.setAdapter(adapter);
		cardScrollView.activate();
		cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				MainActionType type = mainActions.get(position);
				selectedOption(type);
				((AudioManager) getSystemService(AUDIO_SERVICE)).playSoundEffect(Sounds.TAP);
			}
		});

		// set the view of this activity
		setContentView(cardScrollView);
	}

	private void createActionViews() {
		mActionViews = new ArrayList<MainActionView>();
		for (MainActionType mainAction : mainActions) {
			MainActionView mainActionView = new MainActionView(this, mainAction);
			mActionViews.add(mainActionView);
		}
	}

	private void selectedOption(MainActionType type) {
		Intent intent;

		switch (type) {
		case SIDEWALK:
		case ROAD:
		case CITY_PROPERTY:
			intent = new Intent(this, ServiceRequestCategoryActivity.class);
			intent.putExtra(EXTRA_SELECTED_ACTION_TYPE, type);
			startActivity(intent);
			break;
		case NOISE:

			break;
		case CONTACT:
			intent = new Intent(this, ContactActivity.class);
			startActivity(intent);
			break;
		case MY_ISSUES:

			break;
		default:
			// Something is wrong
			return;
		}
	}
}
