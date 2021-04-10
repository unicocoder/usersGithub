package com.unicocoder.usergithub.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.unicocoder.usergithub.ApiServer.ApiClient;
import com.unicocoder.usergithub.model.User;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListViewModel extends ViewModel {

    private MutableLiveData<List<User>> listMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Integer> errorMutableLiveData = new MutableLiveData<>();

    public LiveData<List<User>> getListUser() {
        ApiClient.getInstance().getApiStack().getUserList().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NotNull Call<List<User>> call, @NotNull Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null)
                    listMutableLiveData.setValue(response.body());
                else
                    errorMutableLiveData.setValue(0);
            }

            @Override
            public void onFailure(@NotNull Call<List<User>> call, @NotNull Throwable t) {
                errorMutableLiveData.setValue(-1);
            }
        });
        return listMutableLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
