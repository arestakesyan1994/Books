package com.example.infinity.prof;

import android.animation.LayoutTransition;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.infinity.prof.fragment.BooksFragment;
import com.example.infinity.prof.fragment.CodeBattleFragment;
import com.example.infinity.prof.fragment.FilerFragment;
import com.example.infinity.prof.fragment.HomeFragment;
import com.example.infinity.prof.fragment.KargavorumnerFragment;
import com.example.infinity.prof.fragment.ModuliGnahatumFragment;
import com.example.infinity.prof.fragment.NotificationOne;
import com.example.infinity.prof.fragment.QnnArdFragment;
import com.example.infinity.prof.fragment.QnnFragment;
import com.example.infinity.prof.fragment.TesakanFragment;
import com.example.infinity.prof.fragment.TesterFragment;
import com.example.infinity.prof.fragment.TnajinFragment;
import com.example.infinity.prof.fragment.VideoFragment;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.app.Notification.EXTRA_NOTIFICATION_ID;

public class StProfActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String ACTION_SNOOZE = "action";
    private static final String CHANNEL_ID = "channel";
    ResponseHandler session;
    TextView uRating, nAnds, mrcuyt, modul, xumb, nAndsA;
    TextView uRatingA, notification;
    ImageView userImageA, userImage;
    ApiService mApiService;
    private NavigationView navigationView;
    private View navHeader;
    final List<String> not = new ArrayList<String>();
    final List<String> date = new ArrayList<String>();
    final List<Integer> notId = new ArrayList<Integer>();

    Button button;
    ArrayList<HashMap<String, String>> contactList;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_prof);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mApiService = UtilsApi.getAPIService();

        session = new ResponseHandler(getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getResponseDetails();
        String name = user.get(ResponseHandler.RESPONSE_NAME);
        String surname = user.get(ResponseHandler.RESPONSE_SURNAME);
        String image = user.get(ResponseHandler.RESPONSE_PHOTO);
        String rating = user.get(ResponseHandler.RESPONSE_AVG);

        ViewGroup contentView = (ViewGroup) findViewById(R.id.drawer_layout);
        contentView.setLayoutTransition(new LayoutTransition());

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navHeader = navigationView.getHeaderView(0);
        nAndsA = navHeader.findViewById(R.id.nAndsA);
        nAndsA.setText(name + " " + surname);

//        this.mHandler = new Handler();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (session.isLoggedIn()) {
//                    mHandler.postDelayed(this, 5 * 1000);
//                    Toast.makeText(StProfActivity.this, "in runnable", Toast.LENGTH_SHORT).show();
//                }
//            }
//        },5*1000);

        uRatingA = navHeader.findViewById(R.id.uRatingA);
        uRatingA.setText("Ռեյտինգ " + rating + "%");

        userImageA = (ImageView) navHeader.findViewById(R.id.userImageA);
        Glide.with(this).load("http://app.profitdeco.com/img/students/" + image).into(userImageA);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new HomeFragment();
        displaySelectedFragment(fragment);

        String text = user.get(ResponseHandler.NOTIFICATION_TEXT);
        String[] notText = text.split("%");

        String when = user.get(ResponseHandler.NOTIFICATION_WHEN);
        String[] notWhen = when.split("%");

        for (int i = 0; i < notText.length; i++) {
            not.add(notText[i]);
        }
        for (int i = 0; i < notWhen.length; i++) {
            date.add(notWhen[i]);
        }

        for (int i = 0; i < not.size(); i++) {
            String nText = not.get(i);
            String nWhen = date.get(i);

            Intent intents = new Intent(StProfActivity.this, StProfActivity.class);
            intents.setAction(ACTION_SNOOZE);
            intents.putExtra(EXTRA_NOTIFICATION_ID, 0);
            PendingIntent snoozePendingIntent =
                    PendingIntent.getBroadcast(StProfActivity.this, 0, intents, 0);
            intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(StProfActivity.this, 0, intents, 0);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(StProfActivity.this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_notifications_icon)
                    .setContentTitle("New Message profit")
                    .setContentText(Html.fromHtml(nText))
                    .setColor(Color.rgb(150, 30, 250))
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(Html.fromHtml(nText) + "\n" + "\n" + nWhen))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setContentIntent(pendingIntent)
                    .setOnlyAlertOnce(true)
                    .setAutoCancel(true)
                    .addAction(R.drawable.ic_clear_black_24dp, "DELETE", snoozePendingIntent);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(StProfActivity.this);

            notId.add(i);
            notificationManager.notify(i, mBuilder.build());

        }
        System.out.println(notId);

    }
