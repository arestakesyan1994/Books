package com.example.infinity.prof;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.infinity.prof.fragment.CodeBattleFragment;
import com.example.infinity.prof.fragment.FilerFragment;
import com.example.infinity.prof.fragment.HomeFragment;
import com.example.infinity.prof.fragment.KargavorumnerFragment;
import com.example.infinity.prof.fragment.ModuliGnahatumFragment;
import com.example.infinity.prof.fragment.QnnArdFragment;
import com.example.infinity.prof.fragment.QnnFragment;
import com.example.infinity.prof.fragment.TesakanFragment;
import com.example.infinity.prof.fragment.TesterFragment;
import com.example.infinity.prof.fragment.TnajinFragment;
import com.example.infinity.prof.fragment.VideoFragment;
import com.example.infinity.prof.handler.GroupHandler;
import com.example.infinity.prof.handler.SessionHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import java.util.HashMap;

public class StProfActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SessionHandler session;
    GroupHandler groups;
    TextView uRating, nAnds, mrcuyt, modul, xumb, nAndsA,uRatingA;
    ImageView userImage, userImageA;
    ApiService mApiService;
    private NavigationView navigationView;
    private View navHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_prof);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mApiService = UtilsApi.getAPIService();

        session = new SessionHandler(getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(SessionHandler.KEY_NAME);
        String surname = user.get(SessionHandler.KEY_SURNAME);
        String image = user.get(SessionHandler.KEY_PHOTO);
        String rating = user.get(SessionHandler.KEY_AVG);
        String kurs = user.get(SessionHandler.KEY_KURS);
        String groupSt = user.get(SessionHandler.KEY_GROUP_ID);

        ViewGroup contentView = (ViewGroup) findViewById(R.id.drawer_layout);
        contentView.setLayoutTransition(new LayoutTransition());

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navHeader = navigationView.getHeaderView(0);
        nAndsA = navHeader.findViewById(R.id.nAndsA);
        nAndsA.setText(name + " " + surname);

        uRatingA = navHeader.findViewById(R.id.uRatingA);
        uRatingA.setText("Ռեյտինգ " + rating + "%");

        userImageA = (ImageView) navHeader.findViewById(R.id.userImageA);
        Glide.with(this).load("http://app.profitdeco.com/img/students/" + image).into(userImageA);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new HomeFragment();
        displaySelectedFragment(fragment);
    }

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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.st_prof, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
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
