package com.example.nitish.myapplication.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nitish.myapplication.activity.ActivityWebview;

import com.example.nitish.myapplication.activity.MainActivity;

import com.example.nitish.myapplication.R;
import com.example.nitish.myapplication.modal.NewsModal;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.RandomUserViewHolder> {

    private final Picasso picasso;
    private final MainActivity mainActivity;
    private List<NewsModal.ArticlesBean> ItemModalList = new ArrayList<>();


    public NewsFeedAdapter(MainActivity mainActivity, Picasso picasso) {
        this.picasso = picasso;
        this.mainActivity = mainActivity;
    }

    @Override
    public RandomUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_random_user,
                parent, false);
        return new RandomUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RandomUserViewHolder holder, int position) {
        NewsModal.ArticlesBean itemModal = ItemModalList.get(position);
        holder.textView.setText(String.format("%s", itemModal.getTitle()));
        picasso.with(holder.imageView.getContext())
                .load(itemModal.getUrlToImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return ItemModalList.size();
    }

    public void setItems(List<NewsModal.ArticlesBean> ItemModals) {
        ItemModalList .addAll(ItemModals);
        notifyDataSetChanged();
    }

    public class RandomUserViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public RandomUserViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mainActivity,ActivityWebview.class);
                    intent.putExtra("url",ItemModalList.get(getLayoutPosition()).getUrl());
                    mainActivity.startActivity(intent);
                }
            });
        }
    }
}