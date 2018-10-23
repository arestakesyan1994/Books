package com.example.infinity.prof;

import android.animation.LayoutTransition;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.infinity.prof.fragment.BooksFragment;
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
import com.example.infinity.prof.handler.HttpHandler;
import com.example.infinity.prof.handler.SessionHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class StProfActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SessionHandler session;
    TextView uRating, nAnds, mrcuyt, modul, xumb, nAndsA, uRatingA;
    ImageView userImage, userImageA;
    ApiService mApiService;
    private NavigationView navigationView;
    private View navHeader;

//    private static String url = "https://api.androidhive.info/contacts/";

//    private static String url = "http://app.profitdeco.com/get?login=raffi-minasyan@profit.com&password=c6159c32";

    private String TAG = LoginActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;

    ArrayList<HashMap<String, String>> contactList;

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

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new HomeFragment();
        displaySelectedFragment(fragment);

//        contactList = new ArrayList<>();
//        lv = (ListView) findViewById(R.id.list);
//        new GetContacts().execute();


        ArrayList<HashMap<String, String>> contactList;
    }

//    private class GetContacts extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            // Showing progress dialog
//            pDialog = new ProgressDialog(StProfActivity.this);
//            pDialog.setMessage("Please wait...");
//            pDialog.setCancelable(false);
//            pDialog.show();
//
//        }
//
//        @Override
//        protected Void doInBackground(Void... arg0) {
//            HttpHandler sh = new HttpHandler();
//
//            // Making a request to url and getting response
//            String jsonStr = sh.makeServiceCall(url);
//
//            Log.e(TAG, "Response from url: " + jsonStr);
//
//            if (jsonStr != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject(jsonStr);
//
//                    JSONArray contacts = jsonObj.getJSONArray("contacts");
//
//                    for (int i = 0; i < contacts.length(); i++) {
//                        JSONObject c = contacts.getJSONObject(i);
//
//                        String id = c.getString("id");
//                        String name = c.getString("name");
//                        String email = c.getString("email");
//
//                        JSONObject phone = c.getJSONObject("phone");
//                        String mobile = phone.getString("mobile");
//                        String home = phone.getString("home");
//                        String office = phone.getString("office");
//
//                        HashMap<String, String> contact = new HashMap<>();
//
//                        contact.put("id", id);
//                        contact.put("name", name);
//                        contact.put("email", email);
//                        contact.put("mobile", mobile);
//                        contact.put("home", home);
//                        contact.put("office", office);
//
//                        contactList.add(contact);
////
////                        JSONArray contacts = jsonObj.getJSONArray("notifications");
////
////                        for (int i = 0; i < contacts.length(); i++) {
////                            JSONObject c = contacts.getJSONObject(i);
////                            String notId = c.getString("id");
////                            String notStudentId = c.getString("student_id");
////                            String notText = c.getString("text");
////                            String notStatus = c.getString("status");
////                            String notWhen = c.getString("when");
////
////                            HashMap<String, String> notification = new HashMap<>();
//
////                            notification.put("id", notId);
////                            notification.put("student_id", notStudentId);
////                            notification.put("text", notText);
////                            notification.put("status", notStatus);
////                            notification.put("when", notWhen);
////                            contactList.add(notification);
////
//                        }
//                } catch (final JSONException e) {
//                    Log.e(TAG, "Json parsing error: " + e.getMessage());
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getApplicationContext(),
//                                    "Json parsing error: " + e.getMessage(),
//                                    Toast.LENGTH_LONG)
//                                    .show();
//                        }
//                    });
//
//                }
//            } else {
//                Log.e(TAG, "Couldn't get json from server.");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(),
//                                "Couldn't get json from server. Check LogCat for possible errors!",
//                                Toast.LENGTH_LONG)
//                                .show();
//                    }
//                });
//
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            // Dismiss the progress dialog
//            if (pDialog.isShowing())
//                pDialog.dismiss();
//            ListAdapter adapter = new SimpleAdapter(
//                    StProfActivity.this, contactList,
//                    R.layout.list_item, new String[]{"name", "email",
//                    "mobile", "office", "home"}, new int[]{R.id.name,
//                    R.id.email, R.id.mobile, R.id.office, R.id.home});
//
//            lv.setAdapter(adapter);
//        }
//
//    }

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
