package com.example.hockeyapp.domain.use_cases

import com.example.hockeyapp.domain.Repository

class LoadTeamInfoUseCase(private val repository: Repository) {
    suspend operator fun invoke() = repository.loadTeamInfoData()
}