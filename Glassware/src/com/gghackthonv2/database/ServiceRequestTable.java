package com.gghackthonv2.database;

import android.database.sqlite.SQLiteDatabase;


public class ServiceRequestTable {

	public static final String TABLE_NAME = "requests";

	public static final String SERVICE_REQUEST_ID = "service_request_id";
	
	public static final String SERVICE_REQUEST_LAT = "lat";
	public static final String SERVICE_REQUEST_LONG = "long";
	public static final String SERVICE_REQUEST_ADDRESS ="address";
	public static final String SERVICE_REQUEST_DESCRIPTION = "description";
	public static final String SERVICE_REQUEST_MEDIA_URL = "media_url";
	
	public static final String SERVICE_CODE_FK = "service_code_fk";
	
	private static final String REQUEST_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME + " (" + SERVICE_REQUEST_ID + " INTEGER PRIMARY KEY, "
			+ SERVICE_REQUEST_LAT + " REAL NOT NULL, "
			+ SERVICE_REQUEST_LONG + " REAL NOT NULL, "
			+ SERVICE_REQUEST_ADDRESS + " TEXT, "
			+ SERVICE_REQUEST_DESCRIPTION + " TEXT, "
			+ SERVICE_REQUEST_MEDIA_URL + " TEXT, "
			+ SERVICE_CODE_FK + " INTEGER, " 
			+ " FOREIGN KEY (" + SERVICE_CODE_FK + ") REFERENCES " 
			+ ServiceCodeTable.TABLE_NAME + " (" + ServiceCodeTable.SERVICE_CODE_ID +"));";
			
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(REQUEST_TABLE_CREATE);
	}
	
	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}
}
