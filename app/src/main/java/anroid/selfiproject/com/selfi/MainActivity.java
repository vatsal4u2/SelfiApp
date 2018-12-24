package anroid.selfiproject.com.selfi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import anroid.selfiproject.com.selfi.login_fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {

    FrameLayout mFrameLayout;
    LoginFragment mLoginFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrameLayout = findViewById(R.id.container);

        mLoginFragment = LoginFragment.newInstance();
        if(mLoginFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container,mLoginFragment)
                    .commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
