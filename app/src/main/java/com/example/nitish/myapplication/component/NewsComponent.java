package com.example.nitish.myapplication.component;

import com.example.nitish.myapplication.NewsApi;
import com.example.nitish.myapplication.module.PicassoModule;
import com.example.nitish.myapplication.module.NewsModule;
import com.squareup.picasso.Picasso;

import dagger.Component;


@Component(modules = {NewsModule.class, PicassoModule.class})
public interface NewsComponent {

    NewsApi getNewsService();

    Picasso getPicasso();
}
