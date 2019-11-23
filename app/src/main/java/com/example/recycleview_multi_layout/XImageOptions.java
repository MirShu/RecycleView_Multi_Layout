package com.example.recycleview_multi_layout;

import android.widget.ImageView;

import org.xutils.common.util.DensityUtil;
import org.xutils.x;

public class XImageOptions {
    public static void  imageData(ImageView imageView,String url){
        org.xutils.image.ImageOptions imageOptions = new org.xutils.image.ImageOptions.Builder()
                .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))//图片大小
                .setRadius(DensityUtil.dip2px(5))//ImageView圆角半径
                .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
//                    .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setLoadingDrawableId(R.mipmap.emp)//加载中默认显示图片
                .setFailureDrawableId(R.mipmap.emp)//加载失败后默认显示图片
                .build();
        x.image().bind(imageView, url, imageOptions);
    }

}
