package com.example.nitish.myapplication.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.nitish.myapplication.App;
import com.example.nitish.myapplication.NewsApi;
import com.example.nitish.myapplication.R;
import com.example.nitish.myapplication.adapter.NewsFeedAdapter;
import com.example.nitish.myapplication.component.DaggerMainActivityComponent;
import com.example.nitish.myapplication.component.MainActivityComponent;
import com.example.nitish.myapplication.modal.NewsModal;
import com.example.nitish.myapplication.module.MinaActivityModule;
import com.example.nitish.myapplication.utils.Constants;
import com.example.nitish.myapplication.utils.EndlessRecyclerOnScrollListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    NewsApi newsApi;
    RecyclerView recyclerView;
    NewsFeedAdapter mAdapter;
    int page = 1 , pageSize = 10;
    EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.new_feed);

        MainActivityComponent daggerRandomUserComponent = DaggerMainActivityComponent.builder()
                .minaActivityModule(new MinaActivityModule(this))
                .newsComponent(App.get(this).getNewsComponent())
                .build();

        mAdapter = (daggerRandomUserComponent).getUserAdapter();
        newsApi = (daggerRandomUserComponent).getApi();
        initViews();
        populateUsers(page);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(recyclerView.getLayoutManager()) {
            @Override
            public void onLoadMore(int current) {
                page++;
                populateUsers(page);

            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


            }
        };
        recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);
        recyclerView.setAdapter(mAdapter);
    }

    private void populateUsers(int page) {
        if(!Constants.isInternetAvailable(this)) {
            Toast.makeText(this, "Internet is not working", Toast.LENGTH_SHORT).show();
            return;
        }
        Call<NewsModal> randomUsersCall = getRandomUserService().getNews(Constants.COUNTRY,Constants.API_KEY,page,pageSize);
        randomUsersCall.enqueue(new Callback<NewsModal>() {
            @Override
            public void onResponse(Call<NewsModal> call, @NonNull Response<NewsModal> response) {
                if(response.isSuccessful()) {
                    mAdapter.setItems(response.body().getArticles());

                }
            }

            @Override
            public void onFailure(Call<NewsModal> call, Throwable t) {
                Timber.i(t.getMessage());
            }
        });
    }
    public NewsApi getRandomUserService(){
        return newsApi;
    }
}
