package com.example.hockeyapp.data.mappers

import com.example.hockeyapp.data.database.pojo.NewsInfoDbModel
import com.example.hockeyapp.data.network.pojo.NewsInfoDto
import com.example.hockeyapp.domain.pojo.NewsInfo

class NewsMapper {
    fun mapDbModelToEntity(dbModel: NewsInfoDbModel) = NewsInfo(
        title = dbModel.title?:"",
        date = dbModel.date?:"",
        body = dbModel.body?:""
    )

    fun mapDtoToDbModel(dto: NewsInfoDto) = NewsInfoDbModel(
        title = dto.title?:"",
        date = dto.date?:"",
        body = dto.body?:""
    )
}