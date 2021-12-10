package com.example.hockeyapp.domain.use_cases

import com.example.hockeyapp.domain.Repository

class GetTeamInfoListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getTeamInfoList()
}