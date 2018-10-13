package com.example.infinity.prof.handler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.infinity.prof.LoginActivity;
import com.example.infinity.prof.model.GrafikItem;
import com.example.infinity.prof.model.StudentsItem;

import java.util.HashMap;

public class SessionHandler {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private static Context _context;
    private static SessionHandler mInstance;


    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserSession";
    private static final String KEY_EXPIRES = "expires";
    private static final String KEY_EMPTY = "";
    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_ID = "id";
    public static final String KEY_DATE = "date";
    public static final String KEY_RESON = "reason";
    public static final String KEY_GAME = "game";
    public static final String KEY_SHOW_PHONE = "showPhone";
    public static final String KEY_EXAMEN_ACCESS = "examenAccess";
    public static final String KEY_DESORIPTION = "description";
    public static final String KEY_TYPE = "type";
    public static final String KEY_LOGIn = "login";
    public static final String KEY_IS_PLAYING_GAME = "isPlayingGame";
    public static final String KEY_SCORE = "score";
    public static final String KEY_GUMAR = "gumar";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_PAYMANAGRI_SKIZB = "paymanagriSkizb";
    public static final String KEY_AVG = "avg";
    public static final String KEY_LESSON_RATE = "lessonRate";
    public static final String KEY_SURNAME = "surname";
    public static final String KEY_KURS = "kurs";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_CODE_TASK_LEVEL = "codeTaskLevel";
    public static final String KEY_PREFERS = "prefers";
    public static final String KEY_CURRENT_PAYMENT = "currentPayment";
    public static final String KEY_SEX = "sex";
    public static final String KEY_PHOTO = "photo";
    public static final String KEY_CODE_LEVEl = "codeLevel";
    public static final String KEY_ARTIFICIAL_RATE = "artificialRate";
    public static final String KEY_GAME_ACTIVITY = "gameActivity";
    public static final String KEY_LEVEL_NAME = "levelName";
    public static final String KEY_ZEXCH = "zexch";
    public static final String KEY_GROUP_ID = "groupId";
    public static final String KEY_RELEASE_DATE = "releaseDate";
    public static final String KEY_NAME = "name";
    public static final String KEY_ONLINE = "online";
    public static final String KEY_PHONE_NUMBER = "phoneNumber";
    public static final String KEY_PAYMANAGRT_AVART = "paymanagriAvart";
    public static final String KEY_SHOW_TESTS = "showTests";
    public static final String KEY_STATUS = "status";

    public static final String GRAFIK_GROUP_ID = "groupId";
    public static final String GRAFIK_TEACHER_ID = "teacherId";
    public static final String GRAFIK_START = "start";
    public static final String GRAFIK_ACTIVE = "active";
    public static final String GRAFIK_END = "end";
    public static final String GRAFIK_ID= "id";
    public static final String GRAFIK_DAY_ID= "dayId";
    public static final String GRAFIK_DAY= "day";

