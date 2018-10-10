package com.example.infinity.prof.handler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.infinity.prof.LoginActivity;
import com.example.infinity.prof.model.ModulesItem;

import java.util.HashMap;

public class ModulesItemHandler {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private static Context _context;
    private static ModulesItemHandler mInstance;


    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserSession";
    private static final String MODULES_EXPIRES = "expires";
    private static final String MODULES_EMPTY = "";
    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String MODULES_ID = "id";
    public static final String MODULES_KURS = "kurs";
    public static final String MODULES_ABOUT= "about";
    public static final String MODULES_NAME = "name";


    public ModulesItemHandler(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public static synchronized ModulesItemHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ModulesItemHandler(context);
        }
        return mInstance;
    }

    public void createModulesSession(ModulesItem modules){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(MODULES_ID, String.valueOf(modules.getId()));
        editor.putString(MODULES_NAME, modules.getName());
        editor.putString(MODULES_KURS, modules.getKurs());
        editor.putString(MODULES_ABOUT,modules.getAbout());

        editor.commit();
    }

    public HashMap<String, String> getmodulesDetails(){
        HashMap<String, String> user = new HashMap<>();
        user.put(MODULES_ID, pref.getString(MODULES_ID, null));
        user.put(MODULES_NAME, pref.getString(MODULES_NAME, null));
        user.put(MODULES_KURS, pref.getString(MODULES_KURS, null));
        user.put(MODULES_ABOUT, pref.getString(MODULES_ABOUT, null));

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