package com.example.hockeyapp.data.network.retrofit

import com.example.hockeyapp.data.network.pojo.NewsInfoDto
import com.example.hockeyapp.data.network.pojo.ResultInfoDto
import com.example.hockeyapp.data.network.pojo.TeamInfoDto
import com.example.hockeyapp.data.network.pojo.TournamentInfoDto
import retrofit2.http.GET

interface ApiService {

    @GET("khl_news.json")
    suspend fun loadNewsListKHL():List<NewsInfoDto>

    @GET("khl_tournament_table.json")
    suspend fun loadTournamentListKHL():List<TournamentInfoDto>

    @GET("khl_hockey_teams.json")
    suspend fun loadTeamsInfoListKHL():List<TeamInfoDto>

    @GET("results_khl.json")
    suspend fun loadResultInfoListKHL():List<ResultInfoDto>

    @GET("fixtures_khl.json")
    suspend fun loadFixturesInfoListKHL():List<ResultInfoDto>
}