package com.aranirahan.newfootballmatch.data

import com.aranirahan.newfootballmatch.BuildConfig.TSDB_API_KEY
import com.aranirahan.newfootballmatch.data.model.MatchResponseModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/v1/json/${TSDB_API_KEY}"
            + "/eventspastleague.php")
    fun getMatchList(@Query("id") idLeague: String) : Flowable<MatchResponseModel>
}