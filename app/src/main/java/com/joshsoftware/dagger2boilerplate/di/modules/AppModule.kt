package com.joshsoftware.dagger2boilerplate.di.modules

import dagger.Module
import dagger.Provides

/**
 * Created by Nayan Dhabarde
 *
 * A class containing all the dependencies in a single place
 * You can create multiple modules serving different dependencies
 * Ex. NetworkModule, Database Module, etc..
 */
@Module
class AppModule {

    /**
     * Following is a sample code for adding dependencies for Retrofit
     * 1. The method provideOkHttpClient() is not dependent on any other object for construction
     * and thus when other provides function, field injection or constructor injection needs it Dagger can provide it
     * 2. Constructing ApiService is dependent on okhttpclient and hence we pass it in the arguments.
     * Dagger already knows how to build it and thus it will automatically provide okhttpclient
     */
/*
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).build()
    }
*/

/*

    @Provides
    fun provideService(okHttpClient: OkHttpClient): AddressService {
        return  Retrofit.Builder()
            .baseUrl("https://helloworld.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
            .create(AddressService::class.java)
    }
*/


}