//    private final Runnable mRunnable= new Runnable() {
//        @Override
//        public void run() {
//            Toast.makeText(StProfActivity.this,"in runnable",Toast.LENGTH_SHORT).show();
//            StProfActivity.this.mHandler.postDelayed(mRunnable,5000);
//
////            HashMap<String, String> user = session.getResponseDetails();
////            String text = user.get(ResponseHandler.NOTIFICATION_TEXT);
////            String[] notText = text.split("%");
////
////            String when = user.get(ResponseHandler.NOTIFICATION_WHEN);
////            String[] notWhen = when.split("%");
////
////            for (int i = 0; i < notText.length; i++) {
////                not.add(notText[i]);
////            }
////
////            for (int i = 0; i < notWhen.length; i++) {
////                date.add(notWhen[i]);
////            }
////
////            for (int i = 0; i < not.size(); i++) {
////                String nText = not.get(i);
////                String nWhen = date.get(i);
////
////                Intent intents = new Intent(StProfActivity.this, StProfActivity.class);
////                intents.setAction(ACTION_SNOOZE);
////                intents.putExtra(EXTRA_NOTIFICATION_ID, 0);
////                PendingIntent snoozePendingIntent =
////                        PendingIntent.getBroadcast(StProfActivity.this, 0, intents, 0);
////                intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
////                PendingIntent pendingIntent = PendingIntent.getActivity(StProfActivity.this, 0, intents, 0);
////
////                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(StProfActivity.this, CHANNEL_ID)
////                        .setSmallIcon(R.drawable.ic_notifications_icon)
////                        .setContentTitle("New Message profit")
////                        .setContentText(Html.fromHtml(nText))
////                        .setColor(Color.rgb(150, 30, 250))
////                        .setStyle(new NotificationCompat.BigTextStyle()
////                                .bigText(Html.fromHtml(nText) + "\n" + "\n" + nWhen))
////                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
////                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
////                        .setContentIntent(pendingIntent)
////                        .setOnlyAlertOnce(true)
////                        .setAutoCancel(true)
////                        .addAction(R.drawable.ic_clear_black_24dp, "DELETE", snoozePendingIntent);
////
////                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(StProfActivity.this);
////                notificationManager.cancel(i);
////                for (int j=0;j<notId.size();j++) {
////                    if (i!=j) {
////                        notificationManager.notify(i, mBuilder.build());
////                    }
////                }
////            }
//
//        }
//    };


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.st_prof, menu);

        MenuItem not = menu.findItem(R.id.action_settings);
        notification = (TextView) MenuItemCompat.getActionView(not);
        initializaCountDrawer();

        return true;
    }

    private void initializaCountDrawer() {
        notification.setGravity(Gravity.LEFT);
        notification.setTypeface(null, Typeface.BOLD);
        mApiService = UtilsApi.getAPIService();

        session = new ResponseHandler(getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getResponseDetails();
        String count = user.get(ResponseHandler.NOTIFICATION_ID);
        System.out.println(count);
        if (Integer.parseInt(count) == 0) {
            notification.setTextColor(getResources().getColor(R.color.colornot));
            notification.setText("");
        } else {
            notification.setTextColor(getResources().getColor(R.color.colornot));
            notification.setText("+" + count);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        int id = item.getItemId();
        switch (id) {
            case R.id.action_setting:
                intent = new Intent(this, NotificationOne.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment;
        int id = item.getItemId();
        if (id == R.id.glxavor) {
            fragment = new HomeFragment();
            displaySelectedFragment(fragment);
            Toast.makeText(StProfActivity.this, "Գլխավոր էջ ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.CodeBattle) {
            fragment = new CodeBattleFragment();
            displaySelectedFragment(fragment);
            Toast.makeText(StProfActivity.this, "CodeBattle", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.dasagrqer) {
            fragment = new BooksFragment();
            displaySelectedFragment(fragment);
            Toast.makeText(StProfActivity.this, "Դասագրքեր", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.tnayin) {
            fragment = new TnajinFragment();
            displaySelectedFragment(fragment);
            Toast.makeText(StProfActivity.this, "Տնային աշխատանք ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.qnnutyanArd) {
            fragment = new QnnArdFragment();
            displaySelectedFragment(fragment);
            Toast.makeText(StProfActivity.this, "Քննության արդյունքներ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.qnnutyun) {
            fragment = new QnnFragment();
            displaySelectedFragment(fragment);
            Toast.makeText(StProfActivity.this, "Քննություն", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.tester) {
            fragment = new TesterFragment();
            displaySelectedFragment(fragment);
            Toast.makeText(StProfActivity.this, "Թեստեր", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.fayler) {
            fragment = new FilerFragment();
            Toast.makeText(StProfActivity.this, "Ֆայլեր", Toast.LENGTH_SHORT).show();
            displaySelectedFragment(fragment);
        } else if (id == R.id.kargavorumner) {
            fragment = new KargavorumnerFragment();
            displaySelectedFragment(fragment);
            Toast.makeText(StProfActivity.this, "Կարգավորումներ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.modul) {
            fragment = new ModuliGnahatumFragment();
            displaySelectedFragment(fragment);
            Toast.makeText(StProfActivity.this, "Մոդուլի գնահատում", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.videoDaser) {
            fragment = new VideoFragment();
            Toast.makeText(StProfActivity.this, "Վիդեո դասեր", Toast.LENGTH_SHORT).show();
            displaySelectedFragment(fragment);
        } else if (id == R.id.tesakanNyut) {
            fragment = new TesakanFragment();
            displaySelectedFragment(fragment);
            Toast.makeText(StProfActivity.this, "Տեսական նյութ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.logout) {
            session.logoutUser();
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(StProfActivity.this);
                notificationManager.cancelAll();
            startActivity(new Intent(StProfActivity.this, LoginActivity.class));
            Toast.makeText(StProfActivity.this, "LogOut ", Toast.LENGTH_SHORT).show();
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displaySelectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

}
