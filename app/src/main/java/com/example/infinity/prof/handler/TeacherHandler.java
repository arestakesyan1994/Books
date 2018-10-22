package com.example.infinity.prof.handler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.infinity.prof.LoginActivity;
import com.example.infinity.prof.model.Teacher;

import java.util.HashMap;

public class TeacherHandler {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private static Context _context;
    private static TeacherHandler mInstance;


    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserSession";
    private static final String TEACHER_EXPIRES = "expires";
    private static final String TEACHER_EMPTY = "";
    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String TEACHER_ID = "idTeacher";
    public static final String TEACHER_RATING = "raitingTeacher";
    public static final String TEACHER_AVG_FLOW = "avgFlowTeacher";
    public static final String TEACHER_AVG_LISTEN = "avgListenTeacher";
    public static final String TEACHER_LEVEL = "levelTeacher";
    public static final String TEACHER_PROJECT= "avgProjectTeacher";
    public static final String TEACHER_ABOUT= "aboutTeacher";
    public static final String TEACHER_ACTIVE= "activeTeacher";
    public static final String TEACHER_PHONE= "phoneTeacher";
    public static final String TEACHER_AVG_STUD= "avgStudTeacher";
    public static final String TEACHER_SURNAME = "surnameTeacher";
    public static final String TEACHER_PHOTO = "photoTeacher";
    public static final String TEACHER_NAME = "nameTeacher";


    public TeacherHandler(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public static synchronized TeacherHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new TeacherHandler(context);
        }
        return mInstance;
    }

    public void createTeacherSession(Teacher teacher){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(TEACHER_ID, String.valueOf(teacher.getId()));
        editor.putString(TEACHER_NAME, teacher.getName());
        editor.putString(TEACHER_SURNAME, teacher.getSurname());
        editor.putString(TEACHER_PHOTO,teacher.getPhoto());
        editor.putString(TEACHER_RATING,teacher.getRaiting());
        editor.putString(TEACHER_AVG_FLOW,teacher.getAvgFlow());
        editor.putString(TEACHER_AVG_LISTEN,teacher.getAvgListen());
        editor.putString(TEACHER_LEVEL,teacher.getLevel());
        editor.putString(TEACHER_PROJECT,teacher.getAvgProject());
        editor.putString(TEACHER_ABOUT,teacher.getAbout());
        editor.putString(TEACHER_ACTIVE,teacher.getActive());
        editor.putString(TEACHER_PHONE,teacher.getPhone());
        editor.putString(TEACHER_AVG_STUD,teacher.getAvgStud());
        editor.commit();
    }

    public HashMap<String, String> getTeacherDetails(){
        HashMap<String, String> user = new HashMap<>();
        user.put(TEACHER_ID, pref.getString(TEACHER_ID, null));
        user.put(TEACHER_NAME, pref.getString(TEACHER_NAME, null));
        user.put(TEACHER_SURNAME, pref.getString(TEACHER_SURNAME, null));
        user.put(TEACHER_PHOTO, pref.getString(TEACHER_PHOTO, null));
        user.put(TEACHER_RATING, pref.getString(TEACHER_RATING, null));
        user.put(TEACHER_AVG_FLOW, pref.getString(TEACHER_AVG_FLOW, null));
        user.put(TEACHER_AVG_LISTEN, pref.getString(TEACHER_AVG_LISTEN, null));
        user.put(TEACHER_LEVEL, pref.getString(TEACHER_LEVEL, null));
        user.put(TEACHER_PROJECT, pref.getString(TEACHER_PROJECT, null));
        user.put(TEACHER_ABOUT, pref.getString(TEACHER_ABOUT, null));
        user.put(TEACHER_ACTIVE, pref.getString(TEACHER_ACTIVE, null));
        user.put(TEACHER_PHONE, pref.getString(TEACHER_PHONE, null));
        user.put(TEACHER_AVG_STUD, pref.getString(TEACHER_AVG_STUD, null));
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