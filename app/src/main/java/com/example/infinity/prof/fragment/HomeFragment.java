package com.example.infinity.prof.fragment;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    private ListView gday;
    private ListView gstart;
    private ListView gend;
    private ListView xumbStName;
    private ListView xumbStSurame;
    private ListView xumbStImg;
    private ListView xumbStRating;

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
//                , android.R.layout.simple_list_item_1, gEnd);
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

//
//        String groupStImg = user.get(ResponseHandler.GROUP_STUDENTS_IMG);
//        String[] gStImg = groupStImg.split(",");
//        ArrayAdapter<CharSequence> stImg = new ArrayAdapter<CharSequence>(home.getContext()
//                , R.layout.list_item, gStImg);
//        xumbStImg = (ListView) home.findViewById(R.id.xumbStImg);
//        xumbStImg.setAdapter(stImg);

//        String groupImage = user.get(ResponseHandler.GROUP_STUDENTS_IMG);
//        String[] gImage = groupStRating.split(",");
//        System.out.println(groupImage);
//        ArrayAdapter<CharSequence> gImg = new ArrayAdapter<CharSequence>(home.getContext()
//                , R.layout.list_item, gImage);
//        xumbStImg.setAdapter(
//                new ImageListAdapter(
//                        home.getContext(),
//                        gImg
//                )
//        );

//        ArrayAdapter<CharSequence> stImage = new ArrayAdapter<CharSequence>(home.getContext()
//                , R.layout.list_item_img, gImage);
//        xumbStImg = (ListView) home.findViewById(R.id.xumbStImg);
//        xumbStImg.setAdapter(stImage);


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

//    private class ImageListAdapter implements ListAdapter {
//        public ImageListAdapter(Context context, ArrayAdapter<CharSequence> gImg) {
//
//            Glide.with(context).load("http://app.profitdeco.com/img/students/" + gImg).into(userImage);
//
//        }
//
//        @Override
//        public boolean areAllItemsEnabled() {
//            return false;
//        }
//
//        @Override
//        public boolean isEnabled(int position) {
//            return false;
//        }
//
//        @Override
//        public void registerDataSetObserver(DataSetObserver observer) {
//
//        }
//
//        @Override
//        public void unregisterDataSetObserver(DataSetObserver observer) {
//
//        }
//
//        @Override
//        public int getCount() {
//            return 0;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public boolean hasStableIds() {
//            return false;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            return null;
//        }
//
//        @Override
//        public int getItemViewType(int position) {
//            return 0;
//        }
//
//        @Override
//        public int getViewTypeCount() {
//            return 0;
//        }
//
//        @Override
//        public boolean isEmpty() {
//            return false;
//        }
//    }


//    private class ImageListAdapter implements ListAdapter {
//        private Context context;
//        private LayoutInflater inflater;
//
//        private String[] imageUrls;
//
//        public ImageListAdapter(Context context, String[] imageUrls) {
//
//            this.context = context;
//            this.imageUrls = imageUrls;
//
//            inflater = LayoutInflater.from(context);
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (null == convertView) {
//                convertView = inflater.inflate(R.layout.list_item_img, parent, false);
//            }
//
//            Glide.with(context)
//                    .load("http://app.profitdeco.com/img/students/" +imageUrls[position])
//                    .into((ImageView) convertView);
//
//            return convertView;
//        }
//
//        @Override
//        public boolean areAllItemsEnabled() {
//            return false;
//        }
//
//        @Override
//        public boolean isEnabled(int position) {
//            return false;
//        }
//
//        @Override
//        public void registerDataSetObserver(DataSetObserver observer) {
//
//        }
//
//        @Override
//        public void unregisterDataSetObserver(DataSetObserver observer) {
//
//        }
//
//        @Override
//        public int getCount() {
//            return 0;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public boolean hasStableIds() {
//            return false;
//        }
//
//        @Override
//        public int getItemViewType(int position) {
//            return 0;
//        }
//
//        @Override
//        public int getViewTypeCount() {
//            return 0;
//        }
//
//        @Override
//        public boolean isEmpty() {
//            return false;
//        }
//    }
}