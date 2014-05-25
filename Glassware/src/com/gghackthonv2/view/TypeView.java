package com.gghackthonv2.view;

import com.gghackthonv2.toronto_311_glassware.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TypeView extends LinearLayout {

	private final TextView mTitleTV;
	private final TextView mDirectoryTV;
	
	public TypeView (Context context, String typeString, int mainActionIcon, int categoryIcon) {
		this(context, null, 0);
		
		mTitleTV.setText(typeString);
		
		Drawable drawable = getResources().getDrawable(mainActionIcon);
		Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
		Drawable newMainActionDrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 50, 50, true));

		drawable = getResources().getDrawable(categoryIcon);
		bitmap = ((BitmapDrawable) drawable).getBitmap();
		Drawable newCategoryDrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 50, 50, true));
		
		mDirectoryTV.setCompoundDrawablesWithIntrinsicBounds(newMainActionDrawable, null, newCategoryDrawable, null);
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
		mDirectoryTV = (TextView) findViewById(R.id.typeView_directory);
	}	
}
