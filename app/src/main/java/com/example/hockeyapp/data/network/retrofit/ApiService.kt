package com.example.hockeyapp.data.network.retrofit

import com.example.hockeyapp.data.network.pojo.NewsInfoDto
import com.example.hockeyapp.data.network.pojo.TournamentInfoDto
import retrofit2.http.GET

interface ApiService {

    @GET("khl_news.json")
    suspend fun loadNewsListKHL():List<NewsInfoDto>

    @GET("khl_tournament_table.json")
    suspend fun loadTournamentListKHL():List<TournamentInfoDto>
}