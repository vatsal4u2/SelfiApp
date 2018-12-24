package anroid.selfiproject.com.selfi.login_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import anroid.selfiproject.com.selfi.R;

public class LoginFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = LoginFragment.class.getSimpleName();
    Button mLoginButton;
    TextView mSignUpText;
    Toolbar mToolbar;


    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLoginButton = view.findViewById(R.id.login_button);
        mSignUpText = view.findViewById(R.id.sign_up_text);
        mToolbar = view.findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.toolbar_title_login_fr);
        mLoginButton.setOnClickListener(this);
        mSignUpText.setOnClickListener(this);

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
            case R.id.login_button:
                loginAction();
                break;
            case R.id.sign_up_text:
                signUpAction();
                break;
        }
    }

    private void loginAction(){}

    private void  signUpAction(){
        RegisterFragment registerFragment = RegisterFragment.newInstance();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,registerFragment)
                .addToBackStack(LoginFragment.class.getName())
                .commit();
    }
}
