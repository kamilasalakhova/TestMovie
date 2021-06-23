package com.example.movietestapp.di.module

import android.content.Context
import com.example.movietestapp.base.App.Companion.const
import com.example.movietestapp.data.remote.network.NetworkInterceptor
import com.example.movietestapp.data.remote.network.NetworkService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        gsonBuilder.setLenient()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpCache(app: Context): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(app.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val intersepter = HttpLoggingInterceptor()
//        if (BuildConfig.DEBUG) {
            intersepter.level = HttpLoggingInterceptor.Level.BODY
//        } else {
//            intersepter.level = HttpLoggingInterceptor.Level.NONE
//        }
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(intersepter)
        builder.addInterceptor(NetworkInterceptor())
        builder.cache(cache)
        builder.writeTimeout(5, TimeUnit.MINUTES)
        builder.readTimeout(5, TimeUnit.MINUTES)
        builder.connectTimeout(5, TimeUnit.MINUTES)
        return builder.build()
    }

    @Provides
    @Singleton
    internal fun provideBaseRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(const.DEV_BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideBaseNetwork(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }
}