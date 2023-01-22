package com.example.submission.core.data

import com.example.submission.core.data.source.local.LocalDataSource
import com.example.submission.core.data.source.remote.RemoteDataSource
import com.example.submission.core.data.source.remote.network.ApiResponse
import com.example.submission.core.data.source.remote.response.VanguardResponse
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.core.domain.repository.IVanguardRepository
import com.example.submission.utils.AppExecutors
import com.example.submission.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VanguardRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IVanguardRepository{
    override fun getAllVanguards(): Flow<Resource<List<Vanguard>>> =
        object : NetworkBoundResource<List<Vanguard>, List<VanguardResponse>>() {
            override fun loadFromDB(): Flow<List<Vanguard>> {
                return localDataSource.getAllVanguards().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Vanguard>?): Boolean =
//                data == null || data.isEmpty()
                true // change to true , if always want to get data from network

            override suspend fun createCall(): Flow<ApiResponse<List<VanguardResponse>>> =
                remoteDataSource.getAllVanguards()

            override suspend fun saveCallResult(data: List<VanguardResponse>) {
                val vanguardList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertVanguard(vanguardList)
            }
        }.asFlow()

    override fun getFavoriteVanguard(): Flow<List<Vanguard>> {
        return localDataSource.getFavoriteVanguard().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun updateFavoriteVanguard(vanguard: Vanguard, state: Boolean) {
        val vanguardEntity = DataMapper.mapDomainToEntity(vanguard)
        appExecutors.diskIO().execute { localDataSource.updateFavoriteVanguard(vanguardEntity, state) }
    }
}