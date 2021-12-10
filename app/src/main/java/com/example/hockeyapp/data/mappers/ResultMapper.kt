package com.example.hockeyapp.data.mappers

import com.example.hockeyapp.data.database.pojo.FixturesInfoDbModel
import com.example.hockeyapp.data.database.pojo.ResultInfoDbModel
import com.example.hockeyapp.data.network.pojo.ResultInfoDto
import com.example.hockeyapp.domain.pojo.ResultInfo

class ResultMapper {
    fun mapDbModelToEntity(dbModel: ResultInfoDbModel) = ResultInfo(
        teams = dbModel.teams,
        date = dbModel.date,
        result = dbModel.result
    )

    fun mapDtoToDbModel(dto: ResultInfoDto) = ResultInfoDbModel(
        teams = dto.teams,
        date = dto.date,
        result = dto.result,
        id = 0
    )

    fun mapDtoFixturesToDbModel(dto: ResultInfoDto) = FixturesInfoDbModel(
        teams = dto.teams,
        date = dto.date,
        result = dto.result,
        id = 0
    )

    fun mapDbModelFixturesToEntity(dbModel: FixturesInfoDbModel) = ResultInfo(
        teams = dbModel.teams,
        date = dbModel.date,
        result = dbModel.result
    )
}