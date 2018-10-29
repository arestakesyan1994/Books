//package com.example.infinity.prof.fragment;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import android.app.ListFragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.SimpleAdapter;
//import android.widget.Toast;
//
//import com.example.infinity.prof.R;
//
//public class PlayersFragment extends ListFragment{
//  String[] players={"1","2","3","4","5","6","7","8","9"};
//  int[] images={R.drawable.nkmek,
//          R.drawable.nkerku,
//          R.drawable.nkereq,
//          R.drawable.nkchors,
//          R.drawable.nkhing,
//          R.drawable.nkvec,
//          R.drawable.nkyot,
//          R.drawable.nkut,
//          R.drawable.nkin
//  };
//
//  ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
//  SimpleAdapter adapter;
//
//  @Override
//  public View onCreateView(LayoutInflater inflater, ViewGroup container,
//      Bundle savedInstanceState) {
//    // TODO Auto-generated method stub
//
//     //MAP
//    HashMap<String, String> map=new HashMap<String, String>();
//
//    //FILL
//    for(int i=0;i<players.length;i++)
//    {
//      map=new HashMap<String, String>();
//      map.put("Player", players[i]);
//      map.put("Image", Integer.toString(images[i]));
//
//      data.add(map);
//    }
//
//    //KEYS IN MAP
//    String[] from={"Player","Image"};
//
//    //IDS OF VIEWS
//    int[] to={R.id.imageView1};
//
//    //ADAPTER
//    adapter=new SimpleAdapter(getActivity(), data, R.layout.mylist, from, to);
//    setListAdapter(adapter);
//
//    return super.onCreateView(inflater, container, savedInstanceState);
//  }
////
////  @Override
////  public void onStart() {
////    // TODO Auto-generated method stub
////    super.onStart();
////
////    getListView().setOnItemClickListener(new OnItemClickListener() {
////
////      @Override
////      public void onItemClick(AdapterView<?> av, View v, int pos,
////          long id) {
////        // TODO Auto-generated method stub
////
////        Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();
////
////      }
////    });
////  }
//
//}