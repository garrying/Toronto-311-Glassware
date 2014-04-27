package com.gghackthonv2.view;

import com.gghackthonv2.toronto_311_glassware.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TypeView extends LinearLayout {

	private final TextView mTitleTV;
	
	public TypeView (Context context, String typeString) {
		this(context, null, 0);
		
		mTitleTV.setText(typeString);
	}
	
	public TypeView(Context context) {
		this(context, null, 0);
		// TODO Auto-generated constructor stub
	}
	
	public TypeView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}
	
	public TypeView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		LayoutInflater.from(context).inflate(R.layout.customview_type, this);

		mTitleTV = (TextView) findViewById(R.id.typeView_title);
	}	
}
