package com.example.infinity.prof.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import java.util.HashMap;

public class NotificationFragment extends Fragment {

    ApiService mApiService;
    ResponseHandler session;
    private ListView notifications;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_NOTIFICATION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View notification = inflater.inflate(R.layout.fragment_notification, container, false);

        mApiService = UtilsApi.getAPIService();
        session = new ResponseHandler(getActivity().getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getResponseDetails();
        System.out.println("start");

        String text = user.get(ResponseHandler.NOTIFICATION_TEXT);
        String count = user.get(ResponseHandler.NOTIFICATION_WHEN);
        String[] notText = text.split("}");
        ArrayAdapter<CharSequence> end = new ArrayAdapter<CharSequence>(notification.getContext()
                , R.layout.list_item, notText);
        notifications = (ListView) notification.findViewById(R.id.notification);
        notifications.setAdapter(end);
        return notification;
    }
}