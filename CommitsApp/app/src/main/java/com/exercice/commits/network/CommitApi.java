package com.exercice.commits.network;

import com.exercice.commits.models.ListData;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface CommitApi {


    ///repos/:owner/:repo/commits
    @GET("/repos/torvalds/linux/commits")
    Flowable<List<ListData>> geCommits();

}
