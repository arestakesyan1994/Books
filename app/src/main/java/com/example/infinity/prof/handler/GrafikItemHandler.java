package com.example.infinity.prof.handler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.infinity.prof.LoginActivity;
import com.example.infinity.prof.model.GrafikItem;
import com.example.infinity.prof.model.StudentsItem;

import java.util.HashMap;

public class GrafikItemHandler {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private static Context _context;
    private static GrafikItemHandler mInstance;


    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserSession";
    private static final String GRAFIK_EXPIRES = "expires";
    private static final String GRAFIK_EMPTY = "";
    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String GRAFIK_GROUP_ID = "groupId";
    public static final String GRAFIK_TEACHER_ID = "teacherId";
    public static final String GRAFIK_START = "start";
    public static final String GRAFIK_ACTIVE = "active";
    public static final String GRAFIK_END = "end";
    public static final String GRAFIK_ID= "id";
    public static final String GRAFIK_DAY_ID= "dayId";
    public static final String GRAFIK_DAY= "day";

    public GrafikItemHandler(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public static synchronized GrafikItemHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new GrafikItemHandler(context);
        }
        return mInstance;
    }

    public void createGroupHandler(GrafikItem grafikItem){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(GRAFIK_ID, String.valueOf(grafikItem.getId()));
//        editor.putString(GRAFIK_GROUP_ID, (String) grafikItem.getGroupId());
        editor.putString(GRAFIK_START, (String) grafikItem.getStart());
        editor.putString(GRAFIK_END, (String) grafikItem.getEnd());
        editor.putString(GRAFIK_DAY_ID, (String) grafikItem.getDayId());
        editor.putString(GRAFIK_TEACHER_ID, (String) grafikItem.getTeacherId());
        editor.putString(GRAFIK_DAY, (String) grafikItem.getDay());
        editor.putString(GRAFIK_ACTIVE, (String) grafikItem.getActive());
        this.editor.commit();
    }
    
    public void createStHandler(StudentsItem studentsItem){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(GRAFIK_GROUP_ID, studentsItem.getGroupId());
    }


    public HashMap<String, String> getGrafikDetails(){
        HashMap<String, String> user = new HashMap<>();
        user.put(GRAFIK_ID, pref.getString(GRAFIK_ID, null));
        user.put(GRAFIK_GROUP_ID, pref.getString(GRAFIK_GROUP_ID, null));
        user.put(GRAFIK_START, pref.getString(GRAFIK_START, null));
        user.put(GRAFIK_END, pref.getString(GRAFIK_END, null));
        user.put(GRAFIK_DAY_ID, pref.getString(GRAFIK_DAY_ID, null));
        user.put(GRAFIK_TEACHER_ID, pref.getString(GRAFIK_TEACHER_ID, null));
        user.put(GRAFIK_DAY, pref.getString(GRAFIK_DAY, null));
        user.put(GRAFIK_ACTIVE, pref.getString(GRAFIK_ACTIVE, null));
        return user;
    }
    public void checkLogin(){
        if(!this.isLoggedIn()){
            Intent i = new Intent(_context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}