package com.example.infinity.prof.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.bumptech.glide.Glide;
import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.handler.GrafikItemHandler;
import com.example.infinity.prof.handler.GroupHandler;
import com.example.infinity.prof.handler.HttpHandler;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.handler.SessionHandler;
import com.example.infinity.prof.handler.TeacherHandler;
import com.example.infinity.prof.model.Response;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HomeFragment extends Fragment {

    private String TAG = HomeFragment.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    private static String urls = "http://app.profitdeco.com/mobile/get?login=raffi-minasyan@profit.com&password=c6159c32";

    ArrayList<HashMap<String, String>> contactList;

    ApiService mApiService;
    ResponseHandler session;
    TextView uRating;
    TextView nAnds;
    TextView mrcuyt;
    TextView xumb;
    TextView teacherNandS;
    ImageView userImage;
    ImageView teacherImages;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_HOME);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View home = inflater.inflate(R.layout.fragment_home, container, false);

        mApiService = UtilsApi.getAPIService();
        session = new ResponseHandler(getActivity().getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getResponseDetails();
        System.out.println("start");
//        ArrayList<HashMap<String, String>> users =session.getListDetails();
//        for (HashMap<String,String> grafik:users){
//            System.out.println(grafik.keySet());
//            for (String key:grafik.keySet()){
//                System.out.println(grafik.get(key));
//            }
//        }
//        System.out.println("end");

//        System.out.println(users.get(ResponseHandler.GRAFIK_DAY));

        // student data
        String name = user.get(ResponseHandler.RESPONSE_NAME);
        String surname = user.get(ResponseHandler.RESPONSE_SURNAME);
        String image = user.get(ResponseHandler.RESPONSE_PHOTO);
        String rating = user.get(ResponseHandler.RESPONSE_AVG);
        String xumbs = user.get(ResponseHandler.RESPONSE_GROUP_ID);
//        String grafik = user.get(ResponseHandler.GRAFIK_ID);
//        System.out.println(grafik);

        // teacher data
        String teacherName = user.get(ResponseHandler.TEACHER_NAME);
        String teacherSurname = user.get(ResponseHandler.TEACHER_SURNAME);
        String teacherPhone = user.get(ResponseHandler.TEACHER_PHONE);
        String teacherImage = user.get(ResponseHandler.TEACHER_PHOTO);


        // grafik data
        String grafikId = user.get(ResponseHandler.GRAFIK_ID);
        String groupIdGrafik = user.get(ResponseHandler.GRAFIK_GROUP_ID);
        String dayIdGrafik = user.get(ResponseHandler.GRAFIK_DAY_ID);
        String dayGrafik = user.get(ResponseHandler.GRAFIK_DAY);
        String startGrafik = user.get(ResponseHandler.GRAFIK_START);
        String endGrafik = user.get(ResponseHandler.GRAFIK_END);
        String teacherIdGrafik = user.get(ResponseHandler.GRAFIK_TEACHER_ID);
        String activeGrafik = user.get(ResponseHandler.GRAFIK_ACTIVE);
//        for(int i = 0;i<grafikId.length(); i++) {
//        //    String c= grafikId[i];
////            System.out.println(grafikId);
//        }

        String grafik = user.get(ResponseHandler.RESPONSE_GRAFIK);
        String[] parts = grafik.split("group_id");
        for (int i = 0; i < parts.length; i++) {
            String graf = parts[i];
            System.out.println(graf);
//            System.out.println(parts[1]);
            String[] list = graf.split("'");
            System.out.println(list);
//            for (int j = 0; j < list.length; ++j) {
//                String group_id = list[j];
//                System.out.println(group_id);
//                System.out.println(list[1]);
//            }
        }
        // group data
        String groupId = user.get(GroupHandler.GROUP_ID);
        String groupPart = user.get(GroupHandler.GROUP_PART_ID);

        nAnds = (TextView) home.findViewById(R.id.nAnds);
        nAnds.setText(name + " " + surname);

        uRating = (TextView) home.findViewById(R.id.uRating);
        uRating.setText("Ռեյտինգ " + rating + "%");

        mrcuyt = (TextView) home.findViewById(R.id.mrcuyt);
        mrcuyt.setText("Մրցույթ");

        xumb = (TextView) home.findViewById(R.id.xumb);
        xumb.setText("Իմ խումբը - " + xumbs);

        teacherNandS = (TextView) home.findViewById(R.id.teacherNandS);
        teacherNandS.setText(teacherName + "  " + teacherSurname + "\n" + teacherPhone);


        contactList = new ArrayList<>();

        lv = (ListView) home.findViewById(R.id.lists);
//        new GetContacts().execute();

        userImage = (ImageView) home.findViewById(R.id.userImage);
        Glide.with(this).load("http://app.profitdeco.com/img/students/" + image).into(userImage);

        teacherImages = (ImageView) home.findViewById(R.id.teacherImage);
        Glide.with(this).load("http://app.profitdeco.com/img/teachers/" + teacherImage).into(teacherImages);

//        https://www.journaldev.com/10642/android-jsonobject-json-parsing

//        try {
//
//            List<String> items = new ArrayList<>();
//            JSONObject root = new JSONObject(grafik);
//
//            JSONArray array= root.getJSONArray("array");
//
//            this.setTitle(root.getString("title"));
//
//            for(int i=0;i<array.length();i++)
//            {
//                JSONObject object= array.getJSONObject(i);
//                items.add(object.getString("company"));
//            }
//
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                    android.R.layout.simple_list_item_1, items);
//
//            if (lv != null) {
//                lv.setAdapter(adapter);
//            }
//
//            JSONObject nested= root.getJSONObject("nested");
//            Log.d("TAG","flag value "+nested.getBoolean("flag"));
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        return home;

    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            mApiService = UtilsApi.getAPIService();
            session = new ResponseHandler(getActivity().getApplicationContext());
            session.checkLogin();

            HashMap<String, String> user = session.getResponseDetails();
            String grafik = user.get(ResponseHandler.RESPONSE_GRAFIK);
            String[] parts = grafik.split("group_id");
            for (int i = 0; i < parts.length; i++) {
                String graf = parts[i];
                System.out.println(graf);
                String[] list = graf.split("'");
                for (int j = 0; j < list.length; ++j) {
                    String graf_id = list[j];
                    System.out.println(graf_id);
                    System.out.println(list[1]);

                    String day = list[30];
                }
            }
            JSONObject jsonStr = new JSONObject();
//
//            JSONArray array= root.getJSONArray("array");

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = jsonStr.getJSONObject("grafik");

                    JSONArray contacts = jsonObj.getJSONArray("grafik");

                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString("id");
                        String groupIdGrafik = c.getString("group_id");
                        String dayIdGrafik = c.getString("day_id");
                        String startGrafik = c.getString("start");
                        String dayGrafik = c.getString("day");
                        String teachergrafik = c.getString("teacher_id");
                        String endGrafik = c.getString("end");
                        String activeGrafik = c.getString("active");

                        HashMap<String, String> contact = new HashMap<>();

                        contact.put("day", dayGrafik);
                        contact.put("start", startGrafik);
                        contact.put("end", endGrafik);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    System.out.println(e);
                }
            } else {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(
                    HomeFragment.super.getContext(), contactList,
                    R.layout.list_item, new String[]{"day", "start",
                    "end"}, new int[]{R.id.day,
                    R.id.start, R.id.end});

            lv.setAdapter(adapter);
        }

    }
//
}
// https://www.androidhive.info/2012/01/android-json-parsing-tutorial/
