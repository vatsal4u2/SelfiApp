package anroid.selfiproject.com.selfi.login_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import anroid.selfiproject.com.selfi.R;
import anroid.selfiproject.com.selfi.api.ApiClient;
import anroid.selfiproject.com.selfi.api.ApiInterface;
import anroid.selfiproject.com.selfi.api.AppUtils;
import anroid.selfiproject.com.selfi.api.modal.RegistrationApi;
import anroid.selfiproject.com.selfi.api.modal.RegistrationSuccess;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class RegisterFragment extends Fragment implements View.OnClickListener {


    EditText email,password;
    Button registerButton;
    Toolbar mToolbar;
    ApiInterface apiInterface;

    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mToolbar = view.findViewById(R.id.toolbar);
        email = view.findViewById(R.id.email_field);
        password = view.findViewById(R.id.password_field);
        registerButton = view.findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        mToolbar.setTitle(R.string.toolbar_title_register_fr);

     apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.register_button:
                if(!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                    callRegisterUserApi();
                }else{
                    Toast.makeText(getContext(),"Please provide all details",Toast.LENGTH_LONG)
                            .show();
                }
                break;
        }
    }

    private void callRegisterUserApi() {
        Call<RegistrationSuccess> registerUserDataCall = apiInterface.createUser(new RegistrationApi("vatsal@vater.com","1234"));
        registerUserDataCall.enqueue(new Callback<RegistrationSuccess>() {
            @Override
            public void onResponse(Call<RegistrationSuccess> call, Response<RegistrationSuccess> response) {
                Toast.makeText(getContext(),response.body().getToken(),Toast.LENGTH_LONG)
                        .show();
                AppUtils.hideSoftKeyboad(getActivity());
                getActivity().onBackPressed();
            }

            @Override
            public void onFailure(@NonNull Call<RegistrationSuccess> call, Throwable t) {
                Log.d("Api-Error",t.getLocalizedMessage());
            }
        });
    }

}
