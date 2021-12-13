package com.siamsoft.sqlite_cms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import static android.content.ContentValues.TAG;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    //DB nmae
    private static final String DATABASE_NAME = "Rem";
    //Table name
    private static final String TABLE_USERINFO = "Emillia";
    private static final String KEY_USERINFO_Id = "Id";
    private static final String KEY_USERINFO_NAME = "name";
    private static final String KEY_USERINFO_mobile = "mobile";

    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            String CREATE_USERINFO = "CREATE TABLE " + TABLE_USERINFO + "(" + KEY_USERINFO_Id + " INTEGER PRIMARY KEY," + KEY_USERINFO_NAME + "TEXT," + KEY_USERINFO_mobile + "TEXT" + ")";

            db.execSQL(CREATE_USERINFO);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(TAG, "UPGRADING FROM VERSION" + oldVersion + "TO" + newVersion + "WHICH WILL DESTROY OLD DATA MUHAHAHAHAHA");
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);


    }


    //insert Data

    public void insert(String name, String mob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_USERINFO_NAME, name);
        values.put(KEY_USERINFO_mobile, mob);

        db.insert(TABLE_USERINFO, null, values);
        db.close();

    }


    //----------

    public ArrayList<Custom> getAllInfo(Context context) {
        ArrayList<Custom> userInfoList = new ArrayList<>();


        try {
            String selectQuery = "SELECT *FROM " + TABLE_USERINFO + "";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();


            while (!cursor.isAfterLast()) {
                Custom custom = new Custom();

                String id = cursor.getString(0).toString();
                custom.setStrID(id);
                String name = cursor.getString(1).toString();
                custom.setStrID(name);
                String mobile = cursor.getString(2).toString();
                custom.setStrID(mobile);

                userInfoList.add(custom);
                cursor.moveToNext();
            }
            cursor.close();
            db.close();

        } catch (Exception ex) {
            Log.e("getCampaignId Excep. :", ex.toString());
        }


        return userInfoList;
    }


}



