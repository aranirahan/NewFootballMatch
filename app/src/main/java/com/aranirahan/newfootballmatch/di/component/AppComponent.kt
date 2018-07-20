package com.aranirahan.newfootballmatch.di.component

import com.aranirahan.newfootballmatch.AppClass
import com.aranirahan.newfootballmatch.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun buildActivityComponent(): ActivityComponent.Builder
    fun inject(appClass: AppClass)
}