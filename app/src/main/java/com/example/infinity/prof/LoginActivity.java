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

                        System.out.println(mUserName.getText().toString());
                        System.out.println(mPasswordView.getText().toString());

                        if (response.body().getId() != 0) {
                            session.createResponseHandler(response.body());
                            System.out.println("http://app.profitdeco.com/mobile/get?login=" + mUserName.getText().toString()
                                    +"&password=" +mPasswordView.getText().toString() );
                            System.out.println(session);

                            Intent intent = new Intent(getApplicationContext(), StProfActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this, "Բարի գլուստ " + response.body().getName() + " "
                                    + response.body().getSurname(), Toast.LENGTH_SHORT).show();

                            //Notification
                            for (int i = 0; i < response.body().getNotifications().size(); i++) {
                                String nId = String.valueOf(response.body().getNotifications().get(i).getId());
                                String nStId = response.body().getNotifications().get(i).getStudentId();
                                String nText = response.body().getNotifications().get(i).getText();
                                String nStatus = response.body().getNotifications().get(i).getStatus();
                                String nWhen = response.body().getNotifications().get(i).getWhen();
                                String a =nText.replace("<b>"," ");
                                String a1 =a.replaceAll("<b>","");
                                String a2 = a1.replaceAll("</b>","");
                                String a3 = a2.replaceAll("</small>","");

                                long timeSec= Long.parseLong(nWhen);// Json output
                                int time = (int) (timeSec/10000);
                                int day = (int) time/86400;
                                int hoursTemp = (int) time - day*86400;
                                int hours = hoursTemp/ 3600;
                                int temp = (int) hoursTemp- hours * 3600;
                                int mins = temp / 60;
                                temp = temp - mins * 60;
                                int secs = temp;

                                String dataTime = day + " օր " +hours+ " ժամ "+ mins + " րոպե առաջ";

                                Intent intents = new Intent(LoginActivity.this, StProfActivity.class);
                                intents.setAction(ACTION_SNOOZE);
                                intents.putExtra(EXTRA_NOTIFICATION_ID, 0);
                                PendingIntent snoozePendingIntent =
                                        PendingIntent.getBroadcast(LoginActivity.this, 0, intents, 0);
                                intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                PendingIntent pendingIntent = PendingIntent.getActivity(LoginActivity.this, 0, intents, 0);

                                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(LoginActivity.this, CHANNEL_ID)
                                        .setSmallIcon(R.drawable.ic_notifications_icon)
                                        .setContentTitle("New Message profit")
                                        .setContentText(a3)
                                        .setColor(Color.rgb(150,30,250))
                                        .setStyle(new NotificationCompat.BigTextStyle()
                                                .bigText(a3 + "\n"+ "\n" + dataTime))
                                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                                        .setContentIntent(pendingIntent)
                                        .setOnlyAlertOnce(true)
                                        .setAutoCancel(true)
//                                        .addAction(R.drawable.alarmw, getString(R.string.snooze),
//                                                snoozePendingIntent);
//                                .addAction(R.drawable.alarmw, "Notification", snoozePendingIntent)
                                        ;

                                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(LoginActivity.this);

                                notificationManager.notify(i, mBuilder.build());
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