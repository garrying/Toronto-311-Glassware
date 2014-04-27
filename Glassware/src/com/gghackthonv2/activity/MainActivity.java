package com.gghackthonv2.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gghackthonv2.toronto_311_glassware.R;
import com.gghackthonv2.view.MainActionView;
import com.gghackthonv2.view.MainActionView.MainActionType;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

public class MainActivity extends Activity {

	public static final String EXTRA_SELECT_ACTION_TYPE = "extra_select_action_type";
	public static final String EXTRA_SELECT_ACTION_NAME = "extra_select_action_name";

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
			intent = new Intent(this, ServiceRequestCategoryActivity.class);
			intent.putExtra(EXTRA_SELECT_ACTION_TYPE, type);
			intent.putExtra(EXTRA_SELECT_ACTION_NAME, getString(R.string.mainActionViewTitle_sidewalk));
			startActivity(intent);
			break;
		case ROAD:
			intent = new Intent(this, ServiceRequestCategoryActivity.class);
			intent.putExtra(EXTRA_SELECT_ACTION_TYPE, type);
			intent.putExtra(EXTRA_SELECT_ACTION_NAME, getString(R.string.mainActionViewTitle_road));
			startActivity(intent);
			break;
		case CITY_PROPERTY:
			intent = new Intent(this, ServiceRequestCategoryActivity.class);
			intent.putExtra(EXTRA_SELECT_ACTION_TYPE, type);
			intent.putExtra(EXTRA_SELECT_ACTION_NAME, getString(R.string.mainActionViewTitle_cityProperty));
			startActivity(intent);
			break;
		case NOISE:

			break;
		case CONTACT:

			break;
		case MY_ISSUES:

			break;
		default:
			// Something is wrong
			return;
		}
	}
}
