package com.example.infinity.prof;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.net.Uri;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.infinity.prof.fragment.HomeFragment;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.handler.SessionHandler;
import com.example.infinity.prof.model.Response;
import com.example.infinity.prof.model.StItem;
import com.example.infinity.prof.model.StudentsItem;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button web;
    private EditText mUserName;
    private EditText mPasswordView;
    private Button btnLogin;
    private View mProgressView;
    private View mLoginFormView;
    private RequestQueue mQueue;

    Context mContext;
    ApiService mApiService;
    ResponseHandler session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mQueue = Volley.newRequestQueue(this);
        session = new ResponseHandler(getApplicationContext());
        web = (Button) findViewById(R.id.web);
        web.setOnClickListener(this);

        mUserName = (EditText) findViewById(R.id.textUserName);
        mPasswordView = (EditText) findViewById(R.id.textPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                requestLogin();
            }

        });
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        mContext = this;
        mApiService = UtilsApi.getAPIService();
    }

    //raffi-minasyan@profit.com
    //c6159c32

    private void requestLogin() {
        mApiService.loginRequest(mUserName.getText().toString(), mPasswordView.getText().toString())
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        response.body();

                        System.out.println(mUserName.getText().toString());
                        System.out.println(mPasswordView.getText().toString());

                        if (response.body().getId() != 0) {
                            session.createResponseHandler(response.body());
                            System.out.println(session);

                            Intent intent = new Intent(getApplicationContext(), StProfActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this, "Բարի գլուստ " + response.body().getName() + " " + response.body().getSurname(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Sorry, User Name or Password wrong.\n try again...", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                    }
                });
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.profitdeco.com"));
                startActivity(intent);
                break;
        }
    }

}

