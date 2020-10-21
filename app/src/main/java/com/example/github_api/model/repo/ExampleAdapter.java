package com.example.github_api.model.repo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.github_api.MainActivity;
import com.example.github_api.R;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private  ArrayList<Repo> mExampleList;
    private MainActivity context;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mHeader;
        public TextView mStars;

        public ExampleViewHolder( View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mHeader = itemView.findViewById(R.id.header);
            mStars = itemView.findViewById(R.id.stars);
        }
    }
    public ExampleAdapter(ArrayList<Repo> exampleList, MainActivity mainActivity){
        mExampleList = exampleList;
        context = mainActivity;

    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
      ExampleViewHolder evh = new ExampleViewHolder(v);
      return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Repo currentItem = mExampleList.get(position);
        glideSetup(holder.mImageView, currentItem.getOwner());
        holder.mHeader.setText(currentItem.getTitle());
        holder.mStars.setText("Stars: " + String.valueOf(currentItem.getStars()));
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    void glideSetup(ImageView profilePic, String owner){
        Glide.with(context)
                .load(owner)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(profilePic);
    }
}
