//package com.example.infinity.prof.fragment;
//
//import android.app.ListFragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.example.infinity.prof.R;
//import com.example.infinity.prof.constants.NavigationDrawerConstants;
//import com.example.infinity.prof.handler.ResponseHandler;
//import com.example.infinity.prof.models.Response;
//import com.example.infinity.prof.url.ApiService;
//import com.example.infinity.prof.url.UtilsApi;
//
//import java.util.HashMap;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import android.app.ListFragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//public class TheoryFragment extends ListFragment {
//    private ListView tesakanner;
//    ApiService mApiService;
//    ResponseHandler session;
//    String[] mName;
//    String[] location = new String[]{"Hyderabad","Guntur","Hyderabad","Bangalore","Vizag","Nagpur"};
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view =inflater.inflate(R.layout.theory_item, container, false);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, mName);
//        setListAdapter(adapter);
//        return view;
//    }
//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        DetailsFragment txt = (DetailsFragment)getFragmentManager().findFragmentById(R.id.fragment2);
//        txt.change("Name: "+ mName[position],"Location : "+ location[position]);
//        getListView().setSelector(android.R.color.holo_blue_dark);
//    }
//}
