package com.gghackthonv2.database;

import android.database.sqlite.SQLiteDatabase;


public class RequestedServiceTable {

	public static final String TABLE_NAME = "requested_service_table";

	public static final String REQUESTED_SERVICE_ID = "requested_service_id";
	
	public static final String REQUESTED_SERVICE_LAT = "lat";
	public static final String REQUESTED_SERVICE_LONG = "long";
	public static final String REQUESTED_SERVICE_ADDRESS ="address";
	public static final String REQUESTED_SERVICE_DESCRIPTION = "description";
	public static final String REQUESTED_SERVICE_MEDIA_URL = "media_url";
	
	public static final String SERVICE_CODE_FK = "service_code_fk";
	
	private static final String REQUEST_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME + " (" + REQUESTED_SERVICE_ID + " INTEGER PRIMARY KEY, "
			+ REQUESTED_SERVICE_LAT + " REAL NOT NULL, "
			+ REQUESTED_SERVICE_LONG + " REAL NOT NULL, "
			+ REQUESTED_SERVICE_ADDRESS + " TEXT, "
			+ REQUESTED_SERVICE_DESCRIPTION + " TEXT, "
			+ REQUESTED_SERVICE_MEDIA_URL + " TEXT, "
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
