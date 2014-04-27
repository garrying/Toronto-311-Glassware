package com.gghackthonv2.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.util.Log;

import com.gghackthonv2.helper.CategoryList.Category;
import com.gghackthonv2.view.MainActionView.MainActionType;

public class ActionCategoryType {

	private final String SIDEWALK = "sidewalk";
	private final String ROAD = "road";
	private final String CITY_PROPERTY = "city_property";

	private final String GRAFFITI = "graffiti";
	private final String LITTER = "litter";
	private final String DAMAGE = "damage";
	private final String MISSING = "missing";
	private final String TIMING = "timing";
	private final String CLEANING = "cleaning";
	private final String MAINTANENCE = "maintanence";

	public HashMap<String, HashMap<String, List<String>>> actionCategoryTypeDictionary;

	public ActionCategoryType() {
		actionCategoryTypeDictionary = new HashMap<String, HashMap<String, List<String>>>();
		actionCategoryTypeDictionary.put(SIDEWALK, createSidewalkDictionary());
		actionCategoryTypeDictionary.put(ROAD, createRoadDictionary());
		actionCategoryTypeDictionary.put(CITY_PROPERTY, createCityPropertyDictionary());
	}

	public List<String> getTypeList(MainActionType action, Category category) {
		List<String> typeList = null;

		if (action == MainActionType.SIDEWALK) {
			
			HashMap<String, List<String>> CategoryList = actionCategoryTypeDictionary.get(SIDEWALK);
			
			if (category == Category.GRAFFITI) {
				typeList = CategoryList.get(GRAFFITI);
			} else if (category == Category.LITTER) {
				typeList = CategoryList.get(LITTER);
			} else if (category == Category.DAMAGE) {
				typeList = CategoryList.get(DAMAGE);
			} else if (category == Category.TIMING) {
				typeList = CategoryList.get(TIMING);
			} else if (category == Category.MAINTANENCE) {
				typeList = CategoryList.get(MAINTANENCE);
			}

		} else if (action == MainActionType.ROAD) {
			
			HashMap<String, List<String>> CategoryList = actionCategoryTypeDictionary.get(ROAD);
			
			if (category == Category.GRAFFITI) {
				typeList = CategoryList.get(GRAFFITI);
			} else if (category == Category.LITTER) {
				typeList = CategoryList.get(LITTER);
			} else if (category == Category.DAMAGE) {
				typeList = CategoryList.get(DAMAGE);
			} else if (category == Category.MISSING) {
				typeList = CategoryList.get(MISSING);
			} else if (category == Category.CLEANING) {
				typeList = CategoryList.get(CLEANING);
			}
			
		} else if (action == MainActionType.CITY_PROPERTY) {
			
			HashMap<String, List<String>> CategoryList = actionCategoryTypeDictionary.get(CITY_PROPERTY);
			
			if (category == Category.GRAFFITI) {
				typeList = CategoryList.get(GRAFFITI);
			} else if (category == Category.LITTER) {
				typeList = CategoryList.get(LITTER);
			} else if (category == Category.DAMAGE) {
				typeList = CategoryList.get(DAMAGE);
			}
		}

		return typeList;
	}

	private HashMap<String, List<String>> createSidewalkDictionary() {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		List<String> sidewalkGraffiti = Arrays
				.asList("Graffiti on a city road, sidewalk, or bridge.");
		List<String> sidewalkLitter = Arrays
				.asList("Report loose litter on a sidewalk to be picked up.");
		List<String> sidewalkDamage = Arrays
				.asList("Report minor sidewalk damage. Call 311 for significant safety risks.");
		List<String> sidewalkTiming = Arrays
				.asList("Pedestrian signal timing issue at an intersection.");
		List<String> sidewalkMaintanence = Arrays
				.asList("Snow removal at a TTC bus/streetcar stop. 72 hours after a snowfall.",
						"Snow removal on a City walkway. 72 hours after a snowfall.",
						"Snow removal on apedestrian portion of a City bridge. 72 hours after a snowfall.",
						"Clearing of a snow pile that is blocking traffic, sightlines, and buses.",
						"Request snow ploughing on a City sidewalk. 72 hours after a snowfall.");

		map.put(GRAFFITI, sidewalkGraffiti);
		map.put(LITTER, sidewalkLitter);
		map.put(DAMAGE, sidewalkDamage);
		map.put(TIMING, sidewalkTiming);
		map.put(MAINTANENCE, sidewalkMaintanence);

		return map;
	}

	private HashMap<String, List<String>> createRoadDictionary() {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		List<String> roadGraffiti = Arrays.asList("Report graffiti on a City road, sidewalk, or bridge.");
		List<String> roadLitter = Arrays
				.asList("Report loose litter on a sidewalk or boulevard.");
		List<String> roadDamage = Arrays
				.asList("Report minor pothole damage. Call 311 for significant safety risks.",
						"Report minor road damage. Call 311 for significant safety risks.",
						"Report damage to a road, or sidewalk that was caused by a snow plough.");
		List<String> roadMissing = Arrays
				.asList("Report a missing or damaged City street sign.",
						"Report missing or faded road markings such as lane lines, stop lines, and crosswalks.");
		List<String> roadCleaning = Arrays
				.asList("Request clean-up of spilled construction material, dirt, or mud on a City road.",
						"Request clean-up of a catch basin on a City road or boulevard.");

		map.put(GRAFFITI, roadGraffiti);
		map.put(LITTER, roadLitter);
		map.put(DAMAGE, roadDamage);
		map.put(MISSING, roadMissing);
		map.put(CLEANING, roadCleaning);

		return map;
	}

	private HashMap<String, List<String>> createCityPropertyDictionary() {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		List<String> citypropertyGraffiti = Arrays
				.asList("Report graffiti on a street litter bin maintained by the City.");
		List<String> citypropertyLitter = Arrays.asList("Overflowing litter bin.");
		List<String> citypropertyDamage = Arrays.asList("Report a damaged fire hydrant for repair by the City.",
				"Report a leaking fire hydrant for repair by the City.", 
				"Request removal of a dead/dying City tree.");

		map.put(GRAFFITI, citypropertyGraffiti);
		map.put(LITTER, citypropertyLitter);
		map.put(DAMAGE, citypropertyDamage);

		return map;
	}
}
