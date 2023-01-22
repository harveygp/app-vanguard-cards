package com.example.submission.core.data.source.local

import com.example.submission.core.data.source.local.entity.VanguardEntity
import com.example.submission.core.data.source.local.room.VanguardDao
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class LocalDataSource @Inject constructor(private val vanguardDao : VanguardDao){

    fun getAllVanguards() : Flow<List<VanguardEntity>> = vanguardDao.getAllVanguards()

    fun getFavoriteVanguard(): Flow<List<VanguardEntity>> = vanguardDao.getFavoriteVanguard()

    suspend fun insertVanguard(listVanguard : List<VanguardEntity>) = vanguardDao.insertVanguard(listVanguard)

    fun updateFavoriteVanguard(vanguard : VanguardEntity, newState : Boolean){
        vanguard.isFavorite = newState
        vanguardDao.updateFavoriteVanguard(vanguard)
    }

}