package com.joshsoftware.dagger2boilerplate.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.joshsoftware.dagger2boilerplate.MyApplication
import com.joshsoftware.dagger2boilerplate.di.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

/**
 * Created By Nayan Dhabarde
 */

/**
 * Injects all dependencies into the Application class, activities and fragments
 */
object AppInjector {

    /**
     * Injects dependencies from DaggerAppComponent into the application
     * Note: Dagger app component is generated when you compile the project by Dagger from [AppComponent]
     * Don't worry if you see it in red before setting up all of the project
     * @param app MyApplication
     */
    fun inject(app: MyApplication) {  // Recommended to not to replace MyApplication with just application
        DaggerAppComponent // Generated after building the project with all dagger boiler plate code in place
            .builder()
            .application(app)
            .build()
            .inject(app)

        app.registerActivityLifecycleCallbacks(object: Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
                // You might wanna use this space for handling user logout
            }

            override fun onActivityResumed(activity: Activity) {
            }

        })
    }

    /**
     * Looks at the activity and fragment
     * If they implement [Injectable] we inject dependencies into them
     * @param activity Activity
     */
    private fun handleActivity(activity: Activity) {
        if(activity is Injectable) {
            AndroidInjection.inject(activity)
        }

        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(
                            fm: FragmentManager,
                            f: Fragment,
                            savedInstanceState: Bundle?
                        ) {
                            if(f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true
                )
        }
    }

}