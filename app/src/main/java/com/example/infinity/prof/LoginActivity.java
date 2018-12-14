package com.example.infinity.prof;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.model.Response;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {

    private EditText mUserName, mPasswordView;
    private Button btnLogin;
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

        mUserName = (EditText) findViewById(R.id.textUserName);
        mPasswordView = (EditText) findViewById(R.id.textPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                requestLogin();
            }
        });

        mContext = this;
        mApiService = UtilsApi.getAPIService();
    }

    //emil-ekoyan1@profit.com
    //m-2v7m0**a5

    private void requestLogin() {
        mApiService.loginRequest(mUserName.getText().toString(), mPasswordView.getText().toString())
                .enqueue(new Callback<Response>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        response.body();
                        System.out.println(response.body());

                        if (response.body().getId() != 0) {
                            session.createResponseHandler(response.body());

                            Intent intent = new Intent(getApplicationContext(), StProfActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this, "Բարի գլուստ " + response.body().getName() + " "
                                    + response.body().getSurname(), Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(LoginActivity.this, "Sorry, User Name or Password wrong.\n try again...", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                    }
                });
    }

}