package com.example.hockeyapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hockeyapp.data.database.pojo.*

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

    @Query("SELECT * FROM team_info")
    fun getTeamInfoList():LiveData<List<TeamInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamInfoList(newsDbModel:List<TeamInfoDbModel>)

    @Query("SELECT * FROM result_info")
    fun getResultInfoList():LiveData<List<ResultInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResultInfoList(newsDbModel:List<ResultInfoDbModel>)

    @Query("SELECT * FROM fixtures_info")
    fun getFixturesInfoList():LiveData<List<FixturesInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixturesInfoList(newsDbModel:List<FixturesInfoDbModel>)
}