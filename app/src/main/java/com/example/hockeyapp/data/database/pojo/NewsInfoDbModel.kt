package com.example.hockeyapp.data.database.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_info")
data class NewsInfoDbModel (
    @PrimaryKey
    val title: String,

    val date: String? = null,

    val body: String? = null
)