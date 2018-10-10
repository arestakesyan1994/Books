package com.example.infinity.prof.handler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.infinity.prof.LoginActivity;
import com.example.infinity.prof.model.Response;

import java.util.HashMap;

public class ResponseHandler {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private static Context _context;
    private static ResponseHandler mInstance;


    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserSession";
    private static final String RESPONSE_EXPIRES = "expires";
    private static final String RESPONSE_EMPTY = "";
    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String RESPONSE_GROUP_ID = "groupId";
    public static final String RESPONSE_ID= "id";
    public static final String RESPONSE_DATE= "date";
    public static final String RESPONSE_REASON= "reason";
    public static final String RESPONSE_GAME= "game";
    public static final String RESPONSE_GRAFIK= "grafik";
    public static final String RESPONSE_SHOW_PHONE= "showPhone";
    public static final String RESPONSE_EXAMEN_ACCESS= "examenAccess";
    public static final String RESPONSE_DESCRIPTION= "description";
    public static final String RESPONSE_TYPE= "type";
    public static final String RESPONSE_LOGIN= "login";
    public static final String RESPONSE_IS_PLAYING_GAME= "isPlayingGame";
    public static final String RESPONSE_SCORE= "score";
    public static final String RESPONSE_GUMAR= "gumar";
    public static final String RESPONSE_PASSWORD= "password";
    public static final String RESPONSE_PAYMANAGRI_SKIZB= "paymanagriSkizb";
    public static final String RESPONSE_AVG= "avg";
    public static final String RESPONSE_TEACHER= "teacher";
    public static final String RESPONSE_LESSON_RATE= "lessonRate";
    public static final String RESPONSE_SURNAME= "surname";
    public static final String RESPONSE_KURS= "kurs";
    public static final String RESPONSE_EMAIL= "email";
    public static final String RESPONSE_GROUP= "group";
    public static final String RESPONSE_CODE_TASK_LEVEL= "codeTaskLevel";
    public static final String RESPONSE_PREFERS= "prefers";
    public static final String RESPONSE_CURRENT_PAYMENT= "currentPayment";
    public static final String RESPONSE_SEX= "sex";
    public static final String RESPONSE_PHOTO= "photo";
    public static final String RESPONSE_CODE_LEVEL= "codeLevel";
    public static final String RESPONSE_ARTIFICIAL_RATE= "artificialRate";
    public static final String RESPONSE_GAME_ACTIVITY= "gameActivity";
    public static final String RESPONSE_MODULES= "modules";
    public static final String RESPONSE_LEVEL_NAME= "levelName";
    public static final String RESPONSE_ZEXCH= "zexch";
    public static final String RESPONSE_RELEASE_DATE= "releaseDate";
    public static final String RESPONSE_NAME= "name";
    public static final String RESPONSE_ONLINE= "online";
    public static final String RESPONSE_PHONE_NUMBER= "phoneNumber";
    public static final String RESPONSE_PAYMANAGRI_AVART= "paymanagriAvart";
    public static final String RESPONSE_SHOW_TESTS= "showTests";
    public static final String RESPONSE_NOTIFICATIONS= "notifications";
    public static final String RESPONSE_STATUS= "status";


