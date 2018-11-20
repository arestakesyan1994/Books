package com.example.infinity.prof.url;


import com.example.infinity.prof.model.Response;
import com.example.infinity.prof.model.Responses;

import java.util.List;

import javax.annotation.PostConstruct;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("get") //POJO
    Call<Response> loginRequest(@Field("login") String login,
                                @Field("password") String password);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

//    @POST("get?login=hj&password=ko")
    @POST("getTheory")
    Call<List<Responses>> theory();

//    @Headers({"Content-Type:text/html/charset=UTF-8"})
//    @GET("get")
//    Call<RequestBody> response(@Query("login") String  login,
//                               @Query("password") String password);

}
