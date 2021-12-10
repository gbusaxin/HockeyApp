package com.example.hockeyapp.data.database.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_info")
data class ResultInfoDbModel (
    @PrimaryKey(autoGenerate = true)
    val id :Int,

    val teams: String? = null,

    val date: String? = null,

    val result: String? = null
)