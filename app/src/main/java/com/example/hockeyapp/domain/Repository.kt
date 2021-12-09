package com.example.hockeyapp.domain

import androidx.lifecycle.LiveData
import com.example.hockeyapp.domain.pojo.NewsInfo
import com.example.hockeyapp.domain.pojo.TournamentInfo

interface Repository {
    fun getNewsInfoList():LiveData<List<NewsInfo>>
    fun getTournamentInfoList():LiveData<List<TournamentInfo>>
    suspend fun loadNewsInfoData()
    suspend fun loadTournamentInfoData()
}