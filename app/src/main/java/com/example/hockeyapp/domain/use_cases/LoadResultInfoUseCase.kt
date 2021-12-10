package com.example.hockeyapp.domain.use_cases

import com.example.hockeyapp.domain.Repository

class LoadResultInfoUseCase(private val repository: Repository) {
    suspend operator fun invoke() = repository.loadResultInfoData()
}