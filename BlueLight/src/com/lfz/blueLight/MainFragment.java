package com.lfz.blueLight;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/28 0028.
 */
@EFragment(R.layout.main_fragment)
public class MainFragment extends Fragment {

    @ViewById(R.id.main_viewPager)
    ViewPager mViewPager;

    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }

    private void initView(){
        mFragments.add(new BlueChatFragment_());

        mViewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragments.get(i);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
    }
}
