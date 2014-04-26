package com.gghackthonv2.database;

import android.database.sqlite.SQLiteDatabase;

public class ServiceResponseTable {
	
	public static final String TABLE_NAME = "reponses";

	public static final String SERVICE_RESPONSE_ID = "service_response_id";
	
	public static final String SERVICE_RESPONSE_TOKEN = "token";	
	public static final String SERVICE_RESPONSE_SERVICE_NOTICE = "service_notice";
	
	public static final String SERVICE_REQUEST_FK = "service_request_fk";
	
	private static final String REQUEST_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME + " (" + SERVICE_RESPONSE_ID + " INTEGER PRIMARY KEY, "
			+ SERVICE_RESPONSE_TOKEN + " TEXT , "
			+ SERVICE_RESPONSE_SERVICE_NOTICE + " TEXT , "
			+ SERVICE_REQUEST_FK + " INTEGER, "
			+ " FOREIGN KEY (" + SERVICE_REQUEST_FK + ") REFERENCES " 
			+ ServiceRequestTable.TABLE_NAME + " (" + ServiceRequestTable.SERVICE_REQUEST_ID +"));";
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(REQUEST_TABLE_CREATE);
	}
	
	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}
}
