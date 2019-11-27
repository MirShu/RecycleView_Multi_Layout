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
 * Created by linlin.1016@qq.com on 2017/04/25.
 * Description:
 */

public class MainChatFragment extends Fragment {
    public static MainChatFragment newInstance(String s) {
        MainChatFragment homeFragment = new MainChatFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like, container, false);
        return view;
    }
}
