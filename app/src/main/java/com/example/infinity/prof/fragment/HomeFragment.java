package com.example.infinity.prof.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.handler.GrafikItemHandler;
import com.example.infinity.prof.handler.GroupHandler;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.handler.SessionHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment {

    ResponseHandler session;
    GrafikItemHandler grafikHandler;
    TextView uRating, nAnds, mrcuyt, xumb, teacher;
    ImageView userImage, userImageA;
    ApiService mApiService;

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

        HashMap<String, String> user = session.getGrafikDetails();
        String name = user.get(SessionHandler.KEY_NAME);
        String surname = user.get(SessionHandler.KEY_SURNAME);
        String image = user.get(SessionHandler.KEY_PHOTO);
        String rating = user.get(SessionHandler.KEY_AVG);
        String xumbs = user.get(SessionHandler.KEY_GROUP_ID);


        List<GrafikItemHandler> grafikItemHandlerList = new ArrayList<>();





//        grafikHandler = new GrafikItemHandler(getActivity().getApplicationContext());
//        grafikHandler.checkLogin();
//
//        HashMap<String,String> grafik = grafikHandler.getGrafikDetails();
//        String teacherId = grafik.get(GrafikItemHandler.GRAFIK_TEACHER_ID);
//
//        teacher =(TextView) home.findViewById(R.id.teacher);
//        teacher.setText(teacherId);

        nAnds = (TextView) home.findViewById(R.id.nAnds);
        nAnds.setText(name + " " + surname);

        uRating = (TextView) home.findViewById(R.id.uRating);
        uRating.setText("Ռեյտինգ " + rating + "%");

        mrcuyt = (TextView) home.findViewById(R.id.mrcuyt);
        mrcuyt.setText("Մրցույթ");

        xumb = (TextView) home.findViewById(R.id.xumb);
        xumb.setText("Իմ խումբը - " + xumbs);

        userImage = (ImageView) home.findViewById(R.id.userImage);
        Glide.with(this).load("http://app.profitdeco.com/img/students/" + image).into(userImage);
        return home;
    }


}
