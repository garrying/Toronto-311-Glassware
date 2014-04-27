package com.gghackthonv2.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
	
	public void ActionCategoryTyep() {
		actionCategoryTypeDictionary = new HashMap<String, HashMap<String, List<String>>>();
		actionCategoryTypeDictionary.put(SIDEWALK, createSidewalkDictionary());
		actionCategoryTypeDictionary.put(ROAD, createRoadDictionary());
		actionCategoryTypeDictionary.put(CITY_PROPERTY, createCityPropertyDictionary());
	}
	
	// uncomplete
	public HashMap<String, List<String>> createSidewalkDictionary(){
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		List<String> sidewalkGraffiti = Arrays.asList("option a", "option b");
		List<String> sidewalkLittle = Arrays.asList("Report loose litter on a sidewalk or boulevard to be picked up by the City.");
		List<String> sidewalkDamage = Arrays.asList("Report minor sidewalk damage. If this represents a significant safety risk, please call 311.");
		
		map.put(GRAFFITI, sidewalkGraffiti);
		map.put(LITTER, sidewalkLittle);
		map.put(DAMAGE, sidewalkDamage);
		
		return map;
	}
	
	// uncomplete
	public HashMap<String, List<String>> createRoadDictionary(){
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		List<String> sidewalkGraffiti = Arrays.asList("option a", "option b");
		List<String> sidewalkLittle = Arrays.asList("Report loose litter on a sidewalk or boulevard to be picked up by the City.");
		List<String> sidewalkDamage = Arrays.asList("Report minor sidewalk damage. If this represents a significant safety risk, please call 311.");
		
		map.put(GRAFFITI, sidewalkGraffiti);
		map.put(LITTER, sidewalkLittle);
		map.put(DAMAGE, sidewalkDamage);
		
		return map;
	}

	// This is done but plz check
	public HashMap<String, List<String>> createCityPropertyDictionary(){
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		List<String> citypropertyGraffit = Arrays.asList("Report graffiti on a street litter bin maintained by the City. For litter bins maintained by Astral Media (i.e. bins with foot pedal) or any bin in a City park, please call 311.");
		List<String> citypropertyLittle = Arrays.asList("Overflowing litter bin.");
		List<String> citypropertyDamage = Arrays.asList(
				"Report a damaged fire hydrant for repair by the City.", 
				"Report a leaking fire hydrant for repair by the City.", 
				"Request removal of a dead/dying City tree.");
		
		map.put(GRAFFITI, citypropertyGraffit);
		map.put(LITTER, citypropertyLittle);
		map.put(DAMAGE, citypropertyDamage);
		
		return map;
	}
}
