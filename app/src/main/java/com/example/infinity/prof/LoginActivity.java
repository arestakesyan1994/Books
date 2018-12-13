package com.example.infinity.prof;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
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
import com.github.arturogutierrez.Badges;
import com.github.arturogutierrez.BadgesNotSupportedException;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;

import static android.app.Notification.EXTRA_NOTIFICATION_ID;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String ACTION_SNOOZE = "action";
    private static final String CHANNEL_ID = "channel";
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

//                        System.out.println(mUserName.getText().toString());
//                        System.out.println(mPasswordView.getText().toString());

                        if (response.body().getId() != 0) {
                            session.createResponseHandler(response.body());
//                            System.out.println("http://app.profitdeco.com/mobile/get?login=" + mUserName.getText().toString()
//                                    +"&password=" +mPasswordView.getText().toString() );
//                            System.out.println(session);

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


    public void notCount(View view) {
        try {

            mApiService = UtilsApi.getAPIService();

            session = new ResponseHandler(getApplicationContext());
            session.checkLogin();

            HashMap<String, String> user = session.getResponseDetails();

            String notCount = user.get(ResponseHandler.NOTIFICATION_TEXT);
            String[] nCount = notCount.split(";");
            int sun = 0;
            for (int i = 0; i < nCount.length; i++) {
                sun++;
            }
            Badges.setBadge(LoginActivity.this, 10);
        } catch (BadgesNotSupportedException error) {

        }
    }

    @Override
    public void onClick(View v) {
    }
}