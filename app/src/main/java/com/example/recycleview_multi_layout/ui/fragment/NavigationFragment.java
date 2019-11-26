package com.example.recycleview_multi_layout.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.recycleview_multi_layout.R;
import com.example.recycleview_multi_layout.xutls.Constants;


/**
 * Created by linlin.1016@qq.com on 2017/04/25.
 * Description:
 */
public class NavigationFragment extends Fragment implements BottomNavigationBar.OnTabSelectedListener {


    private BottomNavigationBar mBottomNavigationBar;
    private HomeFragment mHomeFragment;
    private LocationFragment mLocationFragment;
    private LikeFragment mLikeFragment;
    private ShopCarFragment mShopCarFragment;
    private PersonFragment mPersonFragment;

    public static NavigationFragment newInstance(String s) {
        NavigationFragment navigationFragment = new NavigationFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        navigationFragment.setArguments(bundle);
        return navigationFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_navigation_bar, container, false);
        mBottomNavigationBar = view.findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.home_select, getString(R.string.item_home)).setInactiveIconResource(R.drawable.home_unselect).setActiveColorResource(R.color.colorPrimary).setInActiveColorResource(R.color.black_1))
                .addItem(new BottomNavigationItem(R.drawable.discover_selected, getString(R.string.item_location)).setInactiveIconResource(R.drawable.discover_unselected).setActiveColorResource(R.color.colorPrimary).setInActiveColorResource(R.color.black_1))
                .addItem(new BottomNavigationItem(R.drawable.infor_select, getString(R.string.item_like)).setInactiveIconResource(R.drawable.infor_unselect).setActiveColorResource(R.color.colorPrimary).setInActiveColorResource(R.color.black_1))
                .addItem(new BottomNavigationItem(R.drawable.icon_shop_car_selected, getString(R.string.item_shop_car)).setInactiveIconResource(R.drawable.icon_shop_car_unselected).setActiveColorResource(R.color.colorPrimary).setInActiveColorResource(R.color.black_1))
                .addItem(new BottomNavigationItem(R.drawable.user_select, getString(R.string.item_person)).setInactiveIconResource(R.drawable.user_unselect).setActiveColorResource(R.color.colorPrimary).setInActiveColorResource(R.color.black_1))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
        return view;
    }

    /**
     * set the default fagment
     * <p>
     * the content id should not be same with the parent content id
     */
    private void setDefaultFragment() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        HomeFragment homeFragment = mHomeFragment.newInstance(getString(R.string.item_home));
        transaction.replace(R.id.sub_content, homeFragment).commit();

    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance(getString(R.string.item_home));
                }
                beginTransaction.replace(R.id.sub_content, mHomeFragment);
                break;
            case 1:
                if (mLocationFragment == null) {
                    mLocationFragment = LocationFragment.newInstance(getString(R.string.item_location));
                }
                beginTransaction.replace(R.id.sub_content, mLocationFragment);
                break;
            case 2:
                if (mLikeFragment == null) {
                    mLikeFragment = LikeFragment.newInstance(getString(R.string.item_like));
                }
                beginTransaction.replace(R.id.sub_content, mLikeFragment);
                break;
            case 3:
                if (mShopCarFragment == null) {
                    mShopCarFragment = ShopCarFragment.newInstance(getString(R.string.item_shop_car));
                }
                beginTransaction.replace(R.id.sub_content, mShopCarFragment);
                break;

            case 4:
                if (mPersonFragment == null) {
                    mPersonFragment = PersonFragment.newInstance(getString(R.string.item_person));
                }
                beginTransaction.replace(R.id.sub_content, mPersonFragment);
                break;

        }
        beginTransaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
