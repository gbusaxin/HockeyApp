package com.example.hockeyapp.data.network.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class TournamentInfoDto (
    @SerializedName("position")
    @Expose
    val position:Int = 0,
    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("N")
    @Expose
    val n: String? = null,

    @SerializedName("B")
    @Expose
    val b: String? = null,

    @SerializedName("BO")
    @Expose
    val bo: String? = null,

    @SerializedName("Bb")
    @Expose
    val bb: String? = null,

    @SerializedName("Pb")
    @Expose
    val pb: String? = null,

    @SerializedName("PO")
    @Expose
    val po: String? = null,

    @SerializedName("P")
    @Expose
    val p: String? = null,

    @SerializedName("SH")
    @Expose
    val sh: String? = null,

    @SerializedName("scores")
    @Expose
    val scores: String? = null
)