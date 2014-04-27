package com.gghackthonv2.database;

import android.database.sqlite.SQLiteDatabase;

public class ServiceRequestTypeTable {
	public static final String TABLE_NAME = "service_request_type_table";

	public static final String SERVICE_REQUEST_TYPE_ID = "service_request_type_id";
	public static final String SERVICE_REQUEST_TYPE_DETAIL = "service_request_type_detail";

	public static final String SERVICE_REQUEST_CATEGORY_FK = "service_category_fk";
	
	private static final String REQUEST_TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" 
			+ SERVICE_REQUEST_TYPE_ID + " INTEGER PRIMARY KEY, " 
			+ SERVICE_REQUEST_TYPE_DETAIL + " TEXT NOT NULL, "
			+ SERVICE_REQUEST_CATEGORY_FK + " INTEGER, " + " FOREIGN KEY (" + SERVICE_REQUEST_CATEGORY_FK + ") REFERENCES " 
			+ ServiceRequestCategoryTable.TABLE_NAME + " (" + ServiceRequestCategoryTable.SERVICE_REQUEST_CATEGORY_ID +"));";

	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(REQUEST_TABLE_CREATE);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}
}
