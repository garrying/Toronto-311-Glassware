package com.gghackthonv2.activity;

import java.util.ArrayList;

import com.gghackthonv2.helper.CategoryList;
import com.gghackthonv2.helper.CategoryList.Category;
import com.gghackthonv2.helper.CategoryListAdapter;
import com.gghackthonv2.toronto_311_glassware.R;
import com.gghackthonv2.view.MainActionView.MainActionType;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ServiceRequestCategoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		//MainActionType type = intent.getParcelableExtra(MainActivity.EXTRA_SELECT_ACTION_TYPE);
		
		MainActionType type = MainActionType.SIDEWALK;
		String name = intent.getStringExtra(MainActivity.EXTRA_SELECT_ACTION_NAME);
		
		ArrayList<Category> categories = CategoryList.getCategories(type);
		
		CategoryListAdapter categoryListAdapter = new CategoryListAdapter(this, R.layout.rowview_category, categories);
	
		setContentView(R.layout.activity_servicerequestcategory);

		TextView routeTitleTV = (TextView) findViewById(R.id.serviceRequestActivity_actionTitle);
		routeTitleTV.setText(name);

		ListView routeListView = (ListView) findViewById(R.id.serviceRequestActivity_categoryList);
		routeListView.setAdapter(categoryListAdapter);
	}
	
}
