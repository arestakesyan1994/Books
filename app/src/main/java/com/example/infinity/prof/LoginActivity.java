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

import com.example.infinity.prof.handler.GrafikItemHandler;
import com.example.infinity.prof.handler.SessionHandler;
import com.example.infinity.prof.model.GrafikItem;
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

    private void requestLogin() {
        mApiService.loginRequest(mUserName.getText().toString(), mPasswordView.getText().toString())
                .enqueue(new Callback<StudentsItem>() {
                    @Override
                    public void onResponse(Call<StudentsItem> call, retrofit2.Response<StudentsItem> response) {
                        response.body();
                        if (response.body().getId() != 0) {
                            session.createLoginSession(response.body());
                            groaf();
//                            grafikItemHandler.createStHandler(response.body());
                            Intent intent = new Intent(getApplicationContext(), StProfActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this, "Բարի գլուստ " + response.body().getName() + " " + response.body().getSurname(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Sorry, User Name or Password wrong.\n try again...", Toast.LENGTH_SHORT).show();
                        }
                    }

                    private void groaf() {
                        mApiService.grafRequest()
                                .enqueue(new Callback<GrafikItem>() {
                                    @Override
                                    public void onResponse(Call<GrafikItem> call, retrofit2.Response<GrafikItem> response) {
                                        response.body();

                                    }

                                    @Override
                                    public void onFailure(Call<GrafikItem> call, Throwable t) {

                                    }
                                });
                    }

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