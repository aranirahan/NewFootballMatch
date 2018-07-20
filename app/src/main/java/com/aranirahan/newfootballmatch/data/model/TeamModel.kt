package com.aranirahan.newfootballmatch.data.model

import com.google.gson.annotations.SerializedName

data class TeamModel(
        @SerializedName("strTeamBadge")
        var strTeamBadge: String? = null
)