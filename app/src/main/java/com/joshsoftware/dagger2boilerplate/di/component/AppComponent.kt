package com.joshsoftware.dagger2boilerplate.di.component

import android.app.Application
import com.joshsoftware.dagger2boilerplate.MyApplication
import com.joshsoftware.dagger2boilerplate.di.modules.ActivityModule
import com.joshsoftware.dagger2boilerplate.di.modules.AppModule
import com.joshsoftware.dagger2boilerplate.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by Nayan Dhabarde
 *
 * When compiled Dagger will generate a class named DaggerAppComponent which will have all dependencies in it
 * The dagger annotation [Component] takes array of modules as parameter each of which will have the required
 * object/dependency which needs to be injected in activity, viewmodel, repository, etc..
 */
@Component(modules = [
    AndroidInjectionModule::class, // A dagger module only for Android framework
    AppModule::class,  // Module containing all dependencies/objects like retrofit, shared, preferences and room database
    ActivityModule::class,  // Module with a list of activities in which you need to inject
    ViewModelModule::class  // Module with a list of viewmodels in which you need to inject (This module also contains a ViewModelFactory)
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApplication) // Recommended not to replace MyApplication with just Application
}