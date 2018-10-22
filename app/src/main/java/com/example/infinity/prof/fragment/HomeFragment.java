package com.example.infinity.prof.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.bumptech.glide.Glide;
import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.handler.GrafikItemHandler;
import com.example.infinity.prof.handler.GroupHandler;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.handler.SessionHandler;
import com.example.infinity.prof.handler.TeacherHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment {
//    RequestQueue requestQueue;
//
//    static final int INTERNET_REQ = 23;
//
//    static final String REQ_TAG = "VACTIVITY";

    ApiService mApiService;
    ResponseHandler session;

    TextView uRating;
    TextView nAnds;
    TextView mrcuyt;
    TextView xumb;
    TextView teacherNandS;
    ListView orer;
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
        // Inflate the layout for this fragment
        View home = inflater.inflate(R.layout.fragment_home, container, false);

        mApiService = UtilsApi.getAPIService();
        session = new ResponseHandler(getActivity().getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getResponseDetails();

        // student data
        String name = user.get(ResponseHandler.RESPONSE_NAME);
        String surname = user.get(ResponseHandler.RESPONSE_SURNAME);
        String image = user.get(ResponseHandler.RESPONSE_PHOTO);
        String rating = user.get(ResponseHandler.RESPONSE_AVG);
        String xumbs = user.get(ResponseHandler.RESPONSE_GROUP_ID);

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
        teacherNandS.setText(teacherName +"\n" + teacherSurname +"\n" + teacherPhone);

        orer = (ListView) home.findViewById(R.id.lists);
//        orer.setText(dayGrafik +" = " + startGrafik +" - " + teacherPhone);
//

        userImage = (ImageView) home.findViewById(R.id.userImage);
        Glide.with(this).load("http://app.profitdeco.com/img/students/" + image).into(userImage);

        teacherImages = (ImageView) home.findViewById(R.id.teacherImage);
        Glide.with(this).load("http://app.profitdeco.com/img/teachers/" + teacherImage).into(teacherImages);

        return home;

    }

}
// https://www.androidhive.info/2012/01/android-json-parsing-tutorial/
// https://github.com/codepath/android-rest-client-template/tree/master/app/src/main/java/com/codepath/apps/restclienttemplate
