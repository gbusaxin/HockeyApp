package com.example.hockeyapp.domain

import androidx.lifecycle.LiveData
import com.example.hockeyapp.domain.pojo.NewsInfo
import com.example.hockeyapp.domain.pojo.ResultInfo
import com.example.hockeyapp.domain.pojo.TeamInfo
import com.example.hockeyapp.domain.pojo.TournamentInfo

interface Repository {
    fun getNewsInfoList(): LiveData<List<NewsInfo>>
    fun getTournamentInfoList(): LiveData<List<TournamentInfo>>
    fun getTeamInfoList(): LiveData<List<TeamInfo>>
    fun getResultInfoList(): LiveData<List<ResultInfo>>
    fun getFixturesInfoList(): LiveData<List<ResultInfo>>
    suspend fun loadNewsInfoData()
    suspend fun loadTournamentInfoData()
    suspend fun loadTeamInfoData()
    suspend fun loadResultInfoData()
    suspend fun loadFixturesInfoData()
}