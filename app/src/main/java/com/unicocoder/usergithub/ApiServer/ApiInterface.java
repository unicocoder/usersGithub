package com.unicocoder.usergithub.ApiServer;

import com.unicocoder.usergithub.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("users")
    Call<List<User>> getUserList();
}
    