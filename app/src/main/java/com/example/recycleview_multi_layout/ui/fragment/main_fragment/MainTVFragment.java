package com.example.recycleview_multi_layout.ui.fragment.main_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.recycleview_multi_layout.R;
import com.example.recycleview_multi_layout.xutls.Constants;

/**
 * Created by SeanLim on 2019/11/26.
 * Company by Shanghai observer information technology Co., Ltd.
 * E-mail linlin.1016@qq.com
 */
public class MainTVFragment extends Fragment {

    public static MainTVFragment newInstance(String s) {
        MainTVFragment homeFragment = new MainTVFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_car, container, false);
        return view;
    }

}
