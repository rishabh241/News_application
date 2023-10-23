package com.example.myapplication;

import com.example.myapplication.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchData<NewsApiResponse> {
    void onFetchData(List<NewsHeadlines>newsHeadlines,String message);
    void onError(String message);

}
