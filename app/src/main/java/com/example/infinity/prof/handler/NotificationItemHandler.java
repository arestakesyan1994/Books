package com.example.infinity.prof.handler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.infinity.prof.LoginActivity;
import com.example.infinity.prof.model.NotificationsItem;

import java.util.HashMap;

public class NotificationItemHandler {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private static Context _context;
    private static NotificationItemHandler mInstance;


    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserSession";
    private static final String NOTIFICATION_EXPIRES = "expires";
    private static final String NOTIFICATION_EMPTY = "";
    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String NOTIFICATION_ID = "id";
    public static final String NOTIFICATION_STUDENT_ID = "studentId";
    public static final String NOTIFICATION_TEXT= "text";
    public static final String NOTIFICATION_WHEN = "when";
    public static final String NOTIFICATION_STATUS = "status";


    public NotificationItemHandler(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public static synchronized NotificationItemHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new NotificationItemHandler(context);
        }
        return mInstance;
    }

    public void createModulesSession(NotificationsItem notification){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(NOTIFICATION_ID, String.valueOf(notification.getId()));
        editor.putString(NOTIFICATION_STATUS, notification.getStatus());
        editor.putString(NOTIFICATION_STUDENT_ID, notification.getStudentId());
        editor.putString(NOTIFICATION_TEXT,notification.getText());
        editor.putString(NOTIFICATION_WHEN,notification.getWhen());

        editor.commit();
    }

    public HashMap<String, String> getmodulesDetails(){
        HashMap<String, String> user = new HashMap<>();
        user.put(NOTIFICATION_ID, pref.getString(NOTIFICATION_ID, null));
        user.put(NOTIFICATION_WHEN, pref.getString(NOTIFICATION_WHEN, null));
        user.put(NOTIFICATION_STUDENT_ID, pref.getString(NOTIFICATION_STUDENT_ID, null));
        user.put(NOTIFICATION_TEXT, pref.getString(NOTIFICATION_TEXT, null));
        user.put(NOTIFICATION_STATUS, pref.getString(NOTIFICATION_STATUS, null));

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