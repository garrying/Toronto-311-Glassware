package com.gghackthonv2.database;

import android.database.sqlite.SQLiteDatabase;

public class ServiceRequestCategoryTable {
	public static final String TABLE_NAME = "service_request_category_table";

	public static final String SERVICE_REQUEST_CATEGORY_ID = "service_request_category_id";
	public static final String SERVICE_REQUEST_CATEGORY_NAME = "service_request_category_name";

	public static final String SERVICE_REQUEST_ACTION_FK = "service_request_action_fk";
	
	private static final String REQUEST_TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" 
			+ SERVICE_REQUEST_CATEGORY_ID + " INTEGER PRIMARY KEY, " 
			+ SERVICE_REQUEST_CATEGORY_NAME + " TEXT NOT NULL, "
			+ SERVICE_REQUEST_ACTION_FK + " INTEGER, " + " FOREIGN KEY (" + SERVICE_REQUEST_ACTION_FK + ") REFERENCES " 
			+ ServiceRequestActionTable.TABLE_NAME + " (" + ServiceRequestActionTable.SERVICE_REQUEST_ACTION_ID +"));";

	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(REQUEST_TABLE_CREATE);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}
}
