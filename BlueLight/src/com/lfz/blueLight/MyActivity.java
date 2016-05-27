package com.lfz.blueLight;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.Toast;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.SystemService;

@EActivity(R.layout.main)
public class MyActivity extends Activity {

    private FragmentManager manager;
    private long mExitTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);

        manager = getFragmentManager();
        showFragment(new WelcomeFragment_());
    }
    public void showFragment(Fragment fragment){
        manager.beginTransaction().replace(R.id.container,fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - mExitTime > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        }else{
            finish();
        }
    }
}
