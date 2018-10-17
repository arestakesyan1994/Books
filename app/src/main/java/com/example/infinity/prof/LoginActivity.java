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
                                JSONObject mainObject = new JSONObject(urlJsonArry);
                                String id = mainObject.getString("id");
                                String name = mainObject.getString("name");
                                String surname = mainObject.getString("surname");
                                String paymanagri_avart = mainObject.getString("paymanagri_avart");
                                String group_id = mainObject.getString("group_id");
                                String zexch = mainObject.getString("zexch");
                                String gumar = mainObject.getString("gumar");
                                String status = mainObject.getString("status");
                                String email = mainObject.getString("email");
                                String phone_number = mainObject.getString("phone_number");
                                String date = mainObject.getString("date");
                                String description = mainObject.getString("description");
                                String paymanagri_skizb = mainObject.getString("paymanagri_skizb");
                                String reason = mainObject.getString("reason");
                                String kurs = mainObject.getString("kurs");
                                String type = mainObject.getString("type");
                                String avg = mainObject.getString("avg");
                                String login = mainObject.getString("login");
                                String password = mainObject.getString("password");
                                String photo = mainObject.getString("photo");
                                String show_phone = mainObject.getString("show_phone");
                                String prefers = mainObject.getString("prefers");
                                String current_payment = mainObject.getString("current_payment");
                                String online = mainObject.getString("online");
                                String release_date = mainObject.getString("release_date");
                                String artificial_rate = mainObject.getString("artificial_rate");
                                String lesson_rate = mainObject.getString("lesson_rate");
                                String code_level = mainObject.getString("code_level");
                                String code_task_level = mainObject.getString("code_task_level");
                                String level_name = mainObject.getString("level_name");
                                String score = mainObject.getString("score");
                                String show_tests = mainObject.getString("show_tests");
                                String game = mainObject.getString("game");
                                String examen_access = mainObject.getString("examen_access");
                                String sex = mainObject.getString("sex");
                                String game_activity = mainObject.getString("game_activity");
                                String is_playing_game = mainObject.getString("is_playing_game");
//                                JSONObject jsonAPI = mainObject.getJSONObject("jsonapi");
                                JSONArray notifications = (JSONArray) mainObject.get("notifications");

                                for (int i = 0; i < notifications.length(); i++) {

                                    JSONObject childObject = notifications.getJSONObject(i);
                                    String notId = childObject.getString("id");
                                    String notStudentId = childObject.getString("student_id");
                                    String notText = childObject.getString("text");
                                    String notStatus = childObject.getString("status");
                                    String notWhen = childObject.getString("when");

                                }
                                JSONArray grafik = (JSONArray) mainObject.get("grafik");

                                for (int i = 0; i < grafik.length(); i++) {

                                    JSONObject childObject = grafik.getJSONObject(i);
                                    String grId = childObject.getString("id");
                                    String grGroup_id = childObject.getString("group_id");
                                    String grDayId = childObject.getString("day_id");
                                    String grStatus = childObject.getString("status");
                                    String grEnd = childObject.getString("end");
                                    String grTeacherId = childObject.getString("teacher_id");
                                    String grActive = childObject.getString("active");
                                    String grDay = childObject.getString("day");

                                }
                                JSONObject group = mainObject.getJSONObject("group");
                                String groupId = group.getString("id");
                                String groupName = group.getString("name");
                                String groupPartId = group.getString("part_id");
                                String groupTeacherId = group.getString("teacher_id");
                                String groupColor = group.getString("color");
                                String groupLsaran_id = group.getString("lsaran_id");
                                String groupLevel = group.getString("level");
                                String groupActive= group.getString("active");
                                String groupModuleId = group.getString("module_id");
                                JSONArray students = (JSONArray) mainObject.get("students");

                                for (int i = 0; i < notifications.length(); i++) {

                                    JSONObject childObject = notifications.getJSONObject(i);
                                    String idStudents = childObject.getString("id");
                                    String nameStudents = childObject.getString("name");
                                    String surnameStudents = childObject.getString("surname");
                                    String paymanagriAvartStudents = childObject.getString("paymanagri_avart");
                                    String group_idStudents = childObject.getString("group_id");
                                    String zexchStudents = childObject.getString("zexch");
                                    String gumarStudents = childObject.getString("gumar");
                                    String statusStudents = childObject.getString("status");
                                    String emailStudents = childObject.getString("email");
                                    String phone_numberStudents = childObject.getString("phone_number");
                                    String dateStudents = childObject.getString("date");
                                    String descriptionStudents = childObject.getString("description");
                                    String paymanagri_skizbStudents = childObject.getString("paymanagri_skizb");
                                    String reasonStudents = childObject.getString("reason");
                                    String kursStudents = childObject.getString("kurs");
                                    String typeStudents = childObject.getString("type");
                                    String avgStudents = childObject.getString("avg");
                                    String loginStudents = childObject.getString("login");
                                    String passwordStudents = childObject.getString("password");
                                    String photoStudents = childObject.getString("photo");
                                    String show_phoneStudents = childObject.getString("show_phone");
                                    String prefersStudents = childObject.getString("prefers");
                                    String current_paymentStudents = childObject.getString("current_payment");
                                    String onlineStudents = childObject.getString("online");
                                    String release_dateStudents = childObject.getString("release_date");
                                    String artificial_rateStudents = childObject.getString("artificial_rate");
                                    String lesson_rateStudents = childObject.getString("lesson_rate");
                                    String code_levelStudents = childObject.getString("code_level");
                                    String code_task_levelStudents = childObject.getString("code_task_level");
                                    String level_nameStudents = childObject.getString("level_name");
                                    String scoreStudents = childObject.getString("score");
                                    String show_testsStudents = childObject.getString("show_tests");
                                    String gameStudents = childObject.getString("game");
                                    String examen_accessStudents = childObject.getString("examen_access");
                                    String sexStudents = childObject.getString("sex");
                                    String game_activityStudents = childObject.getString("game_activity");
                                    String is_playing_gameStudents = childObject.getString("is_playing_game");

                                }


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