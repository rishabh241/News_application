package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class customviewholder extends RecyclerView.ViewHolder {
    TextView text_head,sub_head;
    ImageView img_head;
    CardView cardView;
    public customviewholder(@NonNull View itemView) {
        super(itemView);
        text_head=itemView.findViewById(R.id.headline);
        sub_head=itemView.findViewById(R.id.subHeading);
        img_head=itemView.findViewById(R.id.image_news);
        cardView=itemView.findViewById(R.id.main_container);//may be show error

    }
}
