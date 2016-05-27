package com.lfz.blueLight;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/27 0027.
 */

@EFragment(R.layout.welcome_fragment)
public class WelcomeFragment extends Fragment {

    @ViewById(R.id.viewPager)
    ViewPager mViewPager;
    private int[] mImgIds = new int[]{R.drawable.guide_image1,R.drawable.guide_image2,R.drawable.guide_image3};
    private List<ImageView> mImages = new ArrayList<>();

    @Override
    public void onResume() {
        super.onResume();

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mImgIds.length;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(getActivity());
                imageView.setImageResource(mImgIds[position]);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(imageView);
                mImages.add(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImages.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }
        });

    }
}
