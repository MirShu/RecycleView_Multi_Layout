package com.example.recycleview_multi_layout.ui.fragment.main_fragment;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_multi_layout.R;
import com.example.recycleview_multi_layout.adapter.Adapter;
import com.example.recycleview_multi_layout.base.Api;
import com.example.recycleview_multi_layout.model.NewsModel;
import com.example.recycleview_multi_layout.model.ResultModel;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linlin.1016@qq.com on 2017/04/25.
 * Description:
 */

public class MainHomeFragment extends Fragment {
    private RecyclerView mRvView;
    private View mRootView;
    private Adapter mAdapter;
    private List<ResultModel.ResultBean> mList = new ArrayList<>();
    private static final String ARG_POSITION = "position";
    private int positionType;
    private String type;

    public static MainHomeFragment newInstance(int position) {
        MainHomeFragment newsChannelFragment = new MainHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_POSITION, position);
        newsChannelFragment.setArguments(bundle);
        return newsChannelFragment;
    }

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


    //类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
        positionType = getArguments().getInt(ARG_POSITION);
        mRvView = mRootView.findViewById(R.id.home_news_rview);
        mRvView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (positionType == 0) {
            type = "top";
        } else if (positionType == 1) {
            type = "shehui";
        } else if (positionType == 2) {
            type = "guonei";
        } else if (positionType == 3) {
            type = "guoji";
        } else if (positionType == 4) {
            type = "yule";
        } else if (positionType == 5) {
            type = "tiyu";
        } else if (positionType == 6) {
            type = "junshi";
        } else if (positionType == 7) {
            type = "keji";
        } else if (positionType == 8) {
            type = "caijing";
        } else if (positionType == 9) {
            type = "shishang";
        }
        getData(type);
        return mRootView;
    }
    private void getData(String newsType) {
        RequestParams params = new RequestParams(Api.TOUTIAO);
        params.addBodyParameter("key=",Api.USERKEY);
        params.addBodyParameter("type=",newsType);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                NewsModel newsModel = gson.fromJson(result, NewsModel.class);

                Log.i("ResultModel",newsModel.getResult().getData().get(0).getAuthor_name());

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.i("ResultModel",cex.toString());
            }

            @Override
            public void onFinished() {
            }
        });


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
        } catch (Exception e) {

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
