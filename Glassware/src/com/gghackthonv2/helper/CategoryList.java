package com.gghackthonv2.helper;

import java.util.ArrayList;

import com.gghackthonv2.toronto_311_glassware.R;
import com.gghackthonv2.view.MainActionView.MainActionType;

public class CategoryList {

	public enum Category {
		CLEANING(R.drawable.cleaning_2, R.string.categoryCleaning), 
		DAMAGE(R.drawable.broken_2, R.string.categoryDamage), 
		GRAFFITI(R.drawable.graffiti_2, R.string.categoryGraffiti), 
		LITTER(R.drawable.litter_2, R.string.categoryLitter), 
		MAINTANENCE(R.drawable.maintenance_2, R.string.categoryMaintanence), 
		MISSING(R.drawable.missing_2, R.string.categoryMissing), 
		TIMING(R.drawable.timing_2, R.string.categoryTiming);

		private final int iconId;
		private final int nameId;
 
		private Category(int iconId, int nameId) {
			this.iconId = iconId;
			this.nameId = nameId;
		}

		public int getIconId() {
			return iconId;
		}

		public int getNameId() {
			return nameId;
		}
	}

	public static ArrayList<Category> getCategories(MainActionType type) {
		ArrayList<Category> arrayList = new ArrayList<Category>();
		arrayList.add(Category.GRAFFITI);
		arrayList.add(Category.DAMAGE);
		arrayList.add(Category.LITTER);

		switch (type) {
		case SIDEWALK:
			arrayList.add(Category.TIMING);
			arrayList.add(Category.MAINTANENCE);
			break;
		case ROAD:
			arrayList.add(Category.MISSING);
			arrayList.add(Category.CLEANING);
			break;
		case CITY_PROPERTY:
			break;
		default:
			break;
		}
		return arrayList;
	}
}
