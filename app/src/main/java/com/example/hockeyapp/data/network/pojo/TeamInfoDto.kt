package com.example.hockeyapp.data.network.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class TeamInfoDto(
    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("country_image")
    @Expose
    val countryImage: String? = null,

    @SerializedName("city")
    @Expose
    val city: String? = null,

    @SerializedName("founded")
    @Expose
    val founded: String? = null,

    @SerializedName("usernames")
    @Expose
    val usernames: String? = null,

    @SerializedName("venue")
    @Expose
    val venue: String? = null,

    @SerializedName("trainer")
    @Expose
    val trainer: String? = null,

    @SerializedName("captain")
    @Expose
    val captain: String? = null
)