package com.example.infinity.prof.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.model.StudentsItem;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class KargavorumnerFragment extends Fragment {

    final int PICK_IMAGE_REQUEST = 234;
    private Uri filePath;
    private ImageView teacherImageView;
    private Button showChooserBtn, sendToMySQLBtn;
    private ProgressBar uploadProgressBar;
    ApiService mApiService;

    String[] OR_SKSAC = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    String[] OR_SKSAC2 = {};

    public class MyUploader {

        private final Context c;

        public MyUploader(Context c) {
            this.c = c;
        }

        public void upload(StudentsItem s, final View... inputViews) {
            if (s == null) {
                Toast.makeText(c, "No Data To Save", Toast.LENGTH_SHORT).show();
            } else {
                File imageFile;
                try {
                    imageFile = new File(getImagePath(filePath));

                } catch (Exception e) {
                    Toast.makeText(c, "Please pick an Image From Right Place, maybe Gallery or File Explorer so that we can get its path." + e.getMessage(), Toast.LENGTH_LONG).show();
                    return;
                }

                uploadProgressBar.setVisibility(View.VISIBLE);
                mApiService = UtilsApi.getAPIService();

                AndroidNetworking.upload(String.valueOf(mApiService))
                        .addMultipartFile("image", imageFile)
                        .addMultipartParameter("name", "upload")
                        .setTag("MYSQL_UPLOAD")
                        .setPriority(Priority.HIGH)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                if (response != null) {
                                    try {
                                        //SHOW RESPONSE FROM SERVER
                                        String responseString = response.get("message").toString();
                                        Toast.makeText(c, "PHP SERVER RESPONSE : " + responseString, Toast.LENGTH_LONG).show();

                                        if (responseString.equalsIgnoreCase("Success")) {
                                            //RESET VIEWS
                                            ImageView teacherImageView = (ImageView) inputViews[2];

                                            teacherImageView.setImageResource(R.drawable.placeholder);

                                        } else {
                                            Toast.makeText(c, "PHP WASN'T SUCCESSFUL. ", Toast.LENGTH_LONG).show();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        Toast.makeText(c, "JSONException " + e.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(c, "NULL RESPONSE. ", Toast.LENGTH_LONG).show();
                                }
                                uploadProgressBar.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError(ANError error) {
                                error.printStackTrace();
                                uploadProgressBar.setVisibility(View.GONE);
                                Toast.makeText(c, "UNSUCCESSFUL :  ERROR IS : \n" + error.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        }
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image To Upload"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
                teacherImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getImagePath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
        if (cursor == null) {
            return null;
        }
        int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String s = cursor.getString(columnIndex);
        cursor.close();
        return s;
    }

    private boolean validateData() {

        if (filePath == null) {
            return false;
        }

        return true;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_KARGAVORUMNER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View karg = inflater.inflate(R.layout.fragment_kargavorumner, container, false);

        showChooserBtn = (Button) karg.findViewById(R.id.chooseBtn);
        sendToMySQLBtn = (Button) karg.findViewById(R.id.sendBtn);
        teacherImageView = (ImageView) karg.findViewById(R.id.imageView);
        uploadProgressBar = (ProgressBar) karg.findViewById(R.id.myProgressBar);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(karg.getContext(),
                android.R.layout.simple_dropdown_item_1line, OR_SKSAC);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) karg.findViewById(R.id.or_sksvac);
        betterSpinner.setAdapter(arrayAdapter);
        betterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(karg.getContext(),
                android.R.layout.simple_dropdown_item_1line, OR_SKSAC2);
        MaterialBetterSpinner betterSpinner2 = (MaterialBetterSpinner) karg.findViewById(R.id.or_sksvac2);
        betterSpinner2.setAdapter(arrayAdapter2);

//        int i  = Integer.parseInt(arrayAdapter.toString());
//        String a1 = String.valueOf(i + 1);
//        String a2 = String.valueOf(i + 2);
//        String a3 = String.valueOf(i + 3);
//        String a4 = String.valueOf(i + 4);
//        String a5 = String.valueOf(i + 5);
//
//        String[] OR_SKSAC2 = {a1,a2,a3,a4,a5};
//        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line,OR_SKSAC2);
//        MaterialBetterSpinner betterSpinner2 = (MaterialBetterSpinner) findViewById(R.id.or_sksvac2);
//        betterSpinner2.setAdapter(arrayAdapter2);


        showChooserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser();

            }
        });

        sendToMySQLBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateData()) {
//                    new MyUploader(ChooseActivity.this).upload(s, teacherImageView);
                } else{

                }
            }
        });


        return karg;
    }

}
