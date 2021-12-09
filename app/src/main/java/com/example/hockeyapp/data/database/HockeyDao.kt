package com.example.hockeyapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hockeyapp.data.database.pojo.NewsInfoDbModel
import com.example.hockeyapp.data.database.pojo.TournamentInfoDbModel

@Dao
interface HockeyDao {

    @Query("SELECT * FROM news_info")
    fun getNewsInfoList():LiveData<List<NewsInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsInfoList(newsDbModel:List<NewsInfoDbModel>)

    @Query("SELECT * FROM tournament_info")
    fun getTournamentInfoList():LiveData<List<TournamentInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTournamentInfoList(newsDbModel:List<TournamentInfoDbModel>)
}