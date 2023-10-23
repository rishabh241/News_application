package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class customAdapter extends RecyclerView.Adapter<customviewholder>{
    private Context context;
    private List<NewsHeadlines>headlines;
    private SelectListner selectListner;

    public customAdapter(Context context, List<NewsHeadlines> headlines, SelectListner selectListner) {
        this.context = context;
        this.headlines = headlines;
        this.selectListner= selectListner;
    }

    @NonNull
    @Override
    public customviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new customviewholder(LayoutInflater.from(context).inflate(R.layout.headline_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull customviewholder holder, int position) {
            holder.text_head.setText(headlines.get(position).getTitle());
            holder.sub_head.setText(headlines.get(position).getSource().getName());

            if (headlines.get(position).getUrlToImage()!=null){
                Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_head);
            }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectListner.OnNewsClick(headlines.get(position));
                }
            });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
