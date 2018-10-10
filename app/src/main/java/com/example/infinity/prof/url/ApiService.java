package com.example.infinity.prof.url;


import com.example.infinity.prof.model.StudentsItem;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("get") //POJO
    Call<StudentsItem> loginRequest(@Field("login") String login,
                                    @Field("password") String password);

}
