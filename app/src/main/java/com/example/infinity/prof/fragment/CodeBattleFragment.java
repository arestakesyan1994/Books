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
import com.example.infinity.prof.handler.SessionHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import java.util.HashMap;

public class CodeBattleFragment extends Fragment {

    SessionHandler session;
    TextView nAnds;
    ImageView userImage;
    ApiService mApiService;

    public CodeBattleFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_CODE_BATTLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View home = inflater.inflate(R.layout.fragment_code_battle, container, false);

        mApiService = UtilsApi.getAPIService();

        session = new SessionHandler(getActivity().getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(SessionHandler.KEY_NAME);
        String surname = user.get(SessionHandler.KEY_SURNAME);
        String image = user.get(SessionHandler.KEY_PHOTO);
        String rating = user.get(SessionHandler.KEY_AVG);

        nAnds =(TextView) home.findViewById(R.id.nAndsC);
        nAnds.setText(name + " "+ surname);

        userImage = (ImageView) home.findViewById(R.id.userImageC);
        Glide.with(this).load("http://app.profitdeco.com/img/students/" + image).into(userImage);
        return home;
    }

}
