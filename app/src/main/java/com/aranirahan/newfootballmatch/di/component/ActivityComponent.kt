package com.aranirahan.newfootballmatch.di.component

import com.aranirahan.newfootballmatch.di.ActivityScope
import com.aranirahan.newfootballmatch.main.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ActivityComponent
    }
}