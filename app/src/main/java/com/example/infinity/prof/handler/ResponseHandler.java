package com.example.infinity.prof.handler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.infinity.prof.LoginActivity;
import com.example.infinity.prof.model.Response;

import java.util.ArrayList;
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
    private static final String IS_LOGIN_BODY = "body";

    //    Response data
    public static final String RESPONSE_GROUP_ID = "groupId";
    public static final String RESPONSE_ID = "id";
    public static final String RESPONSE_DATE = "date";
    public static final String RESPONSE_REASON = "reason";
    public static final String RESPONSE_GAME = "game";
    public static final String RESPONSE_GRAFIK = "grafik";
    public static final String RESPONSE_SHOW_PHONE = "showPhone";
    public static final String RESPONSE_EXAMEN_ACCESS = "examenAccess";
    public static final String RESPONSE_DESCRIPTION = "description";
    public static final String RESPONSE_TYPE = "type";
    public static final String RESPONSE_LOGIN = "login";
    public static final String RESPONSE_IS_PLAYING_GAME = "isPlayingGame";
    public static final String RESPONSE_SCORE = "score";
    public static final String RESPONSE_GUMAR = "gumar";
    public static final String RESPONSE_PASSWORD = "password";
    public static final String RESPONSE_PAYMANAGRI_SKIZB = "paymanagriSkizb";
    public static final String RESPONSE_AVG = "avg";
    public static final String RESPONSE_TEACHER = "teacher";
    public static final String RESPONSE_LESSON_RATE = "lessonRate";
    public static final String RESPONSE_SURNAME = "surname";
    public static final String RESPONSE_KURS = "kurs";
    public static final String RESPONSE_EMAIL = "email";
    public static final String RESPONSE_GROUP = "group";
    public static final String RESPONSE_CODE_TASK_LEVEL = "codeTaskLevel";
    public static final String RESPONSE_PREFERS = "prefers";
    public static final String RESPONSE_CURRENT_PAYMENT = "currentPayment";
    public static final String RESPONSE_SEX = "sex";
    public static final String RESPONSE_PHOTO = "photo";
    public static final String RESPONSE_CODE_LEVEL = "codeLevel";
    public static final String RESPONSE_ARTIFICIAL_RATE = "artificialRate";
    public static final String RESPONSE_GAME_ACTIVITY = "gameActivity";
    public static final String RESPONSE_MODULES = "modules";
    public static final String RESPONSE_LEVEL_NAME = "levelName";
    public static final String RESPONSE_ZEXCH = "zexch";
    public static final String RESPONSE_RELEASE_DATE = "releaseDate";
    public static final String RESPONSE_NAME = "name";
    public static final String RESPONSE_ONLINE = "online";
    public static final String RESPONSE_PHONE_NUMBER = "phoneNumber";
    public static final String RESPONSE_PAYMANAGRI_AVART = "paymanagriAvart";
    public static final String RESPONSE_SHOW_TESTS = "showTests";
    public static final String RESPONSE_NOTIFICATIONS = "notifications";
    public static final String RESPONSE_STATUS = "status";

    //  Grafik data
    public static String GRAFIK_GROUP_ID = "groupIdGrafik";
    public static String GRAFIK_TEACHER_ID = "teacherIdGrafik";
    public static String GRAFIK_START = "startGrafik";
    public static String GRAFIK_ACTIVE = "activeGrafik";
    public static String GRAFIK_END = "endGrafik";
    public static String GRAFIK_ID = "idGrafik";
    public static String GRAFIK_DAY_ID = "dayIdGrafik";
    public static String GRAFIK_DAY = "dayGrafik";

    //  Teacher data
    public static final String TEACHER_ID = "idTeacher";
    public static final String TEACHER_RATING = "raitingTeacher";
    public static final String TEACHER_AVG_FLOW = "avgFlowTeacher";
    public static final String TEACHER_AVG_LISTEN = "avgListenTeacher";
    public static final String TEACHER_LEVEL = "levelTeacher";
    public static final String TEACHER_PROJECT = "avgProjectTeacher";
    public static final String TEACHER_ABOUT = "aboutTeacher";
    public static final String TEACHER_ACTIVE = "activeTeacher";
    public static final String TEACHER_PHONE = "phoneTeacher";
    public static final String TEACHER_AVG_STUD = "avgStudTeacher";
    public static final String TEACHER_SURNAME = "surnameTeacher";
    public static final String TEACHER_PHOTO = "photoTeacher";
    public static final String TEACHER_NAME = "nameTeacher";

    // Group data
    public static final String GROUP_ID = "idGroup";
    public static final String GROUP_LSAEAN_ID = "lsaranId";
    public static final String GROUP_MODULE_ID = "moduleId";
    public static final String GROUP_COLOR = "color";
    public static final String GROUP_LEVEL = "level";
    public static final String GROUP_TEACHER_ID= "teacherId";
    public static final String GROUP_GNAME= "gname";
    public static final String GROUP_ACTIVE= "active";
    public static final String GROUP_PART_ID= "partId";

    // Group student data
    public static final String GROUP_STUDENTS= "students";
    public static final String GROUP_STUDENTS_NAME= "studentsName";
    public static final String GROUP_STUDENTS_SURNAME= "studentSurname";
    public static final String GROUP_STUDENTS_RATING= "studentsRating";
    public static final String GROUP_STUDENTS_IMG= "studentsImg";

    //Notification data
    public static final String NOTIFICATION_ID = "idNot";
    public static final String NOTIFICATION_STUDENT_ID = "studentIdNot";
    public static final String NOTIFICATION_TEXT= "textNot";
    public static final String NOTIFICATION_WHEN = "whenNot";
    public static final String NOTIFICATION_STATUS = "statusNot";

    //Modules data
    public static final String MODULES_ID = "idModules";
    public static final String MODULES_KURS = "kursModules";
    public static final String MODULES_ABOUT= "aboutModules";
    public static final String MODULES_LESSON_COUNT= "lessonCountModules";
    public static final String MODULES_NAME = "nameModules";

    public ResponseHandler(Context context) {
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

    public void createResponseHandler(Response response) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(RESPONSE_ID, String.valueOf(response.getId()));
        editor.putString(RESPONSE_GROUP_ID, response.getGroupId());
        editor.putString(RESPONSE_DATE, response.getDate());
        editor.putString(RESPONSE_REASON, response.getReason());
        editor.putString(RESPONSE_GAME, response.getGame());
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
        editor.putString(RESPONSE_GROUP, String.valueOf(response.getGroup()));
        editor.putString(RESPONSE_CODE_TASK_LEVEL, response.getCodeTaskLevel());
        editor.putString(RESPONSE_PREFERS, response.getPrefers());
        editor.putString(RESPONSE_CURRENT_PAYMENT, response.getCurrentPayment());
        editor.putString(RESPONSE_SEX, response.getSex());
        editor.putString(RESPONSE_PHOTO, response.getPhoto());
        editor.putString(RESPONSE_CODE_LEVEL, response.getCodeLevel());
        editor.putString(RESPONSE_ARTIFICIAL_RATE, response.getArtificialRate());
        editor.putString(RESPONSE_GAME_ACTIVITY, response.getGameActivity());
        editor.putString(RESPONSE_LEVEL_NAME, response.getLevelName());
        editor.putString(RESPONSE_RELEASE_DATE, String.valueOf(response.getReleaseDate()));
        editor.putString(RESPONSE_ZEXCH, String.valueOf(response.getZexch()));
        editor.putString(RESPONSE_NAME, response.getName());
        editor.putString(RESPONSE_ONLINE, response.getOnline());
        editor.putString(RESPONSE_PHONE_NUMBER, response.getPhoneNumber());
        editor.putString(RESPONSE_PAYMANAGRI_AVART, response.getPaymanagriAvart());
        editor.putString(RESPONSE_SHOW_TESTS, response.getShowTests());
        editor.putString(RESPONSE_STATUS, String.valueOf(response.getStatus()));

        // Group data
        editor.putString(RESPONSE_GRAFIK, String.valueOf(response.getGrafik()));

        String gId = "";
        String gGroupId="";
        String gDayId ="";
        String gDay = "";
        String gStart="";
        String gEnd = "";
        String gTeacherId ="";
        String gActive="";
        for (int i = 0; i < response.getGrafik().size(); i++) {
            String grafikId = String.valueOf(response.getGrafik().get(i).getId());
            String grafikGroupId = response.getGrafik().get(i).getGroupId();
            String grafikDayId = response.getGrafik().get(i).getDayId();
            String grafikDay = response.getGrafik().get(i).getDay();
            String grafikStart = response.getGrafik().get(i).getStart();
            String grafikEnd = response.getGrafik().get(i).getEnd();
            String grafikTeacherId = response.getGrafik().get(i).getTeacherId();
            String grafikActive = response.getGrafik().get(i).getTeacherId();

            gId = gId.concat(grafikId);
            gGroupId = gGroupId.concat(grafikGroupId);
            gDayId = gDayId.concat(grafikDayId);
            gDay = gDay.concat(grafikDay + ",");
            gStart = gStart.concat(grafikStart + "  - ,");
            gEnd = gEnd.concat(grafikEnd + ",");
            gTeacherId = gTeacherId.concat(grafikTeacherId);
            gActive = gActive.concat(grafikActive);
        }
        editor.putString(GRAFIK_DAY, gDay);
        editor.putString(GRAFIK_START,gStart);
        editor.putString(GRAFIK_END,gEnd);

        // Teacher data
        editor.putString(TEACHER_ID, String.valueOf(response.getTeacher().getId()));
        editor.putString(TEACHER_NAME, response.getTeacher().getName());
        editor.putString(TEACHER_SURNAME, response.getTeacher().getSurname());
        editor.putString(TEACHER_PHOTO, response.getTeacher().getPhoto());
        editor.putString(TEACHER_RATING, response.getTeacher().getRaiting());
        editor.putString(TEACHER_AVG_FLOW, response.getTeacher().getAvgFlow());
        editor.putString(TEACHER_AVG_LISTEN, response.getTeacher().getAvgListen());
        editor.putString(TEACHER_LEVEL, response.getTeacher().getLevel());
        editor.putString(TEACHER_PROJECT, response.getTeacher().getAvgProject());
        editor.putString(TEACHER_ABOUT, response.getTeacher().getAbout());
        editor.putString(TEACHER_ACTIVE, response.getTeacher().getActive());
        editor.putString(TEACHER_PHONE, response.getTeacher().getPhone());
        editor.putString(TEACHER_AVG_STUD, response.getTeacher().getAvgStud());

        // Group data
        editor.putString(GROUP_ID, String.valueOf(response.getGroup().getId()));
        editor.putString(GROUP_GNAME, response.getGroup().getName());
        editor.putString(GROUP_PART_ID, response.getGroup().getPartId());
        editor.putString(GROUP_COLOR,   response.getGroup().getColor());
        editor.putString(GROUP_LSAEAN_ID, (String) response.getGroup().getLsaranId());
        editor.putString(GROUP_LEVEL, (String) response.getGroup().getLevel());
        editor.putString(GROUP_ACTIVE,  response.getGroup().getActive());
        editor.putString(GROUP_MODULE_ID, response.getGroup().getModuleId());
        editor.putString(GROUP_TEACHER_ID, response.getGroup().getTeacherId());

        // Group student data
        editor.putString(GROUP_STUDENTS, String.valueOf(response.getGroup().getStudents()));

        String gStName = "";
        String gStSurname = "";
        String gStRating = "";
        String gStImg = "";
        for (int i = 0; i<response.getGroup().getStudents().size();i++){
            String gName = response.getGroup().getStudents().get(i).getName();
            String gSurname = response.getGroup().getStudents().get(i).getSurname();
            String gRating = response.getGroup().getStudents().get(i).getAvg();
            String gImg = response.getGroup().getStudents().get(i).getPhoto();

            gStName = gStName.concat(gName + ",");
            gStSurname = gStSurname.concat(gSurname + ",");
            gStRating = gStRating.concat(gRating + ",");
            gStImg = gStImg.concat(gImg + ",");
        }
        editor.putString(GROUP_STUDENTS_NAME,gStName);
        editor.putString(GROUP_STUDENTS_SURNAME,gStSurname);
        editor.putString(GROUP_STUDENTS_IMG,gStImg);
        editor.putString(GROUP_STUDENTS_RATING,gStRating);

        //Notification data
        editor.putString(RESPONSE_NOTIFICATIONS, String.valueOf(response.getNotifications()));

        String notId = "";
        String notStId ="";
        String notText ="";
        String notStatus ="";
        String notWhen ="";
        for (int i = 0;i<response.getNotifications().size();i++){
            String nId = String.valueOf(response.getNotifications().get(i).getId());
            String nStId =response.getNotifications().get(i).getStudentId();
            String nText =response.getNotifications().get(i).getText();
            String  nStatus =response.getNotifications().get(i).getStatus();
            String nWhen =response.getNotifications().get(i).getWhen();

            notId = notId.concat(nId + ",");
            notStId = notStId.concat(nStId + ",");
            notText=notText.concat(nText + ";");
            notStatus =notStatus.concat(nStatus + ",");
            notWhen= notWhen.concat(nWhen + ",");
        }
        editor.putString(NOTIFICATION_ID,notId);
        editor.putString(NOTIFICATION_STUDENT_ID,notStId);
        editor.putString(NOTIFICATION_TEXT,notText);
        editor.putString(NOTIFICATION_STATUS,notStatus);
        editor.putString(NOTIFICATION_WHEN,notWhen);

        //Modules data
        editor.putString(RESPONSE_MODULES, String.valueOf(response.getModules()));

        String modId = "";
        String modName = "";
        String modKurs = "";
        String modLessonsCount= "";
        String modAbout = "";
        for (int i =0;i< response.getModules().size();i++){
            String mId = String.valueOf(response.getModules().get(i).getId());
            String mName = response.getModules().get(i).getName();
            String mKurs = response.getModules().get(i).getKurs();
            String mLessonCount = response.getModules().get(i).getLessonsCount();
            String mAbout =response.getModules().get(i).getAbout();

            modId = modId.concat(mId+ ",");
            modName= modName.concat(mName + ",");
            modKurs= modKurs.concat(mKurs + ",");
            modLessonsCount = modLessonsCount.concat(mLessonCount + ",");
            modAbout=modAbout.concat(mAbout + ",");
        }

        editor.putString(MODULES_ID,modId);
        editor.putString(MODULES_NAME,modName);
        editor.putString(MODULES_KURS,modKurs);
        editor.putString(MODULES_LESSON_COUNT,modLessonsCount);
        editor.putString(MODULES_ABOUT,modAbout);

        this.editor.commit();
    }

    public HashMap<String, String> getResponseDetails() {
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

//      Teacher data
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

//      Grafik data
        user.put(GRAFIK_ID, pref.getString(GRAFIK_ID, null));
        user.put(GRAFIK_GROUP_ID, pref.getString(GRAFIK_GROUP_ID, null));
        user.put(GRAFIK_START, pref.getString(GRAFIK_START, null));
        user.put(GRAFIK_END, pref.getString(GRAFIK_END, null));
        user.put(GRAFIK_DAY_ID, pref.getString(GRAFIK_DAY_ID, null));
        user.put(GRAFIK_TEACHER_ID, pref.getString(GRAFIK_TEACHER_ID, null));
        user.put(GRAFIK_DAY, pref.getString(GRAFIK_DAY, null));
        user.put(GRAFIK_ACTIVE, pref.getString(GRAFIK_ACTIVE, null));

//      Group data
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

//      Group Student data
        user.put(GROUP_STUDENTS_NAME, pref.getString(GROUP_STUDENTS_NAME, null));
        user.put(GROUP_STUDENTS_SURNAME, pref.getString(GROUP_STUDENTS_SURNAME, null));
        user.put(GROUP_STUDENTS_IMG, pref.getString(GROUP_STUDENTS_IMG, null));
        user.put(GROUP_STUDENTS_RATING, pref.getString(GROUP_STUDENTS_RATING, null));

//      Notification data
        user.put(NOTIFICATION_ID, pref.getString(NOTIFICATION_ID, null));
        user.put(NOTIFICATION_WHEN, pref.getString(NOTIFICATION_WHEN, null));
        user.put(NOTIFICATION_STUDENT_ID, pref.getString(NOTIFICATION_STUDENT_ID, null));
        user.put(NOTIFICATION_TEXT, pref.getString(NOTIFICATION_TEXT, null));
        user.put(NOTIFICATION_STATUS, pref.getString(NOTIFICATION_STATUS, null));

//      Modules data
        user.put(MODULES_ID, pref.getString(MODULES_ID, null));
        user.put(MODULES_NAME, pref.getString(MODULES_NAME, null));
        user.put(MODULES_KURS, pref.getString(MODULES_KURS, null));
        user.put(MODULES_ABOUT, pref.getString(MODULES_ABOUT, null));
        user.put(MODULES_LESSON_COUNT, pref.getString(MODULES_LESSON_COUNT, null));

        return user;
    }

    public void checkLogin() {
        if (!this.isLoggedIn()) {
            Intent i = new Intent(_context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
}