package com.gghackthonv2.activity;

import com.gghackthonv2.activity.ServiceRequestCategoryActivity.CardScrollViewAdapter;
import com.gghackthonv2.helper.CategoryList;
import com.gghackthonv2.helper.CategoryList.Category;
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

	
	
	
//	private class CardScrollViewAdapter extends CardScrollAdapter {
//
//		@Override
//		public int getCount() {
//			return mCategoryViews.size();
//		}
//
//		@Override
//		public Object getItem(int position) {
//			return mCategoryViews.get(position);
//		}
//
//		@Override
//		public View getView(int position, View convertView, ViewGroup parent) {
//			return mCategoryViews.get(position);
//		}
//
//		@Override
//		public int getPosition(Object item) {
//			return mCategoryViews.indexOf(item);
//		}
//	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		Intent intent = getIntent();
//		MainActionType type = (MainActionType) intent.getSerializableExtra(MainActivity.EXTRA_SELECT_ACTION_TYPE);
//		
		//String name = intent.getStringExtra(MainActivity.EXTRA_SELECT_ACTION_NAME);

//		mCategories = CategoryList.getCategories(type);
//		createActionViews(mCategories);
//
//		CardScrollViewAdapter adapter = new CardScrollViewAdapter();
//
//		CardScrollView cardScrollView = new CardScrollView(this);
//		cardScrollView.setHorizontalScrollBarEnabled(true);
//		cardScrollView.setAdapter(adapter);
//		cardScrollView.activate();
//		cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Category category = mCategories.get(position);
//				selectedOption(category);
//			}
//		});

//		// set the view of this activity
//		setContentView(cardScrollView);
	}
	
}
