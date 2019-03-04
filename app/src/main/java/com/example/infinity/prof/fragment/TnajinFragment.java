package com.example.infinity.prof.fragment;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.handler.MyExceptionHandler;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.model.Homework;
import com.example.infinity.prof.model.ModulesItem;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class TnajinFragment extends Fragment {

    ApiService mApiService;
    private Spinner spinner1;
    private Spinner spinner2;
    ResponseHandler session;

    private Handler mHandler;
    Button gnahatakanner;
    TextView comment;
    public static int KEY;
    String number;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_TNAYIN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View tn = inflater.inflate(R.layout.fragment_tnajin, container, false);


        spinner1 = (Spinner) tn.findViewById(R.id.spinner1);
        final List<String> module = new ArrayList<String>();
        final List<String> moduleId = new ArrayList<String>();
        session = new ResponseHandler(getActivity().getApplicationContext());
        session.checkLogin();

        HashMap<String, String> user = session.getResponseDetails();
        System.out.println("start");

        String name = user.get(ResponseHandler.RESPONSE_NAME);
        String surname = user.get(ResponseHandler.RESPONSE_SURNAME);
        String image = user.get(ResponseHandler.RESPONSE_PHOTO);
        String rating = user.get(ResponseHandler.RESPONSE_AVG);
        String xumbs = user.get(ResponseHandler.RESPONSE_GROUP_ID);
        String modules = user.get(ResponseHandler.MODULES_ID);
        System.out.println(xumbs);
        mApiService = UtilsApi.getAPIService();

        mApiService.modulse().enqueue(new Callback<List<ModulesItem>>() {
            @Override
            public void onResponse(Call<List<ModulesItem>> call, final retrofit2.Response<List<ModulesItem>> response) {
                System.out.println("hghgghghg");
                System.out.println(response.body());
                for (int i = 0; i < response.body().size(); i++) {
                    String id = String.valueOf(response.body().get(i).getId());
                    String name = response.body().get(i).getName();

                    module.add(name);
                    moduleId.add(id);
                }
                System.out.println(module);
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_item, module);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(dataAdapter);
                String n = spinner1.getSelectedItem().toString();
                System.out.println(n);
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String n = parent.getItemAtPosition(position).toString();
                        number = moduleId.get((int) id);
                        spinner2 = (Spinner) tn.findViewById(R.id.spinner2);
                        final List<String> lessonsContent = new ArrayList<String>();
                        final List<String> userId = new ArrayList<String>();
                        final List<String> contents = new ArrayList<String>();
                        final List<String> comments = new ArrayList<String>();
                        final List<String> commentDate = new ArrayList<String>();

                        System.out.println(number);
                        String groupid = "83";
                        mApiService = UtilsApi.getAPIService();
// ժամանակավորապես xumbs կգրենք փոխարեն groupid
                        mApiService.homework(number, xumbs)
                                .enqueue(new Callback<Homework>() {
                                             @Override
                                             public void onResponse(Call<Homework> call, retrofit2.Response<Homework> responses) {
                                                 System.out.println(responses.body().getLessons());
                                                 for (int i = 0; i < responses.body().getLessons().size(); i++) {
                                                     String lessonContent = responses.body().getLessons().get(i).getLessonContent();
                                                     for (int j = 0; j < responses.body().getLessons().get(i).getHomeworks().size(); j++) {
                                                         String homeContent = responses.body().getLessons().get(i).getHomeworks().get(j).getContent();

                                                         contents.add(homeContent);
                                                     }
                                                     for (int j = 0; j < responses.body().getLessons().get(i).getComments().size(); j++) {
                                                         String comUserId = responses.body().getLessons().get(i).getComments().get(j).getUserId();
                                                         String comComment = responses.body().getLessons().get(i).getComments().get(j).getComment();
                                                         String comDate = responses.body().getLessons().get(i).getComments().get(j).getDate();

                                                         userId.add(comUserId);
                                                         comments.add(comUserId + ", " + comComment);
                                                         commentDate.add(comDate);
                                                     }
                                                     lessonsContent.add(lessonContent);

                                                     ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                                                             android.R.layout.simple_spinner_item, lessonsContent);
                                                     dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                                     spinner2.setAdapter(dataAdapter);
                                                     spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                         @RequiresApi(api = Build.VERSION_CODES.N)
                                                         @Override
                                                         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                             String n = parent.getItemAtPosition(position).toString();
                                                             comment = tn.findViewById(R.id.comment);
                                                             String str = "<a>This is a  <font color='blue'> blue text</font> and this is a <font color='red'> red text</font> </a>";
                                                             comment.setText(Html.fromHtml(contents.get((int) id)));

                                                             System.out.println("lessons Content");
                                                             System.out.println(lessonsContent.get((int) id));
                                                             System.out.println("user id");
                                                             System.out.println(userId.get((int) id));
                                                             System.out.println("contents");
                                                             System.out.println(contents.get((int) id));
                                                             System.out.println("comments");
                                                             System.out.println(comments.get((int) id));

                                                         }

                                                         @Override
                                                         public void onNothingSelected(AdapterView<?> parent) {

                                                         }
                                                     });
                                                 }
                                             }

                                             @Override
                                             public void onFailure(Call<Homework> call, Throwable t) {

                                             }
                                         }
                                );
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onFailure(Call<List<ModulesItem>> call, Throwable t) {

            }
        });

        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler(getActivity()));
        if (getActivity().getIntent().getBooleanExtra("crash", false)) {
            Toast.makeText(getActivity(), "App restarted after crash", Toast.LENGTH_SHORT).show();
        }
        return tn;
    }

    public void crashMe(View v) {
        throw new NullPointerException();
    }

}