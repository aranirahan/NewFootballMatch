package com.aranirahan.newfootballmatch.main

import com.aranirahan.newfootballmatch.main.item.EventsItem

interface MainView {
    fun showEventList(eventList : List<EventsItem>)
}