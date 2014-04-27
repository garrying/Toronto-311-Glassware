package com.gghackthonv2.helper;

import java.util.ArrayList;

import com.gghackthonv2.helper.CategoryList.Category;
import com.gghackthonv2.toronto_311_glassware.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryListAdapter extends ArrayAdapter<Category> {

	private final Context mContext;
	private final int resourcesLayoutId;
	private final ArrayList<Category> mCategories;

	static class ViewHolder {
		public TextView rowTitleTV;
		public ImageView rowIconIV;
	}

	public CategoryListAdapter(Context context, int resourcesLayoutId, ArrayList<Category> categories) {
		super(context, resourcesLayoutId, categories);

		this.mContext = context;
		this.resourcesLayoutId = resourcesLayoutId;
		this.mCategories = categories;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		// reuse views
		if (rowView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(this.resourcesLayoutId, null);
			// configure view holder
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.rowTitleTV = (TextView) rowView.findViewById(R.id.categoryRowView_title);
			viewHolder.rowIconIV = (ImageView) rowView.findViewById(R.id.categoryRowView_image);
			rowView.setTag(viewHolder);
		}

		Category category = this.mCategories.get(position);
		// fill data
		ViewHolder holder = (ViewHolder) rowView.getTag();
		holder.rowTitleTV.setText(category.getNameId());
		holder.rowIconIV.setImageResource(category.getIconId());

		return rowView;
	}

}
