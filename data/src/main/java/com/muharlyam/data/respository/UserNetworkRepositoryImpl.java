package com.muharlyam.data.respository;

import com.google.gson.Gson;
import com.muharlyam.data.retrofit.RetrofitService;
import com.muharlyam.domain.model.rest.CreateUserResponse;
import com.muharlyam.domain.model.wrappers.NetworkResult;
import com.muharlyam.domain.repository.UserNetworkRepository;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class UserNetworkRepositoryImpl implements UserNetworkRepository {

    private final RetrofitService retrofitService;
    private final String BASE_URL = "http://10.0.2.2:8080";
    private final Gson gson = new Gson();

    public UserNetworkRepositoryImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitService = retrofit.create(RetrofitService.class);
    }

    @Override
    public NetworkResult<CreateUserResponse> createUser(String idToken, String email) {
        NetworkResult<CreateUserResponse> result = new NetworkResult<>();
        final Call<ResponseBody> requestCall = retrofitService.googleSignUp(idToken, email);
        try {
            Response<ResponseBody> response = requestCall.execute();
            if (response.isSuccessful()) {
                result.setResult(gson.fromJson(response.body().string(), CreateUserResponse.class));
            } else {
                result.setNetworkException(response.code());
            }
        } catch (IOException e) {
            result.setException(e);
        }

        return result;
    }
}
