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
		ServiceResponseTable.onCreate(database);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		ServiceResponseTable.onUpgrade(database, oldVersion, newVersion);
	}
}
