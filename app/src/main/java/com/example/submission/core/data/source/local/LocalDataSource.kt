package com.example.submission.core.data.source.local

import com.example.submission.core.data.source.local.entity.VanguardEntity
import com.example.submission.core.data.source.local.room.VanguardDao
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class LocalDataSource @Inject constructor(private val vanguardDao : VanguardDao) : ILocalDataSource{

    override fun getAllVanguards() : Flow<List<VanguardEntity>> = vanguardDao.getAllVanguards()

    override fun getFavoriteVanguard(): Flow<List<VanguardEntity>> = vanguardDao.getFavoriteVanguard()

    override suspend fun insertVanguard(listVanguard : List<VanguardEntity>) = vanguardDao.insertVanguard(listVanguard)

    override suspend fun updateFavoriteVanguard(vanguard : VanguardEntity, newState : Boolean){
        vanguard.isFavorite = newState
        vanguardDao.updateFavoriteVanguard(vanguard)
    }

}