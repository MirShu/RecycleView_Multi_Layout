package com.example.recycleview_multi_layout.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.recycleview_multi_layout.R;
import com.example.recycleview_multi_layout.ui.fragment.main_fragment.MainHomeFragment;
import com.example.recycleview_multi_layout.xutls.Constants;
import com.example.recycleview_multi_layout.xutls.HorizontalScrollViewEx;

/**
 * Created by SeanLim on 2019/11/27.
 * Company by Shanghai observer information technology Co., Ltd.
 * E-mail linlin.1016@qq.com
 */
public class NewsFragment extends Fragment {
    private View mRootView;
    private HorizontalScrollViewEx scrollViewEx;
    private DisplayMetrics dm;
    private ViewPager viewPager;

    public static NewsFragment newInstance(String s) {
        NewsFragment mainHomeFragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        mainHomeFragment.setArguments(bundle);
        return mainHomeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.home_fragment_news, null);
        dm = getResources().getDisplayMetrics();
        viewPager = mRootView.findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(8);
        scrollViewEx = mRootView.findViewById(R.id.tabs);
        viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
        scrollViewEx.setViewPager(viewPager);
        setTabsValue();
        return mRootView;
    }



    /**
     * 对HorizontalScrollViewEx的各项属性进行赋值。
     */
    private void setTabsValue() {
        scrollViewEx.setShouldExpand(false);
        scrollViewEx.setDividerColor(Color.TRANSPARENT);
        scrollViewEx.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 15, dm));
        scrollViewEx.setSelectedTextColor(Color.parseColor("#d1d1d1"));
        scrollViewEx.setTabBackground(0);
    }


    public class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private final String[] titles = {"头条", "社会", "国内", "国际", "娱乐", "体育", "科技", "财经", "时尚"};

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Fragment getItem(int position) {
            return MainHomeFragment.newInstance(position);
        }
    }

}
