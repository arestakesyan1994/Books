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

import com.android.volley.toolbox.JsonArrayRequest;
import com.example.infinity.prof.handler.GrafikItemHandler;
import com.example.infinity.prof.handler.SessionHandler;
import com.example.infinity.prof.model.GrafikItem;
import com.example.infinity.prof.model.StudentsItem;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;
import com.google.android.gms.common.util.JsonUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button web;
    private EditText mUserName;
    private EditText mPasswordView;
    private Button btnLogin;
    private View mProgressView;
    private View mLoginFormView;


    Context mContext;
    ApiService mApiService;
    SessionHandler session;
    GrafikItemHandler grafikItemHandler;
    StudentsItem studentsItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionHandler(getApplicationContext());
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
                .enqueue(new Callback<StudentsItem>() {
                    @Override
                    public void onResponse(Call<StudentsItem> call, retrofit2.Response<StudentsItem> response) {
                        response.body();
                        if (response.body().getId() != 0) {
                            session.createLoginSession(response.body());
                            System.out.println(response.body());
                            System.out.println(mApiService.loginRequest(mUserName.getText().toString(), mPasswordView.getText().toString()).toString());
                            System.out.println("http://app.profitdeco.com/mobile/get?login=" + mUserName.getText().toString() + "&password=" + mPasswordView.getText().toString());
                            String urlJsonArry = "http://app.profitdeco.com/mobile/get?login=" + mUserName.getText().toString() + "&password=" + mPasswordView.getText().toString();

                            try {
                                JSONObject mainObject = new JSONObject();
                                mainObject.put("name", studentsItem.getName());
                                mainObject.put("surname", studentsItem.getSurname());
                                mainObject.put("id", studentsItem.getId());
                                mainObject.put("photo", studentsItem.getPhoto());
                                mainObject.put("phone_number", studentsItem.getPhoneNumber());
                                mainObject.put("date", studentsItem.getDate());
                                mainObject.put("reason", studentsItem.getReason());
                                mainObject.put("status", studentsItem.getStatus());
                                mainObject.put("game",studentsItem.getGame());
                                mainObject.put("show_phone", studentsItem.getShowPhone());
                                mainObject.put("examen_access", studentsItem.getExamenAccess());
                                mainObject.put("description", studentsItem.getDescription());
                                mainObject.put("type", studentsItem.getType());
                                mainObject.put("login", studentsItem.getLogin());
                                mainObject.put("is_playing_game",studentsItem.getIsPlayingGame());
                                mainObject.put("score", studentsItem.getScore());
                                mainObject.put("gumar", studentsItem.getGumar());
                                mainObject.put("password", studentsItem.getPassword());
                                mainObject.put("paymanagri_skizb", studentsItem.getPaymanagriSkizb());
                                mainObject.put("avg", studentsItem.getAvg());
                                mainObject.put("lesson_rate", studentsItem.getLessonRate());
                                mainObject.put("kurs",  studentsItem.getKurs());
                                mainObject.put("email", studentsItem.getEmail());
                                mainObject.put("code_task_level", studentsItem.getCodeTaskLevel());
                                mainObject.put("prefers", studentsItem.getPrefers());
                                mainObject.put("current_payment", studentsItem.getCurrentPayment());
                                mainObject.put("sex", studentsItem.getSex());
                                mainObject.put("code_level", studentsItem.getCodeLevel());
                                mainObject.put("artificial_rate", studentsItem.getArtificialRate());
                                mainObject.put("game_activity", studentsItem.getGameActivity());
                                mainObject.put("level_name", studentsItem.getLevelName());
                                mainObject.put("zexch", studentsItem.getZexch());
                                mainObject.put("group_id", studentsItem.getGroupId());
                                mainObject.put("release_date", studentsItem.getReleaseDate());
                                mainObject.put("online", studentsItem.getOnline());
                                mainObject.put("paymanagri_avart", studentsItem.getOnline());
                                mainObject.put("show_tests", studentsItem.getShowTests());
                                System.out.println(mainObject);
//
//                                String id = mainObject.getString("id");
//                                String name = mainObject.getString("name");
//                                String surname = mainObject.getString("surname");
//                                String paymanagriAvart = mainObject.getString("paymanagri_avart");
//                                String groupId = mainObject.getString("group_id");
//                                String zexch = mainObject.getString("zexch");
//                                String gumar = mainObject.getString("gumar");
//                                String status = mainObject.getString("status");
//                                String email = mainObject.getString("email");
//                                String phoneNumber = mainObject.getString("phone_number");
//                                String date = mainObject.getString("date");
//                                String description = mainObject.getString("description");
//                                String paymanagriSkizb = mainObject.getString("paymanagri_skizb");
//                                String reason = mainObject.getString("reason");
//                                String kurs = mainObject.getString("kurs");
//                                String type = mainObject.getString("type");
//                                String avg = mainObject.getString("avg");
//                                String login = mainObject.getString("login");
//                                String password = mainObject.getString("password");
//                                String photo = mainObject.getString("photo");
//                                String showPhone = mainObject.getString("show_phone");
//                                String prefers = mainObject.getString("prefers");
//                                String currentPayment = mainObject.getString("current_payment");
//                                String online = mainObject.getString("online");
//                                String releaseDate = mainObject.getString("release_date");
//                                String artificialRate = mainObject.getString("artificial_rate");
//                                String lessonRate = mainObject.getString("lesson_rate");
//                                String codeLevel = mainObject.getString("code_level");
//                                String codeTaskLevel = mainObject.getString("code_task_level");
//                                String levelName = mainObject.getString("level_name");
//                                String score = mainObject.getString("score");
//                                String showTests = mainObject.getString("show_tests");
//                                String game = mainObject.getString("game");
//                                String examenAccess = mainObject.getString("examen_access");
//                                String sex = mainObject.getString("sex");
//                                String gameActivity = mainObject.getString("game_activity");
//                                String isPlayingGame = mainObject.getString("is_playing_game");
////                                JSONObject jsonAPI = mainObject.getJSONObject("jsonapi");
//
//                                JSONArray notifications = (JSONArray) mainObject.get("notifications");
//
//                                for (int i = 0; i < notifications.length(); i++) {
//
//                                    JSONObject childObject = notifications.getJSONObject(i);
//                                    String notId = childObject.getString("id");
//                                    String notStudentId = childObject.getString("student_id");
//                                    String notText = childObject.getString("text");
//                                    String notStatus = childObject.getString("status");
//                                    String notWhen = childObject.getString("when");
//
//                                }
//
//                                JSONArray grafik = (JSONArray) mainObject.get("grafik");
//
//                                for (int i = 0; i < grafik.length(); i++) {
//
//                                    JSONObject childObject = grafik.getJSONObject(i);
//                                    String grId = childObject.getString("id");
//                                    String grGroupId = childObject.getString("group_id");
//                                    String grDayId = childObject.getString("day_id");
//                                    String grStatus = childObject.getString("status");
//                                    String grEnd = childObject.getString("end");
//                                    String grTeacherId = childObject.getString("teacher_id");
//                                    String grActive = childObject.getString("active");
//                                    String grDay = childObject.getString("day");
//
//                                }
//
//                                JSONObject group = mainObject.getJSONObject("group");
//                                String groupIdG = group.getString("id");
//                                String groupName = group.getString("name");
//                                String groupPartId = group.getString("part_id");
//                                String groupTeacherId = group.getString("teacher_id");
//                                String groupColor = group.getString("color");
//                                String groupLsaran_id = group.getString("lsaran_id");
//                                String groupLevel = group.getString("level");
//                                String groupActive= group.getString("active");
//                                String groupModuleId = group.getString("module_id");
//
//                                JSONArray students = (JSONArray) mainObject.get("students");
//
//                                for (int i = 0; i < students.length(); i++) {
//
//                                    JSONObject childObject = notifications.getJSONObject(i);
//                                    String idStudents = childObject.getString("id");
//                                    String nameStudents = childObject.getString("name");
//                                    String surnameStudents = childObject.getString("surname");
//                                    String paymanagriAvartStudents = childObject.getString("paymanagri_avart");
//                                    String groupIdStudents = childObject.getString("group_id");
//                                    String zexchStudents = childObject.getString("zexch");
//                                    String gumarStudents = childObject.getString("gumar");
//                                    String statusStudents = childObject.getString("status");
//                                    String emailStudents = childObject.getString("email");
//                                    String phoneNumberStudents = childObject.getString("phone_number");
//                                    String dateStudents = childObject.getString("date");
//                                    String descriptionStudents = childObject.getString("description");
//                                    String paymanagriSkizbStudents = childObject.getString("paymanagri_skizb");
//                                    String reasonStudents = childObject.getString("reason");
//                                    String kursStudents = childObject.getString("kurs");
//                                    String typeStudents = childObject.getString("type");
//                                    String avgStudents = childObject.getString("avg");
//                                    String loginStudents = childObject.getString("login");
//                                    String passwordStudents = childObject.getString("password");
//                                    String photoStudents = childObject.getString("photo");
//                                    String showPhoneStudents = childObject.getString("show_phone");
//                                    String prefersStudents = childObject.getString("prefers");
//                                    String currentPaymentStudents = childObject.getString("current_payment");
//                                    String onlineStudents = childObject.getString("online");
//                                    String releaseDateStudents = childObject.getString("release_date");
//                                    String artificialRateStudents = childObject.getString("artificial_rate");
//                                    String lessonRateStudents = childObject.getString("lesson_rate");
//                                    String codeLevelStudents = childObject.getString("code_level");
//                                    String codeTaskLevelStudents = childObject.getString("code_task_level");
//                                    String levelNameStudents = childObject.getString("level_name");
//                                    String scoreStudents = childObject.getString("score");
//                                    String showTestsStudents = childObject.getString("show_tests");
//                                    String gameStudents = childObject.getString("game");
//                                    String examenAccessStudents = childObject.getString("examen_access");
//                                    String sexStudents = childObject.getString("sex");
//                                    String gameActivityStudents = childObject.getString("game_activity");
//                                    String isPlayingGameStudents = childObject.getString("is_playing_game");
//
//                                }
//
//                                JSONObject teacher = mainObject.getJSONObject("teacher");
//                                String teacherId = group.getString("id");
//                                String teacherName = group.getString("name");
//                                String teacherSurname = group.getString("surname");
//                                String teacherPhone = group.getString("phone");
//                                String teacherPhoto = group.getString("photo");
//                                String teacherAbout = group.getString("about");
//                                String teacherRaiting = group.getString("raiting");
//                                String teacherAvgStud= group.getString("avg_stud");
//                                String teacherAvgListen= group.getString("avg_listen");
//                                String teacherAvgProject= group.getString("avg_project");
//                                String teacherAvgFlow= group.getString("avg_flow");
//                                String teacherLevel = group.getString("level");
//                                String teacherActive = group.getString("active");
//
//                                JSONArray modules = (JSONArray) mainObject.get("modules");
//
//                                for (int i = 0; i < modules.length(); i++) {
//
//                                    JSONObject childObject = notifications.getJSONObject(i);
//                                    String modId = childObject.getString("id");
//                                    String modName = childObject.getString("name");
//                                    String modKurs = childObject.getString("kurs");
//                                    String modLessonsCount = childObject.getString("lessons_count");
//                                    String modAbout = childObject.getString("about");
//
//                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }



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
                            Intent intent = new Intent(getApplicationContext(), StProfActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this, "Բարի գլուստ " + response.body().getName() + " " + response.body().getSurname(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Sorry, User Name or Password wrong.\n try again...", Toast.LENGTH_SHORT).show();
                        }
                    }

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

                    @Override
                    public void onFailure(Call<StudentsItem> call, Throwable t) {
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