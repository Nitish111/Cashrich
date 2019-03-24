package com.example.nitish.myapplication.component;

import com.example.nitish.myapplication.NewsApi;
import com.example.nitish.myapplication.adapter.NewsFeedAdapter;
import com.example.nitish.myapplication.module.MinaActivityModule;

import dagger.Component;

@Component(dependencies = NewsComponent.class, modules = MinaActivityModule.class)
public interface MainActivityComponent {
    NewsFeedAdapter getUserAdapter();
    NewsApi getApi();

}
