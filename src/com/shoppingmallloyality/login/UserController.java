package com.shoppingmallloyality.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;



public class UserController {
	private DBHelper mDbHelper;
	private SQLiteDatabase mDb;
	private Context ctx;

	public UserController(Context ctx) {
		this.ctx = ctx;
	}

	public DBHelper open() throws SQLException {
		mDbHelper = new DBHelper(ctx);
		mDb = mDbHelper.getWritableDatabase();
		return mDbHelper;
	}

	public void close() {
		if (mDbHelper != null) {
			mDbHelper.close();
		}
	}

	public int checkUser(String userName, String password) {
		String selection = DBHelper.USERNAME + "= ? AND " + DBHelper.PASSWORD
				+ " = ?";
		String[] selectionArgs = { userName, password };

		Cursor mCursor = mDb.query(DBHelper.TABLE_USER, null, selection,
				selectionArgs, null, null, null);
		int result = mCursor.getCount();
		mCursor.close();
		return result;
	}

	public User fetchUser(String userName, String password) throws SQLException {
		User user = null;
		Cursor mCursor = null;
		String selection = DBHelper.USERNAME + "= ? AND " + DBHelper.PASSWORD
				+ " = ?";
		String[] selectionArgs = { userName, password };
		mCursor = mDb.query(DBHelper.TABLE_USER, new String[] {
				DBHelper.USER_ID, DBHelper.FIRSTNAME, DBHelper.LASTNAME,
				DBHelper.USERNAME, DBHelper.PASSWORD, DBHelper.EMAIL,
				DBHelper.CONTACT_NUMBER, DBHelper.GENDER,
				DBHelper.DATE_OF_BIRTH, DBHelper.COUNTRY, DBHelper.STATE,
				DBHelper.CITY }, selection, selectionArgs, null, null, null);

		if (mCursor != null) {
			while (mCursor.moveToNext()) {
				user = new User();
				user.setId(mCursor.getInt(mCursor
						.getColumnIndex(DBHelper.USER_ID)));
				user.setUserName(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.USERNAME)));
				user.setPassword(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.PASSWORD)));

				user.setFirstName(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.FIRSTNAME)));
				user.setLastName(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.LASTNAME)));
				user.setEmailId(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.EMAIL)));
				user.setMobileNumber(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.CONTACT_NUMBER)));
				user.setGender(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.GENDER)));
				user.setDateOfBirth(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.DATE_OF_BIRTH)));
				user.setCity(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.CITY)));
				user.setCountry(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.COUNTRY)));
				user.setState(mCursor.getString(mCursor
						.getColumnIndex(DBHelper.STATE)));
			}
		}
		return user;
	}

	public long registerUser(String firstname, String lastname,
			String username, String password, String email,
			String contact_number, String selectedGender, String dob,
			String country, String state, String city) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();
		initialValues.put(DBHelper.FIRSTNAME, firstname);
		initialValues.put(DBHelper.LASTNAME, lastname);
		initialValues.put(DBHelper.USERNAME, username);
		initialValues.put(DBHelper.PASSWORD, password);
		initialValues.put(DBHelper.CONTACT_NUMBER, contact_number);
		initialValues.put(DBHelper.EMAIL, email);
		initialValues.put(DBHelper.GENDER, selectedGender);
		initialValues.put(DBHelper.DATE_OF_BIRTH, dob);
		initialValues.put(DBHelper.COUNTRY, country);
		initialValues.put(DBHelper.STATE, state);
		initialValues.put(DBHelper.CITY, city);

		return mDb.insert(DBHelper.TABLE_USER, null, initialValues);

	}

	public long updateUser(String selectedChoice, String value) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();
		if (selectedChoice.equals("First Name")) {
			initialValues.put(DBHelper.FIRSTNAME, value);
			return mDb.update(DBHelper.TABLE_USER, initialValues, null, null);
		}
		if (selectedChoice.equals("Last Name")) {
			initialValues.put(DBHelper.LASTNAME, value);
			return mDb.update(DBHelper.TABLE_USER, initialValues, null, null);
		}
		if (selectedChoice.equals("Password")) {
			initialValues.put(DBHelper.PASSWORD, value);
			return mDb.update(DBHelper.TABLE_USER, initialValues, null, null);
		}
		if (selectedChoice.equals("Phone Number")) {
			initialValues.put(DBHelper.CONTACT_NUMBER, value);
			return mDb.update(DBHelper.TABLE_USER, initialValues, null, null);
		}
		if (selectedChoice.equals("Email Id")) {
			initialValues.put(DBHelper.EMAIL, value);
			return mDb.update(DBHelper.TABLE_USER, initialValues, null, null);
		}
		if (selectedChoice.equals("Gender")) {
			initialValues.put(DBHelper.GENDER, value);
			return mDb.update(DBHelper.TABLE_USER, initialValues, null, null);
		}
		if (selectedChoice.equals("Date Of Birth")) {
			initialValues.put(DBHelper.DATE_OF_BIRTH, value);
			return mDb.update(DBHelper.TABLE_USER, initialValues, null, null);
		}
		if (selectedChoice.equals("Country")) {
			initialValues.put(DBHelper.COUNTRY, value);
			return mDb.update(DBHelper.TABLE_USER, initialValues, null, null);
		}
		if (selectedChoice.equals("State")) {
			initialValues.put(DBHelper.STATE, value);
			return mDb.update(DBHelper.TABLE_USER, initialValues, null, null);
		}
		if (selectedChoice.equals("City")) {
			initialValues.put(DBHelper.CITY, value);
			return mDb.update(DBHelper.TABLE_USER, initialValues, null, null);
		}
		return 0;

	}
}
