package com.gghackthonv2.view;

import com.gghackthonv2.toronto_311_glassware.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActionView extends LinearLayout {
	
	public enum MainActionType {
		SIDEWALK, 
		ROAD,
		CITY_PROPERTY,
		NOISE,
		CONTACT,
		MY_ISSUES;
	}

	private TextView mTitleTV;
	private TextView mSubtitleTV;
	
	public MainActionView (Context context, MainActionType actionType) {
		this(context, null, 0);
		
		switch (actionType) {
		case SIDEWALK:
			mTitleTV.setText(R.string.mainActionViewTitle_sidewalk);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_sidewalk);
			break;
		case ROAD:
			mTitleTV.setText(R.string.mainActionViewTitle_road);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_road);
			break;
		case CITY_PROPERTY:
			mTitleTV.setText(R.string.mainActionViewTitle_cityProperty);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_cityProperty);
			break;
		case NOISE:
			mTitleTV.setText(R.string.mainActionViewTitle_noise);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_noise);
			break;
		case CONTACT:
			mTitleTV.setText(R.string.mainActionViewTitle_contact);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_contact);
			break;
		case MY_ISSUES:
			mTitleTV.setText(R.string.mainActionViewTitle_myIssue);
			mSubtitleTV.setText(R.string.mainActionViewSubtitle_myIssue);
			break;
		default:
			break;
		}
	}
	
	public MainActionView(Context context) {
		this(context, null, 0);
		// TODO Auto-generated constructor stub
	}
	
	public MainActionView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}
	
	public MainActionView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		LayoutInflater.from(context).inflate(R.layout.customview_mainaction, this);

		mTitleTV = (TextView) findViewById(R.id.mainActionView_title);
		mSubtitleTV = (TextView) findViewById(R.id.mainActionView_subtitle);
	}	
}
