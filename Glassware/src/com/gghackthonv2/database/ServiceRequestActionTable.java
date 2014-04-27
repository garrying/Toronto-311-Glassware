package com.gghackthonv2.database;

import android.database.sqlite.SQLiteDatabase;

public class ServiceRequestActionTable {
	public static final String TABLE_NAME = "service_request_action_table";

	public static final String SERVICE_REQUEST_ACTION_ID = "service_request_action_id";
	public static final String SERVICE_REQUEST_ACTION_NAME = "service_request_action_name";	
	
	
	private static final String REQUEST_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME + " (" + SERVICE_REQUEST_ACTION_ID + " INTEGER PRIMARY KEY, "
			+ SERVICE_REQUEST_ACTION_NAME + " TEXT NOT NULL );";
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(REQUEST_TABLE_CREATE);
	}
	
	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}
}
