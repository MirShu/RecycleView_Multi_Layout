package com.example.recycleview_multi_layout.adapter;


import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycleview_multi_layout.Model;
import com.example.recycleview_multi_layout.R;
import com.example.recycleview_multi_layout.RecyclerAdapter;
import com.example.recycleview_multi_layout.XImageOptions;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class BaseBindViewHolder {

    public void onBindViewHolder0(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.response01);
        list.add(R.mipmap.response02);
        list.add(R.mipmap.response03);
        list.add(R.mipmap.response04);
        list.add(R.mipmap.response05);
        list.add(R.mipmap.response06);
        ((BaseViewHolder) holder).banner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    private List<Fruit> fruitList = new ArrayList<>();

    public void onBindTYPE_MIDDLE_TWO(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans, Context context) {
        initFruits();

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        ((BaseViewHolder) holder).recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(fruitList);
        ((BaseViewHolder) holder).recyclerView.setAdapter(adapter);

    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("秋～长腿梦梦", R.mipmap.response01);
            fruitList.add(apple);
            Fruit banana = new Fruit("星源汤圆", R.mipmap.response02);
            fruitList.add(banana);
            Fruit orange = new Fruit("秋~杨嘉", R.mipmap.response03);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("秋~芳丫头", R.mipmap.response04);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("c_没人疼", R.mipmap.response05);
            fruitList.add(pear);
            Fruit grape = new Fruit("CJ~花花", R.mipmap.response06);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("c_没人疼", R.mipmap.response01);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("c_没人疼", R.mipmap.response01);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("星源汤圆", R.mipmap.response01);
            fruitList.add(cherry);
            Fruit mango = new Fruit("星源汤圆", R.mipmap.response01);
            fruitList.add(mango);

        }
    }


    public void onBindViewHolder1(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());
        if (!TextUtils.isEmpty(listBeans.get(pos).getHeadline_img())) {
            XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        } else {
            XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, "http://liveimg.miaobolive.com/pic/avator/201910/26/15/E31ED19F926F874063215984_640.png");
        }


    }

    public void onBindViewHolder2(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg2, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg3, listBeans.get(pos).getHeadline_img());

    }

    public void onBindViewHolder3(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());
        ((BaseViewHolder) holder).summary.setText(listBeans.get(pos).getSummary());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());

    }

    public void onBindViewHolder4(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());

        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg2, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg3, listBeans.get(pos).getHeadline_img());

    }


    public void onBindViewHolder5(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());

        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg2, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg3, listBeans.get(pos).getHeadline_img());

    }

    public void onBindViewHolder6(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());
        ((BaseViewHolder) holder).sourceTitle.setText(listBeans.get(pos).getSource_data().getTitle());
        ((BaseViewHolder) holder).sourceSummary.setText(listBeans.get(pos).getSource_data().getSummary());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).sourceImage, listBeans.get(pos).getSource_data().getImage());

    }


    public void onBindViewHolder7(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());


        if (TextUtils.isEmpty(listBeans.get(pos).getHeadline_img())||listBeans.get(pos).getHeadline_img()==null) {
            XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, "http://2-im.guokr.com/BL-zs0S2cMtowORGmuKri_mYXjze4UY0ZkX-WGWn5Ug4BAAAvAEAAEpQ.jpg?imageView2/1/w/1080/h/444");

        } else {

            XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        }

    }


    // 获取条目的真实位置
    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        if (position < 5) {
            return position - 1;
        }
        if (position > 5 && position < 10) {
            return position - 2;
        } else {
            return position - 3;
        }

    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }
    }


}
