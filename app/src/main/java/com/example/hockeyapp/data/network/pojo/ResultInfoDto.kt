package com.example.hockeyapp.data.network.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class ResultInfoDto (
    @SerializedName("teams")
    @Expose
    val teams: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null,

    @SerializedName("result")
    @Expose
    val result: String? = null
)