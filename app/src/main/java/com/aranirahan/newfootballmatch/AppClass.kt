package com.aranirahan.newfootballmatch

import android.app.Application
import com.aranirahan.newfootballmatch.di.component.AppComponent
import com.aranirahan.newfootballmatch.di.component.DaggerAppComponent
import com.aranirahan.newfootballmatch.di.module.AppModule

class AppClass : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

}