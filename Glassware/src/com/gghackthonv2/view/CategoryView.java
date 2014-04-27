package com.gghackthonv2.view;

import com.gghackthonv2.helper.CategoryList.Category;
import com.gghackthonv2.toronto_311_glassware.R;
import com.gghackthonv2.view.MainActionView.MainActionType;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategoryView extends LinearLayout {

	private TextView mTitleTV;
	private TextView mSubtitleTV;
	private ImageView mMainActionIconIV;
	
	public CategoryView (Context context, Category category, MainActionType mainActionType, String mainActionIcon) {
		this(context, null, 0);
		
		mTitleTV.setText(getResources().getString(category.getNameId()));
		mTitleTV.setCompoundDrawablesWithIntrinsicBounds(category.getIconId(), 0, 0, 0);
		
		int iconID = getResources().getIdentifier(mainActionIcon , "drawable", context.getPackageName());
		mMainActionIconIV.setImageResource(iconID);
		
		
		mSubtitleTV.setText("this is the subtitle");
	}
	
	public CategoryView(Context context) {
		this(context, null, 0);
		// TODO Auto-generated constructor stub
	}
	
	public CategoryView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}
	
	public CategoryView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		LayoutInflater.from(context).inflate(R.layout.customview_category, this);

		mTitleTV = (TextView) findViewById(R.id.categoryView_title);
		mSubtitleTV = (TextView) findViewById(R.id.categoryView_subtitle);
		mMainActionIconIV = (ImageView) findViewById(R.id.categoryView_mainActionIcon);
	}	
}