    public SessionHandler(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public static synchronized SessionHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SessionHandler(context);
        }
        return mInstance;
    }

    public void createLoginSession(StudentsItem studentsItem){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_ID, String.valueOf(studentsItem.getId()));
        editor.putString(KEY_NAME, studentsItem.getName());
        editor.putString(KEY_SURNAME, studentsItem.getSurname());
        editor.putString(KEY_PHOTO,studentsItem.getPhoto());
        editor.putString(KEY_PHONE_NUMBER, studentsItem.getPhoneNumber());
        editor.putString(KEY_DATE,studentsItem.getDate());
        editor.putString(KEY_RESON,studentsItem.getReason());
        editor.putString(KEY_STATUS,studentsItem.getStatus());
        editor.putString(KEY_GAME,studentsItem.getGame());
        editor.putString(KEY_SHOW_PHONE,studentsItem.getShowPhone());
        editor.putString(KEY_EXAMEN_ACCESS,studentsItem.getExamenAccess());
        editor.putString(KEY_DESORIPTION,studentsItem.getDescription());
        editor.putString(KEY_TYPE, (String) studentsItem.getType());
        editor.putString(KEY_LOGIn, studentsItem.getLogin());
        editor.putString(KEY_IS_PLAYING_GAME, studentsItem.getIsPlayingGame());
        editor.putString(KEY_SCORE, studentsItem.getScore());
        editor.putString(KEY_GUMAR, (String) studentsItem.getGumar());
        editor.putString(KEY_PASSWORD, studentsItem.getPassword());
        editor.putString(KEY_PAYMANAGRI_SKIZB, studentsItem.getPaymanagriSkizb());
        editor.putString(KEY_AVG, studentsItem.getAvg());
        editor.putString(KEY_LESSON_RATE, studentsItem.getLessonRate());
        editor.putString(KEY_KURS, (String) studentsItem.getKurs());
        editor.putString(KEY_EMAIL, studentsItem.getEmail());
        editor.putString(KEY_CODE_TASK_LEVEL, studentsItem.getCodeTaskLevel());
        editor.putString(KEY_PREFERS, studentsItem.getPrefers());
        editor.putString(KEY_CURRENT_PAYMENT, studentsItem.getCurrentPayment());
        editor.putString(KEY_SEX, studentsItem.getSex());
        editor.putString(KEY_CODE_LEVEl, studentsItem.getCodeLevel());
        editor.putString(KEY_ARTIFICIAL_RATE, studentsItem.getArtificialRate());
        editor.putString(KEY_GAME_ACTIVITY, studentsItem.getGameActivity());
        editor.putString(KEY_LEVEL_NAME, studentsItem.getLevelName());
        editor.putString(KEY_ZEXCH, (String) studentsItem.getZexch());
        editor.putString(KEY_GROUP_ID, studentsItem.getGroupId());

        editor.putString(KEY_RELEASE_DATE, (String) studentsItem.getReleaseDate());
        editor.putString(KEY_ONLINE, studentsItem.getOnline());
        editor.putString(KEY_PAYMANAGRT_AVART, studentsItem.getOnline());
        editor.putString(KEY_SHOW_TESTS, studentsItem.getShowTests());
        editor.commit();
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_ID, pref.getString(KEY_ID, null));
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_SURNAME, pref.getString(KEY_SURNAME, null));
        user.put(KEY_PHOTO, pref.getString(KEY_PHOTO, null));
        user.put(KEY_PHONE_NUMBER, pref.getString(KEY_PHONE_NUMBER, null));
        user.put(KEY_DATE, pref.getString(KEY_DATE, null));
        user.put(KEY_RESON,pref.getString(KEY_RESON,null));
        user.put(KEY_STATUS,pref.getString(KEY_STATUS,null));
        user.put(KEY_GAME,pref.getString(KEY_GAME,null));
        user.put(KEY_SHOW_PHONE,pref.getString(KEY_SHOW_PHONE,null));
        user.put(KEY_EXAMEN_ACCESS,pref.getString(KEY_EXAMEN_ACCESS,null));
        user.put(KEY_DESORIPTION,pref.getString(KEY_DESORIPTION,null));
        user.put(KEY_TYPE,pref.getString(KEY_TYPE,null));
        user.put(KEY_LOGIn,pref.getString(KEY_LOGIn,null));
        user.put(KEY_IS_PLAYING_GAME,pref.getString(KEY_IS_PLAYING_GAME,null));
        user.put(KEY_SCORE,pref.getString(KEY_SCORE,null));
        user.put(KEY_GUMAR,pref.getString(KEY_GUMAR,null));
        user.put(KEY_PASSWORD,pref.getString(KEY_PASSWORD,null));
        user.put(KEY_PAYMANAGRI_SKIZB,pref.getString(KEY_PAYMANAGRI_SKIZB,null));
        user.put(KEY_AVG,pref.getString(KEY_AVG,null));
        user.put(KEY_LESSON_RATE,pref.getString(KEY_LESSON_RATE,null));
        user.put(KEY_KURS,pref.getString(KEY_KURS,null));
        user.put(KEY_EMAIL,pref.getString(KEY_EMAIL,null));
        user.put(KEY_CODE_TASK_LEVEL,pref.getString(KEY_CODE_TASK_LEVEL,null));
        user.put(KEY_PREFERS,pref.getString(KEY_PREFERS,null));
        user.put(KEY_CURRENT_PAYMENT,pref.getString(KEY_CURRENT_PAYMENT,null));
        user.put(KEY_SEX,pref.getString(KEY_SEX,null));
        user.put(KEY_CODE_LEVEl,pref.getString(KEY_CODE_LEVEl,null));
        user.put(KEY_ARTIFICIAL_RATE,pref.getString(KEY_ARTIFICIAL_RATE,null));
        user.put(KEY_GAME_ACTIVITY,pref.getString(KEY_GAME_ACTIVITY,null));
        user.put(KEY_LEVEL_NAME,pref.getString(KEY_LEVEL_NAME,null));
        user.put(KEY_ZEXCH,pref.getString(KEY_ZEXCH,null));
        user.put(KEY_GROUP_ID,pref.getString(KEY_GROUP_ID,null));
        user.put(KEY_ONLINE,pref.getString(KEY_ONLINE,null));
        user.put(KEY_RELEASE_DATE,pref.getString(KEY_RELEASE_DATE,null));
        user.put(KEY_PAYMANAGRT_AVART,pref.getString(KEY_PAYMANAGRT_AVART,null));
        user.put(KEY_SHOW_TESTS,pref.getString(KEY_SHOW_TESTS,null));
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