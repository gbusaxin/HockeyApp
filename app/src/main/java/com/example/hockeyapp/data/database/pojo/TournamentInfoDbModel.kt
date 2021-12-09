package com.example.hockeyapp.data.database.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tournament_info")
data class TournamentInfoDbModel (
    @PrimaryKey
    val position:Int,
    val name: String,
    val image: String,
    val n: String,
    val b: String,
    val bo: String,
    val bb: String,
    val pb: String,
    val po: String,
    val p: String,
    val sh: String,
    val scores: String
)