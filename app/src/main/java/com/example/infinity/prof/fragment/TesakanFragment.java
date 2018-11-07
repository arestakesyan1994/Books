package com.example.infinity.prof.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.HashMap;

public class TesakanFragment extends Fragment {

    ApiService mApiService;
    ResponseHandler session;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_TESAKAN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tesakan = inflater.inflate(R.layout.fragment_tesakan, container, false);

        mApiService = UtilsApi.getAPIService();
        session = new ResponseHandler(getActivity().getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getResponseDetails();
        String moduleName = user.get(ResponseHandler.MODULES_NAME);
        String[] mName = moduleName.split(";");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(tesakan.getContext(),
                android.R.layout.simple_dropdown_item_1line, mName);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) tesakan.findViewById(R.id.tesakan);
        betterSpinner.setAdapter(arrayAdapter);
        betterSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String i = parent.getItemAtPosition(position).toString();
                System.out.println(i);

            }
        });
        betterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return tesakan;
    }

}
