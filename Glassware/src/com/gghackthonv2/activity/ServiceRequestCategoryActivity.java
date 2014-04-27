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

	public static final String EXTRA_SELECTED_ACTION = "extra_selected_action";
	public static final String EXTRA_SELECTED_CATEGORY = "extra_selected_category";
	
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
	private MainActionType mMainActionType;
	private String mMainActionIcon;
	private List<CategoryView> mCategoryViews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		
		mMainActionType = (MainActionType) intent.getSerializableExtra(MainActivity.EXTRA_SELECT_ACTION_TYPE);
		mMainActionIcon = (String) intent.getSerializableExtra(MainActivity.EXTRA_MAIN_ACTION_ICON);
		
		//String name = intent.getStringExtra(MainActivity.EXTRA_SELECT_ACTION_NAME);

		mCategories = CategoryList.getCategories(mMainActionType);
		createActionViews(mCategories);

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

	private void createActionViews(ArrayList<Category> categories) {
		mCategoryViews = new ArrayList<CategoryView>();
		for (Category category : categories) {
			CategoryView categoryView = new CategoryView(this, category, mMainActionType, mMainActionIcon);
			mCategoryViews.add(categoryView);
		}
	}

	private void selectedOption(int position) {
		Intent intent = new Intent(this, ServiceRequestTypeActivity.class);
		intent.putExtra(EXTRA_SELECTED_ACTION, mMainActionType);
		
		Category category = mCategories.get(position);
		intent.putExtra(EXTRA_SELECTED_CATEGORY, category);
		
		startActivity(intent);
	}
}
