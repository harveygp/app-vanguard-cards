package com.example.submission.core.data.source.local

import com.example.submission.core.data.source.local.entity.VanguardEntity
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {

    fun getAllVanguards() : Flow<List<VanguardEntity>>

    fun getFavoriteVanguard(): Flow<List<VanguardEntity>>

    suspend fun insertVanguard(listVanguard : List<VanguardEntity>)

    suspend fun updateFavoriteVanguard(vanguard : VanguardEntity, newState : Boolean)
}