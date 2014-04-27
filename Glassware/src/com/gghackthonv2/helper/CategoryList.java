package com.gghackthonv2.helper;

import java.util.ArrayList;

import com.gghackthonv2.toronto_311_glassware.R;
import com.gghackthonv2.view.MainActionView.MainActionType;

public class CategoryList {

	public enum Category {
		CLEANING(R.drawable.ic_launcher, R.string.categoryCleaning), DAMAGE(R.drawable.ic_launcher,
				R.string.categoryDamage), GRAFFITI(R.drawable.ic_launcher, R.string.categoryGraffiti), LITTER(
				R.drawable.ic_launcher, R.string.categoryLitter), MAINTANENCE(R.drawable.ic_launcher,
				R.string.categoryMaintanence), MISSING(R.drawable.ic_launcher, R.string.categoryMissing), TIMING(
				R.drawable.ic_launcher, R.string.categoryTiming);

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
