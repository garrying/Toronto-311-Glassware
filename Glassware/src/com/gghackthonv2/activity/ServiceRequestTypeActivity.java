package com.gghackthonv2.activity;

import java.util.ArrayList;
import java.util.List;

import com.gghackthonv2.helper.CategoryList.Category;
import com.gghackthonv2.model.ActionCategoryType;
import com.gghackthonv2.view.TypeView;
import com.gghackthonv2.view.MainActionView.MainActionType;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

public class ServiceRequestTypeActivity extends Activity {

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
		List<String> typeList = actionCategoryType.getTypeList(action, category);
		createActionViews(typeList);

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

	}
}