//                    private void parseJsonData() {
//                        String baseUrl = "http://app.profitdeco.com/mobile/get?login=" + mUserName.getText().toString() + "&password=" + mPasswordView.getText().toString();
//                        System.out.println(baseUrl);
//
//                        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://app.profitdeco.com/student/dashboard", null,
//                                new com.android.volley.Response.Listener<JSONObject>() {
//
//                                    @Override
//                                    public void onResponse(JSONObject response) {
//                                        System.out.println(response);
//                                        System.out.println("start");
//                                        try {
//                                            JSONObject jsonArray = response.getJSONObject("");
//                                            String id = jsonArray.getString("id");
//                                            String name = jsonArray.getString("name");
//                                            String surname = jsonArray.getString("surname");
//                                            String paymanagriAvart = jsonArray.getString("paymanagri_avart");
//                                            String groupId = jsonArray.getString("group_id");
//                                            String zexch = jsonArray.getString("zexch");
//                                            String gumar = jsonArray.getString("gumar");
//                                            String status = jsonArray.getString("status");
//                                            String email = jsonArray.getString("email");
//                                            String phoneNumber = jsonArray.getString("phone_number");
//                                            String date = jsonArray.getString("date");
//                                            String description = jsonArray.getString("description");
//                                            String paymanagriSkizb = jsonArray.getString("paymanagri_skizb");
//                                            String reason = jsonArray.getString("reason");
//                                            String kurs = jsonArray.getString("kurs");
//                                            String type = jsonArray.getString("type");
//                                            String avg = jsonArray.getString("avg");
//                                            String login = jsonArray.getString("login");
//                                            String password = jsonArray.getString("password");
//                                            String photo = jsonArray.getString("photo");
//                                            String showPhone = jsonArray.getString("show_phone");
//                                            String prefers = jsonArray.getString("prefers");
//                                            String currentPayment = jsonArray.getString("current_payment");
//                                            String online = jsonArray.getString("online");
//                                            String releaseDate = jsonArray.getString("release_date");
//                                            String artificialRate = jsonArray.getString("artificial_rate");
//                                            String lessonRate = jsonArray.getString("lesson_rate");
//                                            String codeLevel = jsonArray.getString("code_level");
//                                            String codeTaskLevel = jsonArray.getString("code_task_level");
//                                            String levelName = jsonArray.getString("level_name");
//                                            String score = jsonArray.getString("score");
//                                            String showTests = jsonArray.getString("show_tests");
//                                            String game = jsonArray.getString("game");
//                                            String examenAccess = jsonArray.getString("examen_access");
//                                            String sex = jsonArray.getString("sex");
//                                            String gameActivity = jsonArray.getString("game_activity");
//                                            String isPlayingGame = jsonArray.getString("is_playing_game");
////                                JSONObject jsonAPI = jsonArray.getJSONObject("jsonapi");
//
//                                            JSONArray notifications = (JSONArray) jsonArray.get("notifications");
//
//                                            for (int i = 0; i < notifications.length(); i++) {
//
//                                                JSONObject childObject = notifications.getJSONObject(i);
//                                                String notId = childObject.getString("id");
//                                                String notStudentId = childObject.getString("student_id");
//                                                String notText = childObject.getString("text");
//                                                String notStatus = childObject.getString("status");
//                                                String notWhen = childObject.getString("when");
//
//                                            }
//
//                                            JSONArray grafik = (JSONArray) jsonArray.get("grafik");
//
//                                            for (int i = 0; i < grafik.length(); i++) {
//
//                                                JSONObject childObject = grafik.getJSONObject(i);
//                                                String grId = childObject.getString("id");
//                                                String grGroupId = childObject.getString("group_id");
//                                                String grDayId = childObject.getString("day_id");
//                                                String grStatus = childObject.getString("status");
//                                                String grEnd = childObject.getString("end");
//                                                String grTeacherId = childObject.getString("teacher_id");
//                                                String grActive = childObject.getString("active");
//                                                String grDay = childObject.getString("day");
//
//                                            }
//
//                                            JSONObject group = jsonArray.getJSONObject("group");
//                                            String groupIdG = group.getString("id");
//                                            String groupName = group.getString("name");
//                                            String groupPartId = group.getString("part_id");
//                                            String groupTeacherId = group.getString("teacher_id");
//                                            String groupColor = group.getString("color");
//                                            String groupLsaran_id = group.getString("lsaran_id");
//                                            String groupLevel = group.getString("level");
//                                            String groupActive = group.getString("active");
//                                            String groupModuleId = group.getString("module_id");
//
//                                            JSONArray students = (JSONArray) jsonArray.get("students");
//
//                                            for (int i = 0; i < students.length(); i++) {
//
//                                                JSONObject childObject = notifications.getJSONObject(i);
//                                                String idStudents = childObject.getString("id");
//                                                String nameStudents = childObject.getString("name");
//                                                String surnameStudents = childObject.getString("surname");
//                                                String paymanagriAvartStudents = childObject.getString("paymanagri_avart");
//                                                String groupIdStudents = childObject.getString("group_id");
//                                                String zexchStudents = childObject.getString("zexch");
//                                                String gumarStudents = childObject.getString("gumar");
//                                                String statusStudents = childObject.getString("status");
//                                                String emailStudents = childObject.getString("email");
//                                                String phoneNumberStudents = childObject.getString("phone_number");
//                                                String dateStudents = childObject.getString("date");
//                                                String descriptionStudents = childObject.getString("description");
//                                                String paymanagriSkizbStudents = childObject.getString("paymanagri_skizb");
//                                                String reasonStudents = childObject.getString("reason");
//                                                String kursStudents = childObject.getString("kurs");
//                                                String typeStudents = childObject.getString("type");
//                                                String avgStudents = childObject.getString("avg");
//                                                String loginStudents = childObject.getString("login");
//                                                String passwordStudents = childObject.getString("password");
//                                                String photoStudents = childObject.getString("photo");
//                                                String showPhoneStudents = childObject.getString("show_phone");
//                                                String prefersStudents = childObject.getString("prefers");
//                                                String currentPaymentStudents = childObject.getString("current_payment");
//                                                String onlineStudents = childObject.getString("online");
//                                                String releaseDateStudents = childObject.getString("release_date");
//                                                String artificialRateStudents = childObject.getString("artificial_rate");
//                                                String lessonRateStudents = childObject.getString("lesson_rate");
//                                                String codeLevelStudents = childObject.getString("code_level");
//                                                String codeTaskLevelStudents = childObject.getString("code_task_level");
//                                                String levelNameStudents = childObject.getString("level_name");
//                                                String scoreStudents = childObject.getString("score");
//                                                String showTestsStudents = childObject.getString("show_tests");
//                                                String gameStudents = childObject.getString("game");
//                                                String examenAccessStudents = childObject.getString("examen_access");
//                                                String sexStudents = childObject.getString("sex");
//                                                String gameActivityStudents = childObject.getString("game_activity");
//                                                String isPlayingGameStudents = childObject.getString("is_playing_game");
//
//                                            }
//
//                                            JSONObject teacher = jsonArray.getJSONObject("teacher");
//                                            String teacherId = group.getString("id");
//                                            String teacherName = group.getString("name");
//                                            String teacherSurname = group.getString("surname");
//                                            String teacherPhone = group.getString("phone");
//                                            String teacherPhoto = group.getString("photo");
//                                            String teacherAbout = group.getString("about");
//                                            String teacherRaiting = group.getString("raiting");
//                                            String teacherAvgStud = group.getString("avg_stud");
//                                            String teacherAvgListen = group.getString("avg_listen");
//                                            String teacherAvgProject = group.getString("avg_project");
//                                            String teacherAvgFlow = group.getString("avg_flow");
//                                            String teacherLevel = group.getString("level");
//                                            String teacherActive = group.getString("active");
//
//                                            JSONArray modules = (JSONArray) jsonArray.get("modules");
//
//                                            for (int i = 0; i < modules.length(); i++) {
//
//                                                JSONObject childObject = notifications.getJSONObject(i);
//                                                String modId = childObject.getString("id");
//                                                String modName = childObject.getString("name");
//                                                String modKurs = childObject.getString("kurs");
//                                                String modLessonsCount = childObject.getString("lessons_count");
//                                                String modAbout = childObject.getString("about");
//
//                                            }
//                                            System.out.println(name + " ," + surname);
////                                            JSONArray jsonArray = response.getJSONArray("notifications");
////                                            for (int i = 0; i < jsonArray.length(); i++) {
////
////                                                JSONObject childObject = jsonArray.getJSONObject(i);
////                                                String notId = childObject.getString("id");
////                                                String notStudentId = childObject.getString("student_id");
////                                                String notText = childObject.getString("text");
////                                                String notStatus = childObject.getString("status");
////                                                String notWhen = childObject.getString("when");
////
////                                                System.out.println( notId + ", " + notStatus + "  ," + notStudentId+ ", " + notText + " ," + notWhen);
////
////                                            }
//
//                                        } catch (JSONException e) {
//                                            e.printStackTrace();
//                                        }
//
//                                    }
//                                }, new com.android.volley.Response.ErrorListener() {
//
//                            @Override
//                            public void onErrorResponse(VolleyError volleyError) {
//                                System.out.println("end");
//                                NetworkResponse response = volleyError.networkResponse;
//                                if (volleyError instanceof ServerError && response != null) {
//                                    try {
//                                        String res = new String(response.data,
//                                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
//                                        // Now you can use any deserializer to make sense of data
//                                        JSONObject obj = new JSONObject(res);
//                                    } catch (UnsupportedEncodingException e1) {
//                                        // Couldn't properly decode data to string
//                                        e1.printStackTrace();
//                                    } catch (JSONException e2) {
//                                        // returned data is not JSONObject?
//                                        e2.printStackTrace();
//                                    }
//                                }
//                            }
//
//                        });
//                        mQueue.add(request);
//                        System.out.println(mQueue);
//                    }

