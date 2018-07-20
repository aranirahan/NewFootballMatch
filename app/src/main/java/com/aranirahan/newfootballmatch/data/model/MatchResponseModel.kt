package com.aranirahan.newfootballmatch.data.model

import com.google.gson.annotations.SerializedName

data class MatchResponseModel(
        @field:SerializedName("events")
        val event: List<MatchModel>? = null,

        @field:SerializedName("teams")
        val teams: List<TeamModel>? = null)