package com.siamsoft.sqlite_cms;

import android.content.Context;

import java.util.ArrayList;

public class UserFunction {
    public UserFunction() {

    }

    public void insertUserInfo(Context context, String name,String mobile)
    {
        DBHandler dbHandler =new DBHandler(context);
        dbHandler.insert(name, mobile);
    }


    public ArrayList<Custom> getAllInfo(Context context)
    {
        DBHandler db = new DBHandler(context);
        return db.getAllInfo(context);

    }

}