//                    private void groaf() {
//                        mApiService.grafRequest()
//                                .enqueue(new Callback<GrafikItem>() {
//                                    @Override
//                                    public void onResponse(Call<GrafikItem> call, retrofit2.Response<GrafikItem> response) {
//                                        response.body();
//
//                                    }
//
//                                    @Override
//                                    public void onFailure(Call<GrafikItem> call, Throwable t) {
//
//                                    }
//                                });
//                    }





//                            int groupId = Integer.parseInt(response.body().getGroupId());
//
//                            List<GrafikItem> grafik = new ArrayList<>();
//                            int size = grafik.size();
//                            GrafikItem[] grafikItems = new GrafikItem[size];
//                            GrafikItem temp;
//                            System.out.println("?");
//                            System.out.println(grafik);
//                            System.out.println(groupId);
//                            for (int i=0;i<grafikItems.length;i++){
//                                if (grafikItems[i].getGroupId() == grafikItems[groupId].getGroupId()){
//                                    temp = grafikItems[i];
//                                    System.out.println("hello...");
//                                    System.out.println(temp.getActive());
//                                    System.out.println(temp.getStart());
//                                    System.out.println(temp.getDayId());
//                                    System.out.println(temp.getDay());
//                                    System.out.println(temp.getTeacherId());
//                                }
//                            }




