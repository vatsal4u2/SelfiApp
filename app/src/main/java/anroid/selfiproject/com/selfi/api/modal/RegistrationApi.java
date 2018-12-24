package anroid.selfiproject.com.selfi.api.modal;

import com.google.gson.annotations.SerializedName;

public class RegistrationApi {

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    public RegistrationApi(){}

    public RegistrationApi(String p_email, String p_password){
        this.email = p_email;
        this.password = p_password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

}
