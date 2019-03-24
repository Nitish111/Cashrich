package com.example.nitish.myapplication;

import android.app.Activity;
import android.app.Application;

import com.example.nitish.myapplication.component.DaggerNewsComponent;
import com.example.nitish.myapplication.component.NewsComponent;
import com.example.nitish.myapplication.module.ContextModule;

public class App extends Application {

    private NewsComponent randomUserComponent;

    public static App get(Activity activity){
        return (App) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        randomUserComponent = DaggerNewsComponent.builder().contextModule(new ContextModule(this)).build();
    }
    public NewsComponent getNewsComponent()
    {
        return randomUserComponent;
    }
}
