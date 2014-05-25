package com.gghackthonv2.view;

import com.gghackthonv2.toronto_311_glassware.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActionView extends LinearLayout {
	
	public enum MainActionType {
		SIDEWALK(R.drawable.sidewalks_1, R.string.mainActionViewTitle_sidewalk, R.string.mainActionViewSubtitle_sidewalk), 
		ROAD(R.drawable.road_1, R.string.mainActionViewTitle_road, R.string.mainActionViewSubtitle_road),
		CITY_PROPERTY(R.drawable.property_1, R.string.mainActionViewTitle_cityProperty, R.string.mainActionViewSubtitle_cityProperty),
		NOISE(R.drawable.noise_1, R.string.mainActionViewTitle_noise, R.string.mainActionViewSubtitle_noise),
		CONTACT(R.drawable.contact_1, R.string.mainActionViewTitle_contact, R.string.mainActionViewSubtitle_contact),
		MY_ISSUES(-1, R.string.mainActionViewTitle_myIssue, R.string.mainActionViewSubtitle_myIssue);
		
		private final int iconId;
		private final int titleId;
		private final int subtitleId;
		
		private MainActionType(int iconId, int titleId, int subtitleId) {
			this.iconId = iconId;
			this.titleId = titleId;
			this.subtitleId = subtitleId;
		}
		
		public int getIconId() {
			return iconId;
		}
		
		public int getTitleId() {
			return titleId;
		}
		
		public int getSubtitleId() {
			return subtitleId;
		}
	}

	private TextView mTitleTV;
	private TextView mSubtitleTV;
	private ImageView mImage;
	
	public MainActionView (Context context, MainActionType actionType) {
		this(context, null, 0);
		
		if (actionType != MainActionType.MY_ISSUES) {
			mImage.setImageResource(actionType.getIconId());
		}
		mTitleTV.setText(actionType.getTitleId());
		mSubtitleTV.setText(actionType.getSubtitleId());
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

		mImage = (ImageView) findViewById(R.id.mainActionView_image);
		mTitleTV = (TextView) findViewById(R.id.mainActionView_title);
		mSubtitleTV = (TextView) findViewById(R.id.mainActionView_subtitle);
	}	
}
