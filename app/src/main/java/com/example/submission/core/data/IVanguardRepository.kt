package com.example.submission.core.data

import com.example.submission.core.domain.model.Vanguard
import kotlinx.coroutines.flow.Flow

interface IVanguardRepository {
    fun getAllVanguards(): Flow<Resource<List<Vanguard>>>
    fun getFavoriteVanguard(): Flow<List<Vanguard>>
    suspend fun updateFavoriteVanguard(vanguard: Vanguard, state: Boolean)
}