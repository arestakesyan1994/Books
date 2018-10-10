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
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class TnajinFragment extends Fragment {

    String[] OR_SKSAC = {"HTML,CSS", "JavaScript", "jQuery", "Java"};
    String[] OR_SKSAC2 = {"1_HTML,CSS", "2_JavaScript", "3_jQuery", "4_Java"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_TNAYIN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tn =inflater.inflate(R.layout.fragment_tnajin, container, false);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(tn.getContext(),
                android.R.layout.simple_dropdown_item_1line, OR_SKSAC);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) tn.findViewById(R.id.or_sksvac4);
        betterSpinner.setAdapter(arrayAdapter);
        betterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(tn.getContext(),
                android.R.layout.simple_dropdown_item_1line, OR_SKSAC2);
        MaterialBetterSpinner betterSpinner2 = (MaterialBetterSpinner) tn.findViewById(R.id.or_sksvac3);
        betterSpinner2.setAdapter(arrayAdapter2);
        betterSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return tn;
    }

}