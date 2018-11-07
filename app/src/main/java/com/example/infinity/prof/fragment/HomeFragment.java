package com.example.infinity.prof.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment {

    private ListView gday,gstart, gend,xumbStName;
    private ListView xumbStSurame, xumbStRating;

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

        String name = user.get(ResponseHandler.RESPONSE_NAME);
        String surname = user.get(ResponseHandler.RESPONSE_SURNAME);
        String image = user.get(ResponseHandler.RESPONSE_PHOTO);
        String rating = user.get(ResponseHandler.RESPONSE_AVG);
        String xumbs = user.get(ResponseHandler.RESPONSE_GROUP_ID);

        //Teacher data
        String teacherName = user.get(ResponseHandler.TEACHER_NAME);
        String teacherSurname = user.get(ResponseHandler.TEACHER_SURNAME);
        String teacherPhone = user.get(ResponseHandler.TEACHER_PHONE);
        String teacherImage = user.get(ResponseHandler.TEACHER_PHOTO);


        //Grafik data
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
        gend = (ListView) home.findViewById(R.id.listEnd);
        gend.setAdapter(end);

        // group data
        String groupId = user.get(ResponseHandler.GROUP_ID);
        String groupName = user.get(ResponseHandler.GROUP_GNAME);
        String groupPartId = user.get(ResponseHandler.GROUP_PART_ID);
        String groupTeacherId = user.get(ResponseHandler.GROUP_TEACHER_ID);
        String groupColor = user.get(ResponseHandler.GROUP_COLOR);
        String groupLsaranId = user.get(ResponseHandler.GROUP_LSAEAN_ID);
        String groupLevel = user.get(ResponseHandler.GROUP_LEVEL);
        String groupActive = user.get(ResponseHandler.GROUP_ACTIVE);
        String groupModuleId = user.get(ResponseHandler.GROUP_MODULE_ID);

        String groupStName = user.get(ResponseHandler.GROUP_STUDENTS_NAME);
        String[] gStName = groupStName.split(",");
        ArrayAdapter<CharSequence> stName = new ArrayAdapter<CharSequence>(home.getContext()
                , R.layout.list_item, gStName);
        xumbStName = (ListView) home.findViewById(R.id.xumbStName);
        xumbStName.setAdapter(stName);

        String groupStSurname = user.get(ResponseHandler.GROUP_STUDENTS_SURNAME);
        String[] gStSurname = groupStSurname.split(",");
        ArrayAdapter<CharSequence> stSurname = new ArrayAdapter<CharSequence>(home.getContext()
                , R.layout.list_item, gStSurname);
        xumbStSurame = (ListView) home.findViewById(R.id.xumbStSurname);
        xumbStSurame.setAdapter(stSurname);

        String groupStRating = user.get(ResponseHandler.GROUP_STUDENTS_RATING);
        String[] gStRating = groupStRating.split(",");
        ArrayAdapter<CharSequence> stRating = new ArrayAdapter<CharSequence>(home.getContext()
                , R.layout.list_item, gStRating);
        xumbStRating = (ListView) home.findViewById(R.id.xumbStRating);
        xumbStRating.setAdapter(stRating);

        nAnds = (TextView) home.findViewById(R.id.nAnds);
        nAnds.setText(name + " " + surname);

        uRating = (TextView) home.findViewById(R.id.uRating);
        uRating.setText("Ռեյտինգ " + rating + "%");

        mrcuyt = (TextView) home.findViewById(R.id.mrcuyt);
        mrcuyt.setText("Մրցույթ");

        xumb = (TextView) home.findViewById(R.id.xumb);
        xumb.setText("Իմ խումբը - " + groupName);

        teacherNandS = (TextView) home.findViewById(R.id.teacherNandS);
        teacherNandS.setText(teacherName + "  " + teacherSurname + "\n" + teacherPhone);

        contactList = new ArrayList<>();

        userImage = (ImageView) home.findViewById(R.id.userImage);
        Glide.with(this).load("http://app.profitdeco.com/img/students/" + image).into(userImage);

        teacherImages = (ImageView) home.findViewById(R.id.teacherImage);
        Glide.with(this).load("http://app.profitdeco.com/img/teachers/" + teacherImage).into(teacherImages);

        return home;

    }
}