//                            String baseUrl = "http://app.profitdeco.com/mobile/get?login=" + mUserName.getText().toString() + "&password=" + mPasswordView.getText().toString();
//                            System.out.println(baseUrl);

//                            parseJsonData();

//                            StringRequest request = new StringRequest(baseUrl, new com.android.volley.Response.Listener<String>() {
//                                @Override
//                                public void onResponse(String string) {
//                                    parseJsonData(string);
//                                }
//                            }, new com.android.volley.Response.ErrorListener() {
//                                @Override
//                                public void onErrorResponse(VolleyError volleyError) {
//                                    Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();
//                                }
//                            });


//                            try {
//                                JSONObject jsonArray = new JSONObject();
//                                jsonArray.put("name", studentsItem.getName());
//                                jsonArray.put("surname", studentsItem.getSurname());
//                                jsonArray.put("id", studentsItem.getId());
//                                jsonArray.put("photo", studentsItem.getPhoto());
//                                jsonArray.put("phone_number", studentsItem.getPhoneNumber());
//                                jsonArray.put("date", studentsItem.getDate());
//                                jsonArray.put("reason", studentsItem.getReason());
//                                jsonArray.put("status", studentsItem.getStatus());
//                                jsonArray.put("game",studentsItem.getGame());
//                                jsonArray.put("show_phone", studentsItem.getShowPhone());
//                                jsonArray.put("examen_access", studentsItem.getExamenAccess());
//                                jsonArray.put("description", studentsItem.getDescription());
//                                jsonArray.put("type", studentsItem.getType());
//                                jsonArray.put("login", studentsItem.getLogin());
//                                jsonArray.put("is_playing_game",studentsItem.getIsPlayingGame());
//                                jsonArray.put("score", studentsItem.getScore());
//                                jsonArray.put("gumar", studentsItem.getGumar());
//                                jsonArray.put("password", studentsItem.getPassword());
//                                jsonArray.put("paymanagri_skizb", studentsItem.getPaymanagriSkizb());
//                                jsonArray.put("avg", studentsItem.getAvg());
//                                jsonArray.put("lesson_rate", studentsItem.getLessonRate());
//                                jsonArray.put("kurs",  studentsItem.getKurs());
//                                jsonArray.put("email", studentsItem.getEmail());
//                                jsonArray.put("code_task_level", studentsItem.getCodeTaskLevel());
//                                jsonArray.put("prefers", studentsItem.getPrefers());
//                                jsonArray.put("current_payment", studentsItem.getCurrentPayment());
//                                jsonArray.put("sex", studentsItem.getSex());
//                                jsonArray.put("code_level", studentsItem.getCodeLevel());
//                                jsonArray.put("artificial_rate", studentsItem.getArtificialRate());
//                                jsonArray.put("game_activity", studentsItem.getGameActivity());
//                                jsonArray.put("level_name", studentsItem.getLevelName());
//                                jsonArray.put("zexch", studentsItem.getZexch());
//                                jsonArray.put("group_id", studentsItem.getGroupId());
//                                jsonArray.put("release_date", studentsItem.getReleaseDate());
//                                jsonArray.put("online", studentsItem.getOnline());
//                                jsonArray.put("paymanagri_avart", studentsItem.getOnline());
//                                jsonArray.put("show_tests", studentsItem.getShowTests());
//                                System.out.println(jsonArray);
////
////                                String id = jsonArray.getString("id");
////                                String name = jsonArray.getString("name");
////                                String surname = jsonArray.getString("surname");
////                                String paymanagriAvart = jsonArray.getString("paymanagri_avart");
////                                String groupId = jsonArray.getString("group_id");
////                                String zexch = jsonArray.getString("zexch");
////                                String gumar = jsonArray.getString("gumar");
////                                String status = jsonArray.getString("status");
////                                String email = jsonArray.getString("email");
////                                String phoneNumber = jsonArray.getString("phone_number");
////                                String date = jsonArray.getString("date");
////                                String description = jsonArray.getString("description");
////                                String paymanagriSkizb = jsonArray.getString("paymanagri_skizb");
////                                String reason = jsonArray.getString("reason");
////                                String kurs = jsonArray.getString("kurs");
////                                String type = jsonArray.getString("type");
////                                String avg = jsonArray.getString("avg");
////                                String login = jsonArray.getString("login");
////                                String password = jsonArray.getString("password");
////                                String photo = jsonArray.getString("photo");
////                                String showPhone = jsonArray.getString("show_phone");
////                                String prefers = jsonArray.getString("prefers");
////                                String currentPayment = jsonArray.getString("current_payment");
////                                String online = jsonArray.getString("online");
////                                String releaseDate = jsonArray.getString("release_date");
////                                String artificialRate = jsonArray.getString("artificial_rate");
////                                String lessonRate = jsonArray.getString("lesson_rate");
////                                String codeLevel = jsonArray.getString("code_level");
////                                String codeTaskLevel = jsonArray.getString("code_task_level");
////                                String levelName = jsonArray.getString("level_name");
////                                String score = jsonArray.getString("score");
////                                String showTests = jsonArray.getString("show_tests");
////                                String game = jsonArray.getString("game");
////                                String examenAccess = jsonArray.getString("examen_access");
////                                String sex = jsonArray.getString("sex");
////                                String gameActivity = jsonArray.getString("game_activity");
////                                String isPlayingGame = jsonArray.getString("is_playing_game");
//////                                JSONObject jsonAPI = jsonArray.getJSONObject("jsonapi");
////
////                                JSONArray notifications = (JSONArray) jsonArray.get("notifications");
////
////                                for (int i = 0; i < notifications.length(); i++) {
////
////                                    JSONObject childObject = notifications.getJSONObject(i);
////                                    String notId = childObject.getString("id");
////                                    String notStudentId = childObject.getString("student_id");
////                                    String notText = childObject.getString("text");
////                                    String notStatus = childObject.getString("status");
////                                    String notWhen = childObject.getString("when");
////
////                                }
////
////                                JSONArray grafik = (JSONArray) jsonArray.get("grafik");
////
////                                for (int i = 0; i < grafik.length(); i++) {
////
////                                    JSONObject childObject = grafik.getJSONObject(i);
////                                    String grId = childObject.getString("id");
////                                    String grGroupId = childObject.getString("group_id");
////                                    String grDayId = childObject.getString("day_id");
////                                    String grStatus = childObject.getString("status");
////                                    String grEnd = childObject.getString("end");
////                                    String grTeacherId = childObject.getString("teacher_id");
////                                    String grActive = childObject.getString("active");
////                                    String grDay = childObject.getString("day");
////
////                                }
////
////                                JSONObject group = jsonArray.getJSONObject("group");
////                                String groupIdG = group.getString("id");
////                                String groupName = group.getString("name");
////                                String groupPartId = group.getString("part_id");
////                                String groupTeacherId = group.getString("teacher_id");
////                                String groupColor = group.getString("color");
////                                String groupLsaran_id = group.getString("lsaran_id");
////                                String groupLevel = group.getString("level");
////                                String groupActive= group.getString("active");
////                                String groupModuleId = group.getString("module_id");
////
////                                JSONArray students = (JSONArray) jsonArray.get("students");
////
////                                for (int i = 0; i < students.length(); i++) {
////
////                                    JSONObject childObject = notifications.getJSONObject(i);
////                                    String idStudents = childObject.getString("id");
////                                    String nameStudents = childObject.getString("name");
////                                    String surnameStudents = childObject.getString("surname");
////                                    String paymanagriAvartStudents = childObject.getString("paymanagri_avart");
////                                    String groupIdStudents = childObject.getString("group_id");
////                                    String zexchStudents = childObject.getString("zexch");
////                                    String gumarStudents = childObject.getString("gumar");
////                                    String statusStudents = childObject.getString("status");
////                                    String emailStudents = childObject.getString("email");
////                                    String phoneNumberStudents = childObject.getString("phone_number");
////                                    String dateStudents = childObject.getString("date");
////                                    String descriptionStudents = childObject.getString("description");
////                                    String paymanagriSkizbStudents = childObject.getString("paymanagri_skizb");
////                                    String reasonStudents = childObject.getString("reason");
////                                    String kursStudents = childObject.getString("kurs");
////                                    String typeStudents = childObject.getString("type");
////                                    String avgStudents = childObject.getString("avg");
////                                    String loginStudents = childObject.getString("login");
////                                    String passwordStudents = childObject.getString("password");
////                                    String photoStudents = childObject.getString("photo");
////                                    String showPhoneStudents = childObject.getString("show_phone");
////                                    String prefersStudents = childObject.getString("prefers");
////                                    String currentPaymentStudents = childObject.getString("current_payment");
////                                    String onlineStudents = childObject.getString("online");
////                                    String releaseDateStudents = childObject.getString("release_date");
////                                    String artificialRateStudents = childObject.getString("artificial_rate");
////                                    String lessonRateStudents = childObject.getString("lesson_rate");
////                                    String codeLevelStudents = childObject.getString("code_level");
////                                    String codeTaskLevelStudents = childObject.getString("code_task_level");
////                                    String levelNameStudents = childObject.getString("level_name");
////                                    String scoreStudents = childObject.getString("score");
////                                    String showTestsStudents = childObject.getString("show_tests");
////                                    String gameStudents = childObject.getString("game");
////                                    String examenAccessStudents = childObject.getString("examen_access");
////                                    String sexStudents = childObject.getString("sex");
////                                    String gameActivityStudents = childObject.getString("game_activity");
////                                    String isPlayingGameStudents = childObject.getString("is_playing_game");
////
////                                }
////
////                                JSONObject teacher = jsonArray.getJSONObject("teacher");
////                                String teacherId = group.getString("id");
////                                String teacherName = group.getString("name");
////                                String teacherSurname = group.getString("surname");
////                                String teacherPhone = group.getString("phone");
////                                String teacherPhoto = group.getString("photo");
////                                String teacherAbout = group.getString("about");
////                                String teacherRaiting = group.getString("raiting");
////                                String teacherAvgStud= group.getString("avg_stud");
////                                String teacherAvgListen= group.getString("avg_listen");
////                                String teacherAvgProject= group.getString("avg_project");
////                                String teacherAvgFlow= group.getString("avg_flow");
////                                String teacherLevel = group.getString("level");
////                                String teacherActive = group.getString("active");
////
////                                JSONArray modules = (JSONArray) jsonArray.get("modules");
////
////                                for (int i = 0; i < modules.length(); i++) {
////
////                                    JSONObject childObject = notifications.getJSONObject(i);
////                                    String modId = childObject.getString("id");
////                                    String modName = childObject.getString("name");
////                                    String modKurs = childObject.getString("kurs");
////                                    String modLessonsCount = childObject.getString("lessons_count");
////                                    String modAbout = childObject.getString("about");
////
////                                }
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//


//                            try {
//                                JSONObject jsonObject = new JSONObject(urlJsonArry);
//                                System.out.println(jsonObject);
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }


//                            mApiService.grafRequest(mUserName.getText().toString(), mPasswordView.getText().toString()).enqueue(new Callback<GrafikItem>() {
//                                @Override
//                                public void onResponse(Call<GrafikItem> call, Response<GrafikItem> responses) {
//                                    responses.body();
//                                    System.out.println(responses.body());
//
//                                }
//
//                                @Override
//                                public void onFailure(Call<GrafikItem> call, Throwable t) {
//
//                                }
//                            });
//                            List<GrafikItem> grafikItems = new ArrayList<>();
//                            Class<? extends List> grItems = grafikItems.getClass();
//                            System.out.println(grItems);

//                            groaf();
//                            grafikItemHandler.createStHandler(response.body());


//
//    private void parseJsonData(String jsonString) {
//        try {
//            JSONObject object = new JSONObject(jsonString);
//            JSONArray fruitsArray = object.getJSONArray("fruits");
//            ArrayList al = new ArrayList();
//
//            for(int i = 0; i < fruitsArray.length(); ++i) {
//                al.add(fruitsArray.getString(i));
//            }
//
//            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
//            System.out.println(adapter);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }
