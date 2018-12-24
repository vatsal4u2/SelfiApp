package anroid.selfiproject.com.selfi.api.modal;

import com.google.gson.annotations.SerializedName;

public class RegistrationSuccess {

    @SerializedName("token")
    private String token;

    public RegistrationSuccess(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
