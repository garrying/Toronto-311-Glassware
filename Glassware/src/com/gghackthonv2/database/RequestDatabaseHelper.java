package com.gghackthonv2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RequestDatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "request.db";
	private static final int DATABASE_VERSION = 1;
	
	public RequestDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		//ResponsedServiceTable.onCreate(database);
		ServiceRequestActionTable.onCreate(database);
		ServiceRequestCategoryTable.onCreate(database);
		ServiceRequestTypeTable.onCreate(database);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		//ResponsedServiceTable.onUpgrade(database, oldVersion, newVersion);
		ServiceRequestActionTable.onUpgrade(database, oldVersion, newVersion);
		ServiceRequestCategoryTable.onUpgrade(database, oldVersion, newVersion);
		ServiceRequestTypeTable.onUpgrade(database, oldVersion, newVersion);
	}
}
