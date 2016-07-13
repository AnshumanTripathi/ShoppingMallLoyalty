package com.shoppingmallloyality.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "survey_db.sqlite";
	public static final String TABLE_USER = "user_table";
	public static final String USER_ID = "_id";
	public static final String FIRSTNAME = "first_name";
	public static final String LASTNAME = "last_name";
	public static final String USERNAME = "user_name";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email_id";
	public static final String CONTACT_NUMBER = "contact_number";
	public static final String GENDER = "gender";
	public static final String DATE_OF_BIRTH = "dob";
	public static final String COUNTRY = "country";
	public static final String STATE = "state";
	public static final String CITY = "city";

	private static final String CREATE_TABLE_USER = "CREATE TABLE "
			+ TABLE_USER + "(" + USER_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + FIRSTNAME + " TEXT,"
			+ LASTNAME + " TEXT," + USERNAME + " TEXT," + PASSWORD + " TEXT,"
			+ EMAIL + " TEXT," + CONTACT_NUMBER + " TEXT," + GENDER + " TEXT,"
			+ DATE_OF_BIRTH + " TEXT," + COUNTRY + " TEXT," + STATE + " TEXT,"
			+ CITY + " TEXT)" + "";

	
	
		public static final String TABLE_QUESTION = "question_table";

	
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_USER);
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
	}

}
