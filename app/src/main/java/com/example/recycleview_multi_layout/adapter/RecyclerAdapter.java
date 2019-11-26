package com.example.recycleview_multi_layout.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_multi_layout.R;
import com.example.recycleview_multi_layout.model.Model;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Model> mModelList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruitname);
        }

    }

    public RecyclerAdapter(List<Model> modelList) {
        mModelList = modelList;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type7, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Model model = mModelList.get(position);
        holder.fruitImage.setImageResource(model.getImageId());
        holder.fruitName.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }
}