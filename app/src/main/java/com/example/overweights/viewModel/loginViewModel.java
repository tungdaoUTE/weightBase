package com.example.overweights.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.overweights.data.model.data.User;
import com.example.overweights.data.model.request.LoginRequest;
import com.example.overweights.data.model.response.TokenResponse;
import com.example.overweights.data.network.APILogin;
import com.example.overweights.data.network.ServiceGenerator;
import com.example.overweights.utils.Commons;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginViewModel extends ViewModel {
    private APILogin apiLogin = ServiceGenerator.createService(APILogin.class);
    private APILogin apiLoginWithAuth = ServiceGenerator.createService(APILogin.class, Commons.tokenString);

    public MutableLiveData<TokenResponse> postLogin(LoginRequest loginRequest){
        final MutableLiveData<TokenResponse> newsData = new MutableLiveData<>();
        apiLogin.authentication(loginRequest).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if(response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {

            }
        });
        return newsData;
    }


    public MutableLiveData<User> getUserData(){
        final MutableLiveData<User> newsData = new MutableLiveData<>();
       apiLoginWithAuth.account().enqueue(new Callback<User>() {
           @Override
           public void onResponse(Call<User> call, Response<User> response) {
               if(response.isSuccessful()){
                   newsData.setValue(response.body());
               }
           }

           @Override
           public void onFailure(Call<User> call, Throwable t) {

           }
       });
        return newsData;
    }
}
