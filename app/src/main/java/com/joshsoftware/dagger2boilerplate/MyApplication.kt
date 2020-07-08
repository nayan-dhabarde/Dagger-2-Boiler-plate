package com.joshsoftware.dagger2boilerplate

import android.app.Activity
import android.app.Application
import com.joshsoftware.dagger2boilerplate.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created By Nayan Dhabarde
 * @property dispatchingAndroidInjector DispatchingAndroidInjector<Activity>
 */
class MyApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        /* Injects dependencies in all the activity from AppComponent Class */
        AppInjector.inject(this)
    }

    /**
     * Injects dependencies into core Android modules of type T, Activty in this case
     * @return DispatchingAndroidInjector<Activity>
     */
    override fun activityInjector() = dispatchingAndroidInjector

}