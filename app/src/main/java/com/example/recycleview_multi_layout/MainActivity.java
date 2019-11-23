package com.example.recycleview_multi_layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.recycleview_multi_layout.adapter.Adapter;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRvView;
    private Adapter mAdapter;
    private List<Model.ResultBean> mList = new ArrayList<>();
    private LinearLayoutManager mLayoutManager;

    //添加头部
    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(this).inflate(R.layout.item_head, view, false);
        mAdapter.setHeaderView(header);
    }

    //在RecycleView 中间添加布局
    private void setMiddle(RecyclerView view) {
        View middle = LayoutInflater.from(this).inflate(R.layout.item_middle, view, false);
        mAdapter.setMiddleView(middle);
    }

    //在RecycleView的任意位置插入布局
    private void setMiddle2(RecyclerView view) {
        View middle2 = LayoutInflater.from(this).inflate(R.layout.item_middle2, view, false);
        mAdapter.setMiddleView2(middle2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvView = findViewById(R.id.rv_test);
        mLayoutManager = new LinearLayoutManager(this);
        mRvView.setLayoutManager(new LinearLayoutManager(this));
        getData();

    }

    private void getData() {
        try {
            String result = getJson(MainActivity.this, "data.json");
            Gson gson = new Gson();
            Model dataMessage = gson.fromJson(result, Model.class);
            mList.addAll(dataMessage.getResult());
            mAdapter = new Adapter(mList, MainActivity.this);
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
