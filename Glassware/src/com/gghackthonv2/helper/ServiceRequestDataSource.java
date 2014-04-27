package com.gghackthonv2.helper;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gghackthonv2.database.RequestDatabaseHelper;
import com.gghackthonv2.database.ServiceRequestActionTable;
import com.gghackthonv2.database.ServiceRequestCategoryTable;
import com.gghackthonv2.database.ServiceRequestTypeTable;

public class ServiceRequestDataSource {

	private RequestDatabaseHelper mDatabaseHelper;
	
	private String[] allServiceRequestAction = {
			ServiceRequestActionTable.SERVICE_REQUEST_ACTION_ID,
			ServiceRequestActionTable.SERVICE_REQUEST_ACTION_NAME
	};
	
	private String[] allServiceRequestCategory = {
			ServiceRequestCategoryTable.SERVICE_REQUEST_CATEGORY_ID,
			ServiceRequestCategoryTable.SERVICE_REQUEST_CATEGORY_NAME,
			ServiceRequestCategoryTable.SERVICE_REQUEST_ACTION_FK
	};
	
	private String[] allServiceRequestType = {
			ServiceRequestTypeTable.SERVICE_REQUEST_TYPE_ID,
			ServiceRequestTypeTable.SERVICE_REQUEST_TYPE_DETAIL,
			ServiceRequestTypeTable.SERVICE_REQUEST_CATEGORY_FK
	};
	
	public ServiceRequestDataSource(Context context) {
		mDatabaseHelper = new RequestDatabaseHelper(context);
	}
	
//	/** Initial Database Query **/
//	public void createDefaultRouteAction() {
//		SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();
//
//		List<RouteAction> defaultActions = new ArrayList<RouteAction>();
//		defaultActions.add(new RouteAction(ActionType.CYCLING, "Cycling", 0));
//		defaultActions.add(new RouteAction(ActionType.RUNNING, "Running", 0));
//		defaultActions.add(new RouteAction(ActionType.WALKING, "Walking", 0));
//		defaultActions.add(new RouteAction(ActionType.SKIING, "Skiing", 0));
//
//		for (RouteAction defaultRouteAction : defaultActions) {
//			createRouteAction(defaultRouteAction.getRouteType(), defaultRouteAction.getRouteActionName());
//		}
//		database.close();
//	}
//	
//	/** RouteAction Queries **/
//	// Create and Insert RouteAction Query
//	public RouteAction createRouteAction(ActionType type, String routeActionName) {
//		SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();
//
//		ContentValues values = new ContentValues();
//		values.put(RouteActionTable.ROUTE_ACTION_TYPE, type.getCode());
//		values.put(RouteActionTable.ROUTE_ACTION_NAME, routeActionName);
//		long insertId = database.insert(RouteActionTable.TABLE_NAME, null, values);
//
//		Cursor cursor = database.query(RouteActionTable.TABLE_NAME, allColumnsInRouteAction,
//				RouteActionTable.ROUTE_ACTION_ID + " = " + insertId, null, null, null, null);
//		cursor.moveToFirst();
//		RouteAction newRouteAction = cursorToRouteAction(cursor);
//		cursor.close();
//
//		database.close();
//		return newRouteAction;
//	}
}
