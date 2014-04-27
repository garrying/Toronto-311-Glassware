package com.gghackthonv2.database;

import android.database.sqlite.SQLiteDatabase;

public class ResponsedServiceTable {
	
	public static final String RESPONSED_SERVICE_TABLE = "responsed_service_table";

	public static final String RESPONSED_SERVICE_ID = "responsed_service_id";
	
	public static final String RESPONSED_SERVICE_TOKEN = "token";	
	public static final String RESPONSED_SERVICE_NOTICE = "service_notice";
	
	public static final String REQUESTED_SERVICE_FK = "requested_service_fk";
	
	private static final String REQUEST_TABLE_CREATE = "CREATE TABLE "
			+ RESPONSED_SERVICE_TABLE + " (" + RESPONSED_SERVICE_ID + " INTEGER PRIMARY KEY, "
			+ RESPONSED_SERVICE_TOKEN + " TEXT , "
			+ RESPONSED_SERVICE_NOTICE + " TEXT , "
			+ REQUESTED_SERVICE_FK + " INTEGER, "
			+ " FOREIGN KEY (" + REQUESTED_SERVICE_FK + ") REFERENCES " 
			+ RequestedServiceTable.TABLE_NAME + " (" + RequestedServiceTable.REQUESTED_SERVICE_ID +"));";
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(REQUEST_TABLE_CREATE);
	}
	
	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + RESPONSED_SERVICE_TABLE);
		onCreate(database);
	}
}
