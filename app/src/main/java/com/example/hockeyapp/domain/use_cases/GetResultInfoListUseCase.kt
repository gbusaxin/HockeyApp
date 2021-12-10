package com.example.hockeyapp.domain.use_cases

import com.example.hockeyapp.domain.Repository

class GetResultInfoListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getResultInfoList()
}