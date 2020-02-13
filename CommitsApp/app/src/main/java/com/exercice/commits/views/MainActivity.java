package com.exercice.commits.views;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.exercice.commits.R;
import com.exercice.commits.adapter.CommitAdapter;
import com.exercice.commits.models.DataToShow;
import com.exercice.commits.models.ListData;
import com.exercice.commits.viewmodels.ViewModelProviderFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    private static final String TAG = "MainActivity";

    private MainViewModel viewModel;

    @Inject
    ViewModelProviderFactory providerFactory;

    private RecyclerView recyclerView;

    private List<DataToShow> dataToShows;
    private CommitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recylerView);
        viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel.class);
        configureRecyclerView();
        subscribeObservers();
        getCommits();
    }

    private void subscribeObservers() {
        viewModel.observeUser().observe(this, new Observer<List<ListData>>() {
            @Override
            public void onChanged(List<ListData> commitData) {
                if (commitData != null) {
                    updateUI(commitData);
                }
            }
        });
    }

    private void getCommits() {
        viewModel.getCommits();
    }

    private void configureRecyclerView() {
        this.dataToShows = new ArrayList<>();
        this.adapter = new CommitAdapter(this.dataToShows);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    //String authorName, String authorAvatar, String commitMessage, String sha1)
    private void updateUI(List<ListData> listDatas) {
        for (ListData listData : listDatas) {

            dataToShows.add(new DataToShow(listData.getCommit().getAuthor().getName(),
                            "",
                    listData.getCommit().getMessage(),
                    ""
                    ));
        }
        adapter.notifyDataSetChanged();
    }
}
