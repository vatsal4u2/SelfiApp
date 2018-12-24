package anroid.selfiproject.com.selfi.api;

import anroid.selfiproject.com.selfi.api.modal.RegistrationApi;
import anroid.selfiproject.com.selfi.api.modal.RegistrationSuccess;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/api/register")
    Call<RegistrationSuccess> createUser(@Body RegistrationApi userData);
}
