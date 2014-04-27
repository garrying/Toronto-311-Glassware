package com.gghackthonv2.activity;

import java.util.ArrayList;
import java.util.List;

import com.gghackthonv2.helper.CategoryList;
import com.gghackthonv2.helper.CategoryList.Category;
import com.gghackthonv2.view.CategoryView;
import com.gghackthonv2.view.MainActionView.MainActionType;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

public class ServiceRequestCategoryActivity extends Activity {

	private class CardScrollViewAdapter extends CardScrollAdapter {

		@Override
		public int getCount() {
			return mCategoryViews.size();
		}

		@Override
		public Object getItem(int position) {
			return mCategoryViews.get(position);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return mCategoryViews.get(position);
		}

		@Override
		public int getPosition(Object item) {
			return mCategoryViews.indexOf(item);
		}
	}

	private ArrayList<Category> mCategories;
	private MainActionType mainActionType;
	private String mainActionIcon;
	private List<CategoryView> mCategoryViews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		mainActionType = (MainActionType) intent.getSerializableExtra(MainActivity.EXTRA_SELECT_ACTION_TYPE);
		mainActionIcon = (String) intent.getSerializableExtra(MainActivity.EXTRA_MAIN_ACTION_ICON);
		
		//String name = intent.getStringExtra(MainActivity.EXTRA_SELECT_ACTION_NAME);

		mCategories = CategoryList.getCategories(mainActionType);
		createActionViews(mCategories);

		CardScrollViewAdapter adapter = new CardScrollViewAdapter();

		CardScrollView cardScrollView = new CardScrollView(this);
		cardScrollView.setHorizontalScrollBarEnabled(true);
		cardScrollView.setAdapter(adapter);
		cardScrollView.activate();
		cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Category category = mCategories.get(position);
				selectedOption(category);
			}
		});

		// set the view of this activity
		setContentView(cardScrollView);
	}

	private void createActionViews(ArrayList<Category> categories) {
		mCategoryViews = new ArrayList<CategoryView>();
		for (Category category : categories) {
			CategoryView categoryView = new CategoryView(this, category, mainActionType, mainActionIcon);
			mCategoryViews.add(categoryView);
		}
	}

	private void selectedOption(Category category) {
		Intent intent;

		switch (category) {
		case CLEANING:

			break;
		case DAMAGE:

			break;
		case GRAFFITI:

			break;
		case LITTER:

			break;
		case MAINTANENCE:

			break;
		case MISSING:

			break;
		case TIMING:

			break;
		default:
			// Something is wrong
			return;
		}
	}
}
