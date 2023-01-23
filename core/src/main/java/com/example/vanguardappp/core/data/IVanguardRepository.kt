package com.example.vanguardappp.core.data

import com.example.vanguardappp.core.domain.model.Vanguard
import kotlinx.coroutines.flow.Flow

interface IVanguardRepository {
    fun getAllVanguards(): Flow<Resource<List<Vanguard>>>
    fun getFavoriteVanguard(): Flow<List<Vanguard>>
    suspend fun updateFavoriteVanguard(vanguard: Vanguard, state: Boolean)
}