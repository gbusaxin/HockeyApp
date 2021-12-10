package com.example.hockeyapp.data.database.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fixtures_info")
data class FixturesInfoDbModel (

    @PrimaryKey(autoGenerate = true)
    val id :Int,

    val teams: String? = null,

    val date: String? = null,

    val result: String? = null

)