    public ResponseHandler(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public static synchronized ResponseHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ResponseHandler(context);
        }
        return mInstance;
    }

    public void createResponseHandler(Response response){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(RESPONSE_ID, String.valueOf(response.getId()));
        editor.putString(RESPONSE_GROUP_ID, response.getGroupId());
        editor.putString(RESPONSE_DATE, response.getDate());
        editor.putString(RESPONSE_REASON, response.getReason());
        editor.putString(RESPONSE_GAME, response.getGame());
        editor.putString(RESPONSE_GRAFIK, String.valueOf(response.getGrafik()));
        editor.putString(RESPONSE_SHOW_PHONE, response.getShowPhone());
        editor.putString(RESPONSE_EXAMEN_ACCESS, response.getExamenAccess());
        editor.putString(RESPONSE_DESCRIPTION, response.getDescription());
        editor.putString(RESPONSE_TYPE, (String) response.getType());
        editor.putString(RESPONSE_LOGIN, response.getLogin());
        editor.putString(RESPONSE_IS_PLAYING_GAME, response.getIsPlayingGame());
        editor.putString(RESPONSE_SCORE, response.getScore());
        editor.putString(RESPONSE_GUMAR, (String) response.getGumar());
        editor.putString(RESPONSE_PASSWORD, response.getPassword());
        editor.putString(RESPONSE_PAYMANAGRI_SKIZB, response.getPaymanagriSkizb());
        editor.putString(RESPONSE_AVG, response.getAvg());
        editor.putString(RESPONSE_TEACHER, String.valueOf(response.getTeacher()));
        editor.putString(RESPONSE_LESSON_RATE, response.getLessonRate());
        editor.putString(RESPONSE_SURNAME, response.getSurname());
        editor.putString(RESPONSE_KURS, String.valueOf(response.getKurs()));
        editor.putString(RESPONSE_EMAIL, response.getEmail());
        editor.putString(RESPONSE_GROUP,String.valueOf(response.getGroup()));
        editor.putString(RESPONSE_CODE_TASK_LEVEL,response.getCodeTaskLevel());
        editor.putString(RESPONSE_PREFERS,response.getPrefers());
        editor.putString(RESPONSE_CURRENT_PAYMENT,response.getCurrentPayment());
        editor.putString(RESPONSE_SEX,response.getSex());
        editor.putString(RESPONSE_PHOTO,response.getPhoto());
        editor.putString(RESPONSE_CODE_LEVEL,response.getCodeLevel());
        editor.putString(RESPONSE_ARTIFICIAL_RATE,response.getArtificialRate());
        editor.putString(RESPONSE_GAME_ACTIVITY,response.getGameActivity());
        editor.putString(RESPONSE_MODULES, String.valueOf(response.getModules()));
        editor.putString(RESPONSE_LEVEL_NAME, response.getLevelName());
        editor.putString(RESPONSE_RELEASE_DATE, String.valueOf(response.getReleaseDate()));
        editor.putString(RESPONSE_ZEXCH, String.valueOf(response.getZexch()));
        editor.putString(RESPONSE_NAME, response.getName());
        editor.putString(RESPONSE_ONLINE, response.getOnline());
        editor.putString(RESPONSE_PHONE_NUMBER, response.getPhoneNumber());
        editor.putString(RESPONSE_PAYMANAGRI_AVART, response.getPaymanagriAvart());
        editor.putString(RESPONSE_SHOW_TESTS, response.getShowTests());
        editor.putString(RESPONSE_NOTIFICATIONS, String.valueOf(response.getNotifications()));
        editor.putString(RESPONSE_STATUS, String.valueOf(response.getStatus()));

        this.editor.commit();
    }

    public HashMap<String, String> getGrafikDetails(){
        HashMap<String, String> user = new HashMap<>();
        user.put(RESPONSE_ID, pref.getString(RESPONSE_ID, null));
        user.put(RESPONSE_STATUS, pref.getString(RESPONSE_STATUS, null));
        user.put(RESPONSE_NOTIFICATIONS, pref.getString(RESPONSE_NOTIFICATIONS, null));
        user.put(RESPONSE_SHOW_TESTS, pref.getString(RESPONSE_SHOW_TESTS, null));
        user.put(RESPONSE_PAYMANAGRI_AVART, pref.getString(RESPONSE_PAYMANAGRI_AVART, null));
        user.put(RESPONSE_PHONE_NUMBER, pref.getString(RESPONSE_PHONE_NUMBER, null));
        user.put(RESPONSE_ONLINE, pref.getString(RESPONSE_ONLINE, null));
        user.put(RESPONSE_NAME, pref.getString(RESPONSE_NAME, null));
        user.put(RESPONSE_RELEASE_DATE, pref.getString(RESPONSE_RELEASE_DATE, null));
        user.put(RESPONSE_ZEXCH, pref.getString(RESPONSE_ZEXCH, null));
        user.put(RESPONSE_LEVEL_NAME, pref.getString(RESPONSE_LEVEL_NAME, null));
        user.put(RESPONSE_MODULES, pref.getString(RESPONSE_MODULES, null));
        user.put(RESPONSE_GAME_ACTIVITY, pref.getString(RESPONSE_GAME_ACTIVITY, null));
        user.put(RESPONSE_ARTIFICIAL_RATE, pref.getString(RESPONSE_ARTIFICIAL_RATE, null));
        user.put(RESPONSE_CODE_LEVEL, pref.getString(RESPONSE_CODE_LEVEL, null));
        user.put(RESPONSE_PHOTO, pref.getString(RESPONSE_PHOTO, null));
        user.put(RESPONSE_SEX, pref.getString(RESPONSE_SEX, null));
        user.put(RESPONSE_CURRENT_PAYMENT, pref.getString(RESPONSE_CURRENT_PAYMENT, null));
        user.put(RESPONSE_PREFERS, pref.getString(RESPONSE_PREFERS, null));
        user.put(RESPONSE_CODE_TASK_LEVEL, pref.getString(RESPONSE_CODE_TASK_LEVEL, null));
        user.put(RESPONSE_GROUP, pref.getString(RESPONSE_GROUP, null));
        user.put(RESPONSE_EMAIL, pref.getString(RESPONSE_EMAIL, null));
        user.put(RESPONSE_KURS, pref.getString(RESPONSE_KURS, null));
        user.put(RESPONSE_SURNAME, pref.getString(RESPONSE_SURNAME, null));
        user.put(RESPONSE_GROUP_ID, pref.getString(RESPONSE_GROUP_ID, null));
        user.put(RESPONSE_DATE, pref.getString(RESPONSE_DATE, null));
        user.put(RESPONSE_REASON, pref.getString(RESPONSE_REASON, null));
        user.put(RESPONSE_GAME, pref.getString(RESPONSE_GAME, null));
        user.put(RESPONSE_GRAFIK, pref.getString(RESPONSE_GRAFIK, null));
        user.put(RESPONSE_SHOW_PHONE, pref.getString(RESPONSE_SHOW_PHONE, null));
        user.put(RESPONSE_EXAMEN_ACCESS, pref.getString(RESPONSE_EXAMEN_ACCESS, null));
        user.put(RESPONSE_DESCRIPTION, pref.getString(RESPONSE_DESCRIPTION, null));
        user.put(RESPONSE_TYPE, pref.getString(RESPONSE_TYPE, null));
        user.put(RESPONSE_LOGIN, pref.getString(RESPONSE_LOGIN, null));
        user.put(RESPONSE_IS_PLAYING_GAME, pref.getString(RESPONSE_IS_PLAYING_GAME, null));
        user.put(RESPONSE_SCORE, pref.getString(RESPONSE_SCORE, null));
        user.put(RESPONSE_GUMAR, pref.getString(RESPONSE_GUMAR, null));
        user.put(RESPONSE_PASSWORD, pref.getString(RESPONSE_PASSWORD, null));
        user.put(RESPONSE_PAYMANAGRI_SKIZB, pref.getString(RESPONSE_PAYMANAGRI_SKIZB, null));
        user.put(RESPONSE_AVG, pref.getString(RESPONSE_AVG, null));
        user.put(RESPONSE_TEACHER, pref.getString(RESPONSE_TEACHER, null));
        user.put(RESPONSE_LESSON_RATE, pref.getString(RESPONSE_LESSON_RATE, null));


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