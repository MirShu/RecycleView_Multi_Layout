package com.example.recycleview_multi_layout.ui.fragment;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_multi_layout.R;
import com.example.recycleview_multi_layout.adapter.Adapter;
import com.example.recycleview_multi_layout.model.ResultModel;
import com.example.recycleview_multi_layout.xutls.Constants;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linlin.1016@qq.com on 2017/04/25.
 * Description:
 */

public class HomeFragment extends Fragment {
    private RecyclerView mRvView;
    private Adapter mAdapter;
    private List<ResultModel.ResultBean> mList = new ArrayList<>();
    private LinearLayoutManager mLayoutManager;


    //添加头部
    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.item_head, view, false);
        mAdapter.setHeaderView(header);
    }

    //在RecycleView 中间添加布局
    private void setMiddle(RecyclerView view) {
        View middle = LayoutInflater.from(getActivity()).inflate(R.layout.item_middle, view, false);
        mAdapter.setMiddleView(middle);
    }

    //在RecycleView的任意位置插入布局
    private void setMiddle2(RecyclerView view) {
        View middle2 = LayoutInflater.from(getActivity()).inflate(R.layout.item_middle2, view, false);
        mAdapter.setMiddleView2(middle2);
    }

    public static HomeFragment newInstance(String s) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        mRvView = view.findViewById(R.id.rv_test);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRvView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getData();
        return view;
    }

    private void getData() {
        try {
            String result = getJson(getActivity(), "data.json");
            Gson gson = new Gson();
            ResultModel dataMessage = gson.fromJson(result, ResultModel.class);
            mList.addAll(dataMessage.getResult());
            mAdapter = new Adapter(mList, getActivity());
            mRvView.setAdapter(mAdapter);
            setHeader(mRvView);
            setMiddle(mRvView);
            setMiddle2(mRvView);
            mAdapter.notifyDataSetChanged();
        }catch (Exception e){

        }
    }


    /**
     * 得到json文件中的内容
     *
     * @param context
     * @param fileName
     * @return
     */
    public static String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(fileName), "utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
