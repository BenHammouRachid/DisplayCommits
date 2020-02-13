package com.exercice.commits.di.commitsapi;

import com.exercice.commits.network.CommitApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class MainModule {

    @Provides
    static CommitApi provideSessionApi(Retrofit retrofit) {
        return retrofit.create(CommitApi.class);
    }
}
