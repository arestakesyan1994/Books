package com.example.infinity.prof.fragment;

import android.app.ListFragment;
import android.content.Intent;
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
    Button php, html, jQuery, web, mvc, wordpress, js, laravel, angularJS,
            javaScript, nodeJs, c, wpf, sql, asp, oop, angular, react, froms, vue;


//    String[] users = new String[]{"Ընդհանուր վեբ ծրագրավորում","HTML, CSS", "JavaScript, jQuery", "PHP, MySQL", "MVC, Codeigniter","Wordpress", "Laravel", "AngularJS","JS - ընդլայնված", "JS մասնագիտացված", "Node.js", "C#",
//            "Windows Froms,WPF", "SQL Server,ADD.NET", "ASP.NET MVC", "ES6, OOP","Node.js", "Angular", "React.js","Vue.js", "Angular, React.js, Vue.js"};
//    String[] location = new String[]{"-1", "1", "2", "3", "4", "5", "6", "7", "13", "18", "8", "9", "10","11", "12", "19", "20", "21", "22", "23", "24"};


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

        php = tesakan.findViewById(R.id.php);
        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tesakan.getContext(),tasakanHome.class);
                startActivity(intent);
            }
        });

//        HashMap<String, String> user = session.getResponseDetails();
//        String moduleName = user.get(ResponseHandler.MODULES_NAME);
//        String[] mName = moduleName.split(";");
//        System.out.println(mName);
//
//        ArrayAdapter<CharSequence> end = new ArrayAdapter<CharSequence>(tesakan.getContext(), R.layout.thory_list,
//                 users);
//        listView = (ListView) tesakan.findViewById(R.id.theory);
//        listView.setAdapter(end);
//        theory();
        return tesakan;
    }



//    private void theory() {
//        mApiService.theory().enqueue(new Callback<Response>() {
//            @Override
//            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//                System.out.println(response.body());
//                String a = response.body().getHarc();
//                System.out.println(a);
//            }
//
//            @Override
//            public void onFailure(Call<Response> call, Throwable t) {
//
//            }
//        });
//    }

}
