package com.exercice.commits.di;

import com.exercice.commits.di.commitsapi.MainModule;
import com.exercice.commits.di.commitsapi.MainViewModelsModule;
import com.exercice.commits.views.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class, MainModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
