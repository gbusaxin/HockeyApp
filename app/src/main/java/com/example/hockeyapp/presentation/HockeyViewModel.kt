package com.example.hockeyapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hockeyapp.data.RepositoryImpl
import com.example.hockeyapp.domain.use_cases.GetNewsListUseCase
import com.example.hockeyapp.domain.use_cases.GetTournamentListUseCase
import com.example.hockeyapp.domain.use_cases.LoadNewsInfoUseCase
import com.example.hockeyapp.domain.use_cases.LoadTournamentInfoUseCase
import kotlinx.coroutines.launch

class HockeyViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = RepositoryImpl(application)

    private val getNewsInfoUseCase = GetNewsListUseCase(repository)
    private val getTournamentListUseCase = GetTournamentListUseCase(repository)

    private val loadNewsInfoUseCase = LoadNewsInfoUseCase(repository)
    private val loadTournamentListUseCase = LoadTournamentInfoUseCase(repository)

    val newsInfoList = getNewsInfoUseCase()
    val tournamentInfoList = getTournamentListUseCase()

    init {
        viewModelScope.launch {
            loadNewsInfoUseCase()
            loadTournamentListUseCase()
        }
    }
}