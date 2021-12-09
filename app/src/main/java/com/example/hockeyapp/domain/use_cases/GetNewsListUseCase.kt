package com.example.hockeyapp.domain.use_cases

import com.example.hockeyapp.domain.Repository

class GetNewsListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getNewsInfoList()
}