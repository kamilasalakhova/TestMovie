package com.example.movietestapp.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.movietestapp.di.AppComponent
import com.example.movietestapp.di.module.AppModule
import com.example.movietestapp.di.DaggerAppComponent
import com.example.movietestapp.di.NetworkComponent

class App: Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        lateinit var appComponent: AppComponent
        val const: C by lazy {
            C
        }
    }
    override fun onCreate() {
        super.onCreate()
        val appModule = AppModule(this)
        context = applicationContext
        appComponent = DaggerAppComponent
            .builder()
            .appModule(appModule)
            .build()
    }
}