package com.example.hockeyapp.data.mappers

import com.example.hockeyapp.data.database.pojo.TournamentInfoDbModel
import com.example.hockeyapp.data.network.pojo.TournamentInfoDto
import com.example.hockeyapp.domain.pojo.TournamentInfo

class TournamentMapper {
    fun mapDbModelToEntity(dbModel:TournamentInfoDbModel) = TournamentInfo(
        position = dbModel.position,
        name = dbModel.name,
        image = dbModel.image,
        n = dbModel.n,
        b = dbModel.b,
        bo = dbModel.bo,
        bb = dbModel.bb,
        pb = dbModel.pb,
        po = dbModel.po,
        p = dbModel.p,
        sh = dbModel.sh,
        scores = dbModel.scores
    )

    fun mapDtoToDbModel(dto: TournamentInfoDto) = TournamentInfoDbModel(
        position = dto.position?:-1,
        name = dto.name?:"",
        image = dto.image?:"",
        n = dto.n?:"",
        b = dto.b?:"",
        bo = dto.bo?:"",
        bb = dto.bb?:"",
        pb = dto.pb?:"",
        po = dto.po?:"",
        p = dto.p?:"",
        sh = dto.sh?:"",
        scores = dto.scores?:""
    )
}