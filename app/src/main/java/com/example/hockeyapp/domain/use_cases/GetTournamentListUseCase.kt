package com.example.hockeyapp.domain.use_cases

import com.example.hockeyapp.domain.Repository

class GetTournamentListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getTournamentInfoList()
}