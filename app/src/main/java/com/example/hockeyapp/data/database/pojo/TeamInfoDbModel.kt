package com.example.hockeyapp.data.database.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "team_info")
data class TeamInfoDbModel (
    @PrimaryKey
    val name: String,
    val image: String? = null,
    val countryImage: String? = null,
    val city: String? = null,
    val founded: String? = null,
    val usernames: String? = null,
    val venue: String? = null,
    val trainer: String? = null,
    val captain: String? = null
)