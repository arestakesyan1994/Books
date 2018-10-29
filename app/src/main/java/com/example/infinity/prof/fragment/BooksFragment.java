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

public class BooksFragment extends Fragment {
//
//    ListView imgList;
//    String[] img = {
//            String.valueOf(R.drawable.nkmek),
//            String.valueOf(R.drawable.nkerku),
//            String.valueOf(R.drawable.nkereq),
//            String.valueOf(R.drawable.nkchors),
//            String.valueOf(R.drawable.nkhing),
//            String.valueOf(R.drawable.nkvec),
//            String.valueOf(R.drawable.nkyot),
//            String.valueOf(R.drawable.nkut),
//            String.valueOf(R.drawable.nkin)
//    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_BOOKS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View book = inflater.inflate(R.layout.fragment_books, container, false);
//        ArrayAdapter<CharSequence> end = new ArrayAdapter<CharSequence>(book.getContext()
//                ,  android.R.layout.simple_gallery_item, img);
//        imgList = (ListView) book.findViewById(R.id.imgList);
//        imgList.setAdapter(end);

        return book;
    }

}
