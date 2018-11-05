package com.example.infinity.prof.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.HashMap;

public class ModuliGnahatumFragment extends Fragment {

    ApiService mApiService;
    ResponseHandler session;
    TextView teacherNameAndSurname;

    String[] harcMek = {"Ընդհանրապես համաձայն չեմ", "Մասամբ համաձայն եմ",
            "Համաձայն եմ", "Լրիվ համաձայն եմ"};
    String[] harcErku = {"Ընդհանրապես համաձայն չեմ", "Մասամբ համաձայն եմ",
            "Համաձայն եմ", "Լրիվ համաձայն եմ"};
    String[] harcEreq = {"Ընդհանրապես համաձայն չեմ", "Մասամբ համաձայն եմ",
            "Համաձայն եմ", "Լրիվ համաձայն եմ"};
    String[] harcChors = {"Ընդհանրապես համաձայն չեմ", "Մասամբ համաձայն եմ",
            "Համաձայն եմ", "Լրիվ համաձայն եմ"};
    String[] harcHing = {"Ընդհանրապես համաձայն չեմ", "Մասամբ համաձայն եմ",
            "Համաձայն եմ", "Լրիվ համաձայն եմ"};
    String[] harcVec = {"Ընդհանրապես համաձայն չեմ", "Մասամբ համաձայն եմ",
            "Համաձայն եմ", "Լրիվ համաձայն եմ"};
    String[] harcYot = {"Ընդհանրապես համաձայն չեմ", "Մասամբ համաձայն եմ",
            "Համաձայն եմ", "Լրիվ համաձայն եմ"};
    String[] harcUt = {"Ընդհանրապես համաձայն չեմ", "Մասամբ համաձայն եմ",
            "Համաձայն եմ", "Լրիվ համաձայն եմ"};
    String[] harcVerjnakan = {"Ոչ", "Տրամաբանություն չկա", "Այո"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_MODULI_GNAHATUM);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View modul = inflater.inflate(R.layout.moduli_gnahatum, container, false);
        mApiService = UtilsApi.getAPIService();
        session = new ResponseHandler(getActivity().getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getResponseDetails();
        System.out.println("start");

        String teacherName = user.get(ResponseHandler.TEACHER_NAME);
        String teacherSurname = user.get(ResponseHandler.TEACHER_SURNAME);


        teacherNameAndSurname = (TextView) modul.findViewById(R.id.teacherName);
        teacherNameAndSurname.setText(" Դուք պատրաստվում եք գնահատել դասախոս "+
                teacherName + "  " + teacherSurname + "-ին:" + "մոդուլում անցկացրած դասերի համար:" );


        ArrayAdapter<String> HarcMek = new ArrayAdapter<String>(modul.getContext(),
                R.layout.list_item, harcMek);
        MaterialBetterSpinner hMek = (MaterialBetterSpinner) modul.findViewById(R.id.harcMek);
        hMek.setAdapter(HarcMek);
        hMek.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String i = parent.getItemAtPosition(position).toString();
                System.out.println(i);
            }
        });
        hMek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
                System.out.println(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> HarcErku = new ArrayAdapter<String>(modul.getContext(),
                R.layout.list_item, harcErku);
        MaterialBetterSpinner hErku = (MaterialBetterSpinner) modul.findViewById(R.id.harcErku);
        hErku.setAdapter(HarcErku);
        hErku.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String i = parent.getItemAtPosition(position).toString();
                System.out.println(i);
            }
        });
        hErku.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> HarcEreq = new ArrayAdapter<String>(modul.getContext(),
                R.layout.list_item, harcEreq);
        MaterialBetterSpinner hEreq = (MaterialBetterSpinner) modul.findViewById(R.id.harcEreq);
        hEreq.setAdapter(HarcEreq);
        hEreq.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String i = parent.getItemAtPosition(position).toString();
                System.out.println(i);
            }
        });
        hEreq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> HarcChors = new ArrayAdapter<String>(modul.getContext(),
                R.layout.list_item, harcChors);
        MaterialBetterSpinner hChors = (MaterialBetterSpinner) modul.findViewById(R.id.harcChors);
        hChors.setAdapter(HarcChors);
        hChors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String i = parent.getItemAtPosition(position).toString();
                System.out.println(i);
            }
        });
        hChors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> HarcHing = new ArrayAdapter<String>(modul.getContext(),
                R.layout.list_item, harcHing);
        MaterialBetterSpinner hHing = (MaterialBetterSpinner) modul.findViewById(R.id.harcHing);
        hHing.setAdapter(HarcHing);
        hHing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String i = parent.getItemAtPosition(position).toString();
                System.out.println(i);
            }
        });
        hHing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> HarcVec = new ArrayAdapter<String>(modul.getContext(),
                R.layout.list_item, harcVec);
        MaterialBetterSpinner hVec = (MaterialBetterSpinner) modul.findViewById(R.id.harcVec);
        hVec.setAdapter(HarcVec);
        hVec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String i = parent.getItemAtPosition(position).toString();
                System.out.println(i);
            }
        });
        hVec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> HarcYot = new ArrayAdapter<String>(modul.getContext(),
                R.layout.list_item, harcYot);
        MaterialBetterSpinner hYot = (MaterialBetterSpinner) modul.findViewById(R.id.harcYot);
        hYot.setAdapter(HarcYot);
        hYot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String i = parent.getItemAtPosition(position).toString();
                System.out.println(i);
            }
        });
        hYot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> HarcUt = new ArrayAdapter<String>(modul.getContext(),
                R.layout.list_item, harcUt);
        MaterialBetterSpinner hUt = (MaterialBetterSpinner) modul.findViewById(R.id.harcUt);
        hUt.setAdapter(HarcUt);
        hUt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String i = parent.getItemAtPosition(position).toString();
                System.out.println(i);
            }
        });
        hUt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> HarcVerjnakan = new ArrayAdapter<String>(modul.getContext(),
                R.layout.list_item, harcVerjnakan);
        MaterialBetterSpinner hVerjnakan = (MaterialBetterSpinner) modul.findViewById(R.id.harcVerjin);
        hVerjnakan.setAdapter(HarcVerjnakan);
        hVerjnakan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String i = parent.getItemAtPosition(position).toString();
                System.out.println(i);
            }
        });
        hVerjnakan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return modul;
    }

}
