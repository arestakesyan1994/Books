package com.example.infinity.prof.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.infinity.prof.R;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import java.util.HashMap;

public class ListMenuFragment extends ListFragment {
    String[] users = new String[]{"Ընդհանուր վեբ ծրագրավորում","HTML, CSS", "JavaScript, jQuery", "PHP, MySQL", "MVC, Codeigniter","Wordpress", "Laravel", "AngularJS","JS - ընդլայնված", "JS մասնագիտացված", "Node.js", "C#",
            "Windows Froms,WPF", "SQL Server,ADD.NET", "ASP.NET MVC", "ES6, OOP","Node.js", "Angular", "React.js","Vue.js", "Angular, React.js, Vue.js"};
    String[] location = new String[]{"-1", "1", "2", "3", "4", "5", "6", "7", "13", "18", "8", "9", "10","11", "12", "19", "20", "21", "22", "23", "24"};
    ApiService mApiService;
    ResponseHandler session;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.listitems_info, container, false);

        mApiService = UtilsApi.getAPIService();
        session = new ResponseHandler(getActivity().getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getResponseDetails();
        String moduleName = user.get(ResponseHandler.MODULES_NAME);
        users = moduleName.split(";");
        System.out.println(users);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_menu, users);
        setListAdapter(adapter);
        return view;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        DetailsFragment txt = (DetailsFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change("Name: "+ users[position],"Location : "+ location[position]);
        getListView().setSelector(android.R.color.holo_purple);
    }
}