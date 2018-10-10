package com.example.infinity.prof.handler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.infinity.prof.LoginActivity;
import com.example.infinity.prof.model.Group;

import java.util.HashMap;

public class GroupHandler {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private static Context _context;
    private static GroupHandler mInstance;


    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserSession";
    private static final String GROUP_EXPIRES = "expires";
    private static final String GROUP_EMPTY = "";
    private static final String IS_LOGIN = "IsLoggedIn";

    public static String GROUP_ID = "id";
    public static final String GROUP_LSAEAN_ID = "lsaranId";
    public static final String GROUP_MODULE_ID = "moduleId";
    public static final String GROUP_COLOR = "color";
    public static final String GROUP_LEVEL = "level";
    public static final String GROUP_TEACHER_ID= "teacherId";
    public static final String GROUP_GNAME= "name";
    public static final String GROUP_ACTIVE= "active";
    public static final String GROUP_STUDENTS= "students";
    public static final String GROUP_PART_ID= "partId";


    public GroupHandler(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public static synchronized GroupHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new GroupHandler(context);
        }
        return mInstance;
    }

    public void createGroupHandler(Group group){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(GROUP_ID, String.valueOf(group.getId()));
        editor.putString(GROUP_LSAEAN_ID, (String) group.getLsaranId());
        editor.putString(GROUP_MODULE_ID, (String) group.getModuleId());
        editor.putString(GROUP_COLOR, (String) group.getColor());
        editor.putString(GROUP_LEVEL, (String) group.getLevel());
        editor.putString(GROUP_TEACHER_ID, (String) group.getTeacherId());
        editor.putString(GROUP_GNAME, (String) group.getName());
        editor.putString(GROUP_ACTIVE, (String) group.getActive());
//        editor.putString(GROUP_STUDENTS, (String) group.getStudents());
        editor.putString(GROUP_STUDENTS, String.valueOf(group.getStudents()));
        editor.putString(GROUP_PART_ID, group.getPartId());

        this.editor.commit();
    }

    public HashMap<String, String> getGroupDetails(){
        HashMap<String, String> user = new HashMap<>();

        user.put(GROUP_ID, pref.getString(GROUP_ID, null));
        user.put(GROUP_LSAEAN_ID, pref.getString(GROUP_LSAEAN_ID, null));
        user.put(GROUP_MODULE_ID, pref.getString(GROUP_MODULE_ID, null));
        user.put(GROUP_COLOR, pref.getString(GROUP_COLOR, null));
        user.put(GROUP_LEVEL, pref.getString(GROUP_LEVEL, null));
        user.put(GROUP_TEACHER_ID, pref.getString(GROUP_TEACHER_ID, null));
        user.put(GROUP_GNAME, pref.getString(GROUP_GNAME, null));
        user.put(GROUP_ACTIVE, pref.getString(GROUP_ACTIVE, null));
        user.put(GROUP_STUDENTS, pref.getString(GROUP_STUDENTS, null));
        user.put(GROUP_PART_ID, pref.getString(GROUP_PART_ID, null));
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