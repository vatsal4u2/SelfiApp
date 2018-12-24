package anroid.selfiproject.com.selfi;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

public class SelfyApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}
