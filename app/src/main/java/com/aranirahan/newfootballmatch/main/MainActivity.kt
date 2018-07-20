package com.aranirahan.newfootballmatch.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aranirahan.newfootballmatch.AppClass
import com.aranirahan.newfootballmatch.R
import com.aranirahan.newfootballmatch.R.color.colorAccent
import com.aranirahan.newfootballmatch.di.ActivityScope
import com.aranirahan.newfootballmatch.di.component.ActivityComponent
import com.aranirahan.newfootballmatch.main.item.EventsItem
import com.aranirahan.newfootballmatch.utils.toJson
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import javax.inject.Inject

@ActivityScope
class MainActivity : AppCompatActivity(), MainView {

    private val TAG = "MainActivity"

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.injectActivity()
        presenter.bind(this)
        this.initView()
    }

    private fun injectActivity() {
        val injector: ActivityComponent= (applicationContext as AppClass).appComponent
                .buildActivityComponent()
                .build()
        injector.inject(this)
    }

    private fun initView(){
        presenter.getEventList()
    }

    override fun showEventList(eventList: List<EventsItem>) {
        Log.d(TAG, " : ${eventList.toJson()}")
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            linearLayout {
                orientation = android.widget.LinearLayout.VERTICAL
                padding = dip(16)
                textView("FOOTBALL MATCH SCHEDULE") {
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    gravity = android.view.Gravity.CENTER
                }

                button("Past Match") {
                    backgroundColor = android.support.v4.content.ContextCompat.getColor(context, colorAccent)
                    textColor = android.graphics.Color.WHITE
                    onClick {
//                        startActivity<PastMatchActivity>("name" to "m")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(24)
                }
                button("Next Match") {
                    backgroundColor = android.support.v4.content.ContextCompat.getColor(context, colorAccent)
                    textColor = android.graphics.Color.WHITE
                    onClick {
//                        startActivity<NextMatchActivity>("name" to "m")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(6)
                }
            }
        }
    }
}
