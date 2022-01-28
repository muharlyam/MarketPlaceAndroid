package com.muharlyam.data.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {

    @POST("/api/v1/user/auth/google/signup")
    Call<ResponseBody> googleSignUp(@Query("idToken") String idToken, @Query("email") String email);

}
