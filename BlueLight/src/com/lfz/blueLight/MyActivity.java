package com.lfz.blueLight;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;
import android.widget.Toast;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.WindowFeature;

@EActivity(R.layout.main)
@WindowFeature({Window.FEATURE_NO_TITLE,Window.FEATURE_INDETERMINATE_PROGRESS})
public class MyActivity extends FragmentActivity {

    private FragmentManager manager;
    private long mExitTime;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);

        manager = getSupportFragmentManager();
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
