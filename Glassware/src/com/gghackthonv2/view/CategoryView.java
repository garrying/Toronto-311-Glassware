package com.gghackthonv2.view;

import com.gghackthonv2.toronto_311_glassware.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategoryView extends LinearLayout {
	
	public enum MainActionType {
		MAINTENANCE, 
		BROKEN,
		CLEANING,
		GRAFFITI,
		LITTER,
		MISSING,
		TIMING;
	}

	private TextView mTitleTV;
	private TextView mSubtitleTV;
	private ImageView mImage;
	
	public CategoryView (Context context, MainActionType actionType) {
		this(context, null, 0);
		
		switch (actionType) {
		case MAINTENANCE:
			mImage.setImageResource(R.drawable.sidewalks_1);
			mTitleTV.setText(R.string.mainActionViewTitle_sidewalk);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_sidewalk);
			break;
		case BROKEN:
			mImage.setImageResource(R.drawable.road_1);
			mTitleTV.setText(R.string.mainActionViewTitle_road);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_road);
			break;
		case CLEANING:
			mImage.setImageResource(R.drawable.property_1);
			mTitleTV.setText(R.string.mainActionViewTitle_cityProperty);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_cityProperty);
			break;
		case GRAFFITI:
			mImage.setImageResource(R.drawable.noise_1);
			mTitleTV.setText(R.string.mainActionViewTitle_noise);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_noise);
			break;
		case LITTER:
			mImage.setImageResource(R.drawable.contact_1);
			mTitleTV.setText(R.string.mainActionViewTitle_contact);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_contact);
			break;
		case MISSING:
			mTitleTV.setText(R.string.mainActionViewTitle_myIssue);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_myIssue);
			break;
		case TIMING:
			
		default:
			break;
		}
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
		
		LayoutInflater.from(context).inflate(R.layout.customview_mainaction, this);

		mImage = (ImageView) findViewById(R.id.mainActionView_image);
		mTitleTV = (TextView) findViewById(R.id.mainActionView_title);
		mSubtitleTV = (TextView) findViewById(R.id.mainActionView_subtitle);
	}	
}
