package com.example.recycleview_multi_layout.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_multi_layout.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.youth.banner.Banner;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    public ImageView headlineImg, headlineImg2, headlineImg3;
    public TextView title,sourceTitle, sourceSummary,summary;
    public RoundedImageView sourceImage;
    public Banner banner;
    public RecyclerView recyclerView;


    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        headlineImg = itemView.findViewById(R.id.headline_img);
        headlineImg2 = itemView.findViewById(R.id.headline_img2);
        headlineImg3 = itemView.findViewById(R.id.headline_img3);
        sourceImage = itemView.findViewById(R.id.source_image);


        title = itemView.findViewById(R.id.title);
        sourceTitle = itemView.findViewById(R.id.source_title);
        sourceSummary = itemView.findViewById(R.id.source_summary);
        summary = itemView.findViewById(R.id.summary);

        banner = itemView.findViewById(R.id.banner);
        recyclerView= itemView.findViewById(R.id.recyclerView);
    }
}
