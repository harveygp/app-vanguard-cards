package com.example.vanguard.core.data

import com.example.vanguard.core.domain.model.Vanguard
import kotlinx.coroutines.flow.Flow

interface IVanguardRepository {
    fun getAllVanguards(): Flow<Resource<List<Vanguard>>>
    fun getFavoriteVanguard(): Flow<List<Vanguard>>
    suspend fun updateFavoriteVanguard(vanguard: Vanguard, state: Boolean)
}