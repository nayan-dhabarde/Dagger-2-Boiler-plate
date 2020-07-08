package com.joshsoftware.dagger2boilerplate.di

/**
 * Created by Nayan Dhabarde
 */

/**
 * A Marker interface, we use it in [AppInjector] in order to differentiate between activities/fragments which should be injected
 * If not used, Dagger will try to inject dependencies intro everything, including activities and fragments from libraries
 */
interface Injectable {
}