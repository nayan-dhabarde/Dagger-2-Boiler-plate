package com.joshsoftware.dagger2boilerplate.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joshsoftware.dagger2boilerplate.di.viewmodel.DaggerViewModelFactory
import com.joshsoftware.dagger2boilerplate.di.viewmodel.ViewModelKey
import com.joshsoftware.dagger2boilerplate.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}