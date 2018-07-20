package com.aranirahan.newfootballmatch.data.repository

import com.aranirahan.newfootballmatch.data.ApiService
import com.aranirahan.newfootballmatch.main.item.EventsItem
import com.aranirahan.newfootballmatch.main.item.TeamsItem
import io.reactivex.Flowable
import javax.inject.Inject

class MainRepo @Inject constructor(val api: ApiService) {
    fun getEvent(): Flowable<List<EventsItem>> {
        return api.getMatchList("4328")
                .flatMap {
                    Flowable.fromIterable(it.event)
                }
                .map {
                    EventsItem(it.idEvent,
                            it.strHomeTeam,
                            it.strAwayTeam,
                            it.intHomeScore,
                            it.intAwayScore,
                            it.dateEvent,
                            it.strHomeLineupGoalkeeper,
                            it.strAwayLineupGoalkeeper,
                            it.strHomeGoalDetails,
                            it.strAwayGoalDetails,
                            it.intHomeShots,
                            it.intAwayShots,
                            it.strHomeLineupDefense,
                            it.awayDefense,
                            it.strAwayLineupDefense,
                            it.strAwayLineupMidfield,
                            it.strHomeLineupForward,
                            it.strAwayLineupForward,
                            it.strHomeLineupSubstitutes,
                            it.strAwayLineupSubstitutes,
                            it.strHomeFormation,
                            it.strAwayFormation,
                            it.strTeamBadge,
                            it.idHomeTeam,
                            it.idAwayTeam)
                }
                .toList()
                .toFlowable()
    }

    fun getTeam() : Flowable<List<TeamsItem>>{
        return api.getMatchList("4328")
                .flatMap {
                    Flowable.fromIterable(it.teams)
                }
                .map {
                    TeamsItem(it.strTeamBadge
                    )
                }
                .toList()
                .toFlowable()
    }
}