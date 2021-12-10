package com.example.hockeyapp.data.mappers

import com.example.hockeyapp.data.database.pojo.TeamInfoDbModel
import com.example.hockeyapp.data.network.pojo.TeamInfoDto
import com.example.hockeyapp.domain.pojo.TeamInfo

class TeamMapper {

    fun mapDbModelToEntity(dbModel:TeamInfoDbModel) = TeamInfo(
        name =  dbModel.name,
        image = dbModel.image,
        countryImage = dbModel.countryImage,
        city = dbModel.city,
        founded = dbModel.founded,
        usernames = dbModel.usernames,
        venue = dbModel.venue,
        trainer = dbModel.trainer,
        captain = dbModel.captain
    )

    fun mapDtoToDbModel(dto: TeamInfoDto) = TeamInfoDbModel(
        name =  dto.name ?:"",
        image = dto.image,
        countryImage = dto.countryImage,
        city = dto.city,
        founded = dto.founded,
        usernames = dto.usernames,
        venue = dto.venue,
        trainer = dto.trainer,
        captain = dto.captain
    )
}