package com.example.infinity.prof.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.models.Response;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class TesakanFragment extends Fragment {
    private ListView listView;
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
        System.out.println(mName);

        ArrayAdapter<CharSequence> end = new ArrayAdapter<CharSequence>(tesakan.getContext(), R.layout.row_item,
                R.id.textNot, mName);
        listView = (ListView) tesakan.findViewById(R.id.theory);
        listView.setAdapter(end);
theory();
        return tesakan;
    }

    private void theory() {
        mApiService.theory().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                System.out.println(response.body());
                String a = response.body().getHarc();
                System.out.println(a);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }

}
