package com.example.infinity.prof.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.model.Responses;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.infinity.prof.fragment.TesakanFragment.KEY;

public class TesakanHomeFragment extends Fragment {
    String[] harcs = new String[]{};
    ListView harcerList;
    ApiService mApiService;

    public TesakanHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_TESAKAN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tesakanHome = inflater.inflate(R.layout.fragment_tesakan_home, container, false);
        mApiService = UtilsApi.getAPIService();

        mApiService.theory().enqueue(new Callback<List<Responses>>() {
            @Override
            public void onResponse(Call<List<Responses>> call, Response<List<Responses>> response) {
                System.out.println("hghgghghg");
                System.out.println(response.body());
                String harcer = "";
                Bundle bundle = getArguments();
                if (bundle != null) {
                    String myInt = bundle.getString("Key", KEY);
                    System.out.println(myInt);
                    for (int i = 0; i < response.body().size(); i++) {
                        String id = String.valueOf(response.body().get(i).getId());
                        String harc = response.body().get(i).getHarc();
                        String patasxan = response.body().get(i).getPatasxan();
                        String moduleId = response.body().get(i).getModuleId();
                        String author = response.body().get(i).getAuthor();

                        if (moduleId.equals(myInt)) {
                            harcer +="  "+ Html.fromHtml("<h1>"+harc+"</>")+ "\n" + "\n"+" " + Html.fromHtml(patasxan) + "\n" + "\n" +" "+ author + "\n" + "о";
                        }
                    }
                }
                String[] h = harcer.split("о");
                harcs = h;
                ArrayAdapter<CharSequence> harc = new ArrayAdapter<CharSequence>(tesakanHome.getContext(), R.layout.row_items, h);
                harcerList = (ListView) tesakanHome.findViewById(R.id.harcerList);
                harcerList.setAdapter(harc);
                System.out.println(harcs);
            }

            @Override
            public void onFailure(Call<List<Responses>> call, Throwable t) {

            }
        });

        return tesakanHome;
    }
}