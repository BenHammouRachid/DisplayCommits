package com.exercice.commits.di.commitsapi;

import androidx.lifecycle.ViewModel;

import com.exercice.commits.di.ViewModelKey;
import com.exercice.commits.views.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel viewModel);
}
