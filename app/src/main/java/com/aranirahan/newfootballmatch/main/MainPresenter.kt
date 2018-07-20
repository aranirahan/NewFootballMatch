package com.aranirahan.newfootballmatch.main

import android.util.Log
import com.aranirahan.newfootballmatch.data.repository.MainRepo
import com.aranirahan.newfootballmatch.di.ActivityScope
import com.aranirahan.newfootballmatch.utils.toJson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class MainPresenter @Inject constructor(val repo : MainRepo) {

    private val TAG = "MainPresenter"

    private lateinit var view: MainView
    fun bind(view : MainView){
        this.view = view
    }

    fun getEventList(){
        repo.getEvent()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "EventList : ${it.toJson()}")
                    view.showEventList(it)
                }){
                    Log.e(TAG, "Error : ${it.message}")
                }
    }
}