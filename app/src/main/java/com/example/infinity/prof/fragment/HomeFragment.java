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
    private ListView gday;
    private ListView gstart;
    private ListView gend;

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

//        System.out.println(grafikId);
//        System.out.println(groupIdGrafik);
//        System.out.println(dayGrafik);
//        System.out.println(dayIdGrafik);
//        for(int i = 0;i<grafikId.length(); i++) {
//        //    String c= grafikId[i];
////            System.out.println(grafikId);
//        }

//        String grafik = user.get(ResponseHandler.RESPONSE_GRAFIK);
//        String[] parts = grafik.split("group_id");
//        for (int i = 0; i < parts.length; i++) {
//            String graf = parts[i];
//            System.out.println(graf);
////            System.out.println(parts[1]);
//            String[] list = graf.split("'");
////            System.out.println(list);
//            for (int j = 0; j < list.length; ++j) {
//                String group_id = list[j];
//                System.out.println(group_id);
//
//                ArrayAdapter<CharSequence> adapter =  new ArrayAdapter<CharSequence>(home.getContext()
//                        ,android.R.layout.simple_list_item_1,list);
//                lv = (ListView) home.findViewById(R.id.lists);
//                lv.setAdapter(adapter);
//            }
//        }
        String grafikDay = user.get(ResponseHandler.GRAFIK_DAY);
        String[] gDay = grafikDay.split(",");
        ArrayAdapter<CharSequence> day = new ArrayAdapter<CharSequence>(home.getContext()
                , R.layout.list_item, gDay);
        gday = (ListView) home.findViewById(R.id.listDay);
        gday.setAdapter(day);

        String grafikStart = user.get(ResponseHandler.GRAFIK_START);
        String[] gStart = grafikStart.split(",");
        ArrayAdapter<CharSequence> start = new ArrayAdapter<CharSequence>(home.getContext()
                , R.layout.list_item, gStart);
        gstart = (ListView) home.findViewById(R.id.listStart);
        gstart.setAdapter(start);

        String grafikEnd = user.get(ResponseHandler.GRAFIK_END);
        String[] gEnd = grafikEnd.split(",");
        ArrayAdapter<CharSequence> end = new ArrayAdapter<CharSequence>(home.getContext()
                , R.layout.list_item, gEnd);
//                , android.R.layout.simple_list_item_1, gEnd);
        gend = (ListView) home.findViewById(R.id.listEnd);
        gend.setAdapter(end);


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
}
// https://www.androidhive.info/2012/01/android-json-parsing-tutorial/
