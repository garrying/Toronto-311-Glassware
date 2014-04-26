package com.gghackthonv2.database;

import android.database.sqlite.SQLiteDatabase;

public class ServiceCodeTable {
	
	public static final String TABLE_NAME = "service_code_table";

	public static final String SERVICE_CODE_ID = "service_code_id";
	public static final String SERVICE_CODE_NAME = "service_code_name";
	
	
	private static final String REQUEST_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME + " (" + SERVICE_CODE_ID + " INTEGER PRIMARY KEY, "
			+ SERVICE_CODE_NAME + " TEXT NOT NULL);";
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(REQUEST_TABLE_CREATE);
	}
	
	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}
}
