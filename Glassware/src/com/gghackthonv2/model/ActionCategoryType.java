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
				.asList("Graffiti on a City road, sidewalk, or bridge Report graffiti on a City road, sidewalk, or bridge.");
		List<String> sidewalkLitter = Arrays
				.asList("Report loose litter on a sidewalk or boulevard to be picked up by the City.");
		List<String> sidewalkDamage = Arrays
				.asList("Report minor sidewalk damage. If this represents a significant safety risk, please call 311.");
		List<String> sidewalkTiming = Arrays
				.asList("Report a pedestrian signal timing issue. If this is a another type of traffic signal issue or represents a significant safety risk, please call 311.");
		List<String> sidewalkMaintanence = Arrays
				.asList("Request snow ploughing or sanding/salting at a TTC bus/streetcar stop. Please wait until at least 72 hours after a snowfall/storm.",
						"Request snow ploughing or sanding/salting on a City walkway. Please wait until at least 72 hours after a snowfall/storm.",
						"Request sanding/salting on the pedestrian portion of a City bridge. Please wait until at least 72 hours after a snowfall/storm.",
						"Request clearing of a snow pile that is blocking traffic flow/sightlines, on a boulevard, or in a school bus loading zone.",
						"Request snow ploughing or sanding/salting on a City sidewalk. Please wait until at least 72 hours after a snowfall/storm.");

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
				.asList("Report loose litter on a sidewalk or boulevard to be picked up by the City.");
		List<String> roadDamage = Arrays
				.asList("Report minor pothole damage. If this represents a significant safety risk, please call 311.",
						"Report minor road damage. If this represents a significant safety risk, please call 311.",
						"Report damage to a road, boulevard, or sidewalk that was caused by a City or City-contracted snow plough.");
		List<String> roadMissing = Arrays
				.asList("Report a missing or damaged City street sign. If this is about a 'Stop' sign or represents a significant safety risk, please call 311.",
						"Report missing or faded road markings such as lane lines, stop lines, and crosswalks. If this represents a significant safety risk, please call 311.");
		List<String> roadCleaning = Arrays
				.asList("Request clean-up of spilled construction material, dirt, or mud on a City road (not litter). If this represents a significant safety risk, please call 311.",
						"Request clean-up of a catch basin (surface covered with leaves or other material) on a City road or boulevard. If this represents a significant safety risk, please call 311.");

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
				.asList("Report graffiti on a street litter bin maintained by the City. For litter bins maintained by Astral Media (i.e. bins with foot pedal) or any bin in a City park, please call 311.");
		List<String> citypropertyLitter = Arrays.asList("Overflowing litter bin.");
		List<String> citypropertyDamage = Arrays.asList("Report a damaged fire hydrant for repair by the City.",
				"Report a leaking fire hydrant for repair by the City.", "Request removal of a dead/dying City tree.");

		map.put(GRAFFITI, citypropertyGraffiti);
		map.put(LITTER, citypropertyLitter);
		map.put(DAMAGE, citypropertyDamage);

		return map;
	}
}
