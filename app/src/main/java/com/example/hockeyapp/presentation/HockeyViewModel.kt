package com.example.hockeyapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hockeyapp.data.RepositoryImpl
import com.example.hockeyapp.domain.use_cases.*
import kotlinx.coroutines.launch

class HockeyViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = RepositoryImpl(application)

    private val getNewsInfoUseCase = GetNewsListUseCase(repository)
    private val getTournamentListUseCase = GetTournamentListUseCase(repository)
    private val getTeamInfoListUseCase = GetTeamInfoListUseCase(repository)
    private val getResultInfoListUseCase = GetResultInfoListUseCase(repository)
    private val getFixturesInfoListUseCase = GetResultInfoListUseCase(repository)

    private val loadResultInfoListUseCase = LoadResultInfoUseCase(repository)
    private val loadFixturesInfoListUseCase = LoadResultInfoUseCase(repository)
    private val loadNewsInfoUseCase = LoadNewsInfoUseCase(repository)
    private val loadTournamentListUseCase = LoadTournamentInfoUseCase(repository)
    private val loadTeamInfoListUseCase = LoadTeamInfoUseCase(repository)

    val newsInfoList = getNewsInfoUseCase()
    val tournamentInfoList = getTournamentListUseCase()
    val teamInfoList = getTeamInfoListUseCase()
    val resultInfoList = getResultInfoListUseCase()
    val fixturesInfoList = getFixturesInfoListUseCase()

    init {
        viewModelScope.launch {
            loadNewsInfoUseCase()
            loadTournamentListUseCase()
            loadTeamInfoListUseCase()
            loadResultInfoListUseCase()
            loadFixturesInfoListUseCase
        }
    }
}