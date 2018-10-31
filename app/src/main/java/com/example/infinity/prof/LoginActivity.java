package com.example.infinity.prof;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
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
import com.example.infinity.prof.fragment.NotificationOne;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.handler.SessionHandler;
import com.example.infinity.prof.model.Response;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;
import com.github.arturogutierrez.Badges;
import com.github.arturogutierrez.BadgesNotSupportedException;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private NotificationManager myNotificationManager;
    private int notificationIdOne = 111;
    private int numMessagesOne = 0;

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
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                requestLogin();
//                displayNotificationOne();
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
        NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(this);
        mApiService.loginRequest(mUserName.getText().toString(), mPasswordView.getText().toString())
                .enqueue(new Callback<Response>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
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
                            for (int i = 0;i<response.body().getNotifications().size();i++) {
                                String nId = String.valueOf(response.body().getNotifications().get(i).getId());
                                String nStId = response.body().getNotifications().get(i).getStudentId();
                                String nText = response.body().getNotifications().get(i).getText();
                                String nStatus = response.body().getNotifications().get(i).getStatus();
                                String nWhen = response.body().getNotifications().get(i).getWhen();

                                mBuilder.setContentTitle("New Message profit");
                                mBuilder.setContentText(nText);
                                mBuilder.setTicker("Explicit: New Message Received!");
                                mBuilder.setSmallIcon(android.R.drawable.ic_dialog_email);

                                mBuilder.setNumber(++numMessagesOne);

                                Intent resultIntent = new Intent(LoginActivity.this, StProfActivity.class);
                                resultIntent.putExtra("notificationId", nText);

                                TaskStackBuilder stackBuilder = TaskStackBuilder.create(LoginActivity.this);

                                stackBuilder.addParentStack(NotificationOne.class);

                                stackBuilder.addNextIntent(resultIntent);
                                PendingIntent resultPendingIntent =
                                        stackBuilder.getPendingIntent(
                                                0,
                                                PendingIntent.FLAG_ONE_SHOT //can only be used once
                                        );
                                mBuilder.setContentIntent(resultPendingIntent);

                                myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                myNotificationManager.notify(i, mBuilder.build());
                            }

                        } else {
                            Toast.makeText(LoginActivity.this, "Sorry, User Name or Password wrong.\n try again...", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                    }
                });
    }
    public void notCount(View view){
        try{

            mApiService = UtilsApi.getAPIService();

            session = new ResponseHandler(getApplicationContext());
            session.checkLogin();

            HashMap<String, String> user = session.getResponseDetails();

            String notCount = user.get(ResponseHandler.NOTIFICATION_TEXT);
            String[] nCount = notCount.split(";");
            int sun = 0;
            for (int i =0;i< nCount.length;i++){
                sun ++;
            }
            Badges.setBadge(LoginActivity.this,10);
        }catch (BadgesNotSupportedException error){

        }
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
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//    protected void displayNotificationOne() {
//
//        // Invoking the default notification service
//        NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(this);
//
//
//        mBuilder.setContentTitle("New Message profit");
//        mBuilder.setContentText("New message from javacodegeeks received");
//        mBuilder.setTicker("Explicit: New Message Received!");
//        mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
//
//        // Increase notification number every time a new notification arrives
//        mBuilder.setNumber(++numMessagesOne);
//
//        // Creates an explicit intent for an Activity in your app
//        Intent resultIntent = new Intent(this, NotificationOne.class);
//        resultIntent.putExtra("notificationId", notificationIdOne);
//
//        //This ensures that navigating backward from the Activity leads out of the app to Home page
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//
//        // Adds the back stack for the Intent
//        stackBuilder.addParentStack(NotificationOne.class);
//
//        // Adds the Intent that starts the Activity to the top of the stack
//        stackBuilder.addNextIntent(resultIntent);
//        PendingIntent resultPendingIntent =
//                stackBuilder.getPendingIntent(
//                        0,
//                        PendingIntent.FLAG_ONE_SHOT //can only be used once
//                );
//        // start the activity when the user clicks the notification text
//        mBuilder.setContentIntent(resultPendingIntent);
//
//        myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        // pass the Notification object to the system
//        myNotificationManager.notify(notificationIdOne, mBuilder.build());
//    }
}

