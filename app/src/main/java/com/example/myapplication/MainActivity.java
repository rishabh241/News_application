package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Models.NewsApiResponse;
import com.example.myapplication.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListner, View.OnClickListener{
    RecyclerView recyclerView;
    customAdapter adapter;
    ProgressDialog dialog;
    Button business,entertainment,general,health,science,sports,technology;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog =new ProgressDialog(this);
        dialog.setTitle("Fetching");
        dialog.show();

        business=findViewById(R.id.btn1);
        entertainment=findViewById(R.id.btn2);
        general=findViewById(R.id.btn3);
        health=findViewById(R.id.btn4);
        science=findViewById(R.id.btn5);
        sports=findViewById(R.id.btn6);
        technology=findViewById(R.id.btn7);

        business.setOnClickListener(this);
        entertainment.setOnClickListener(this);
        general.setOnClickListener(this);
        health.setOnClickListener(this);
        science.setOnClickListener(this);
        sports.setOnClickListener(this);
        technology.setOnClickListener(this);

        RequestManager requestManager = new RequestManager(this);
        requestManager.getNewsHeadlines(listner,"sports",null);
    }
    private final OnFetchData<NewsApiResponse> listner= new OnFetchData<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> newsHeadlines, String message) {
            showNews(newsHeadlines);
            dialog.hide();
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new customAdapter(this,list,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClick(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivity.this, DetailAct.class)
                .putExtra("Data",headlines));
    }

    @Override
    public void onClick(View v) {
        Button button=(Button) v;
        String category = button.getText().toString();
        dialog.setTitle("Fetching");
        dialog.show();
        RequestManager requestManager = new RequestManager(this);
        requestManager.getNewsHeadlines(listner,category,null);
    }
}