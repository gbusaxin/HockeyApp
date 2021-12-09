package com.example.hockeyapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.hockeyapp.data.database.AppDatabase
import com.example.hockeyapp.data.mappers.NewsMapper
import com.example.hockeyapp.data.mappers.TournamentMapper
import com.example.hockeyapp.data.network.retrofit.ApiFactory
import com.example.hockeyapp.domain.Repository
import com.example.hockeyapp.domain.pojo.NewsInfo
import com.example.hockeyapp.domain.pojo.TournamentInfo

class RepositoryImpl (private val application: Application):Repository{
    private val dao = AppDatabase.getInstance(application).getDao()
    private val apiService = ApiFactory.apiService

    private val newsMapper = NewsMapper()
    private val tournamentMapper = TournamentMapper()

    override fun getNewsInfoList(): LiveData<List<NewsInfo>> {
        return Transformations.map(dao.getNewsInfoList()){
            it.map { newsMapper.mapDbModelToEntity(it) }
        }
    }

    override fun getTournamentInfoList(): LiveData<List<TournamentInfo>> {
        return Transformations.map(dao.getTournamentInfoList()){
            it.map { tournamentMapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadNewsInfoData() {
        try {
            val dto = apiService.loadNewsListKHL()
            val dbModel = dto.map { newsMapper.mapDtoToDbModel(it) }
            dao.insertNewsInfoList(dbModel)
        }catch (e:Exception){}
    }

    override suspend fun loadTournamentInfoData() {
        try {
            val dto = apiService.loadTournamentListKHL()
            val dbModel = dto.map { tournamentMapper.mapDtoToDbModel(it) }
            dao.insertTournamentInfoList(dbModel)
        }catch (e:Exception){}
    }
}