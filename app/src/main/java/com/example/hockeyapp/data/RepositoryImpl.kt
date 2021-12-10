package com.example.hockeyapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.hockeyapp.data.database.AppDatabase
import com.example.hockeyapp.data.mappers.NewsMapper
import com.example.hockeyapp.data.mappers.ResultMapper
import com.example.hockeyapp.data.mappers.TeamMapper
import com.example.hockeyapp.data.mappers.TournamentMapper
import com.example.hockeyapp.data.network.retrofit.ApiFactory
import com.example.hockeyapp.domain.Repository
import com.example.hockeyapp.domain.pojo.NewsInfo
import com.example.hockeyapp.domain.pojo.ResultInfo
import com.example.hockeyapp.domain.pojo.TeamInfo
import com.example.hockeyapp.domain.pojo.TournamentInfo

class RepositoryImpl(private val application: Application) : Repository {
    private val dao = AppDatabase.getInstance(application).getDao()
    private val apiService = ApiFactory.apiService

    private val newsMapper = NewsMapper()
    private val tournamentMapper = TournamentMapper()
    private val teamMapper = TeamMapper()
    private val resultMapper = ResultMapper()

    override fun getNewsInfoList(): LiveData<List<NewsInfo>> {
        return Transformations.map(dao.getNewsInfoList()) {
            it.map { newsMapper.mapDbModelToEntity(it) }
        }
    }

    override fun getTournamentInfoList(): LiveData<List<TournamentInfo>> {
        return Transformations.map(dao.getTournamentInfoList()) {
            it.map { tournamentMapper.mapDbModelToEntity(it) }
        }
    }

    override fun getTeamInfoList(): LiveData<List<TeamInfo>> {
        return Transformations.map(dao.getTeamInfoList()) {
            it.map { teamMapper.mapDbModelToEntity(it) }
        }
    }

    override fun getResultInfoList(): LiveData<List<ResultInfo>> {
        return Transformations.map(dao.getResultInfoList()) {
            it.map { resultMapper.mapDbModelToEntity(it) }
        }
    }

    override fun getFixturesInfoList(): LiveData<List<ResultInfo>> {
        return Transformations.map(dao.getFixturesInfoList()) {
            it.map { resultMapper.mapDbModelFixturesToEntity(it) }
        }
    }

    override suspend fun loadNewsInfoData() {
        try {
            val dto = apiService.loadNewsListKHL()
            val dbModel = dto.map { newsMapper.mapDtoToDbModel(it) }
            dao.insertNewsInfoList(dbModel)
        } catch (e: Exception) {
        }
    }

    override suspend fun loadTournamentInfoData() {
        try {
            val dto = apiService.loadTournamentListKHL()
            val dbModel = dto.map { tournamentMapper.mapDtoToDbModel(it) }
            dao.insertTournamentInfoList(dbModel)
        } catch (e: Exception) {
        }
    }

    override suspend fun loadTeamInfoData() {
        try {
            val dto = apiService.loadTeamsInfoListKHL()
            val dbModel = dto.map { teamMapper.mapDtoToDbModel(it) }
            dao.insertTeamInfoList(dbModel)
        } catch (e: Exception) {
        }
    }

    override suspend fun loadResultInfoData() {
        try {
            val dto = apiService.loadResultInfoListKHL()
            val dbModel = dto.map { resultMapper.mapDtoToDbModel(it) }
            dao.insertResultInfoList(dbModel)
        } catch (e: Exception) {
        }
    }

    override suspend fun loadFixturesInfoData() {
        try {
            val dto = apiService.loadFixturesInfoListKHL()
            val dbModel = dto.map { resultMapper.mapDtoFixturesToDbModel(it) }
            dao.insertFixturesInfoList(dbModel)
        } catch (e: Exception) {
        }
    }
}