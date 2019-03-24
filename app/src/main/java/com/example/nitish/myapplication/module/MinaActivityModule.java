package com.example.nitish.myapplication.module;

import com.example.nitish.myapplication.activity.MainActivity;
import com.example.nitish.myapplication.adapter.NewsFeedAdapter;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class MinaActivityModule {
    private final MainActivity mainActivity;
    public MinaActivityModule(MainActivity mainActivityModule)
    {
        mainActivity = mainActivityModule;
    }
    @Provides
    public NewsFeedAdapter getAdapter(Picasso picasso)
    {
        return new NewsFeedAdapter(mainActivity, picasso);
    }
}
