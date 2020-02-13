package com.exercice.commits.views;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.exercice.commits.models.ListData;
import com.exercice.commits.network.CommitApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";


    private final CommitApi commitApi;

    private MediatorLiveData<List<ListData>> commitDatas = new MediatorLiveData<>();

    @Inject
    public MainViewModel(CommitApi commitApi) {
        this.commitApi = commitApi;
    }

    public void getCommits() {
        final LiveData<List<ListData>> source = LiveDataReactiveStreams.fromPublisher(
                commitApi.geCommits()
                        .subscribeOn(Schedulers.io()));

        commitDatas.addSource(source, new Observer<List<ListData>>() {
            @Override
            public void onChanged(List<ListData> commitData) {
                commitDatas.setValue(commitData);
                commitDatas.removeSource(source);
            }
        });
    }

    public LiveData<List<ListData>> observeUser() {
        return commitDatas;
    }

}
