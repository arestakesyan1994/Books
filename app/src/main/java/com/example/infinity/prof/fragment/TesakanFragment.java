package com.example.infinity.prof.fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import com.example.infinity.prof.model.Responses;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class TesakanFragment extends Fragment implements View.OnClickListener {
    private ListView listView;
    ApiService mApiService;
    ResponseHandler session;
    Button php, html, jQuery, web, mvc, wordpress, js, laravel, angularJS,
            javaScript, nodeJs, c, wpf, sql, asp, oop, angular, react, froms, vue;
    public static String KEY;

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
        php.setOnClickListener(this);

        html = tesakan.findViewById(R.id.html);
        html.setOnClickListener(this);

        jQuery = tesakan.findViewById(R.id.jQuery);
        jQuery.setOnClickListener(this);

        web = tesakan.findViewById(R.id.web);
        web.setOnClickListener(this);

        mvc = tesakan.findViewById(R.id.mvc);
        mvc.setOnClickListener(this);

        wordpress = tesakan.findViewById(R.id.wordpress);
        wordpress.setOnClickListener(this);

        js = tesakan.findViewById(R.id.js);
        js.setOnClickListener(this);

        laravel = tesakan.findViewById(R.id.laravel);
        laravel.setOnClickListener(this);

        angularJS = tesakan.findViewById(R.id.angularJS);
        angularJS.setOnClickListener(this);

        javaScript = tesakan.findViewById(R.id.javaScript);
        javaScript.setOnClickListener(this);

        nodeJs = tesakan.findViewById(R.id.nodeJs);
        nodeJs.setOnClickListener(this);

        c = tesakan.findViewById(R.id.c);
        c.setOnClickListener(this);

        wpf = tesakan.findViewById(R.id.wpf);
        wpf.setOnClickListener(this);

        sql = tesakan.findViewById(R.id.sql);
        sql.setOnClickListener(this);

        asp = tesakan.findViewById(R.id.asp);
        asp.setOnClickListener(this);

        oop = tesakan.findViewById(R.id.oop);
        oop.setOnClickListener(this);

        angular = tesakan.findViewById(R.id.angular);
        angular.setOnClickListener(this);

        react = tesakan.findViewById(R.id.react);
        react.setOnClickListener(this);

        froms = tesakan.findViewById(R.id.froms);
        froms.setOnClickListener(this);

        vue = tesakan.findViewById(R.id.vue);
        vue.setOnClickListener(this);

        return tesakan;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        switch (v.getId()) {
            case R.id.web:
                KEY = "-1";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.html:
                KEY = "1";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.jQuery:
                KEY = "2";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.php:
                KEY = "3";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.mvc:
                KEY = "4";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.wordpress:
                KEY = "5";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.laravel:
                KEY = "6";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.angularJS:
                KEY ="7";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.js:
                KEY = "13";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.javaScript:
                KEY = "18";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.nodeJs:
                KEY ="8";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.c:
                KEY = "9";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.wpf:
                KEY = "10";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.sql:
                KEY = "11";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.asp:
                KEY ="12";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.oop:
                KEY = "19";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.angular:
                KEY = "21";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.react:
                KEY = "22";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.vue:
                KEY = "23";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;
            case R.id.froms:
                KEY = "24";
                fragment = new TesakanHomeFragment();
                displaySelectedFragment(fragment);
                break;

        }
    }

    private void displaySelectedFragment(Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putString("Key", KEY);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
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
