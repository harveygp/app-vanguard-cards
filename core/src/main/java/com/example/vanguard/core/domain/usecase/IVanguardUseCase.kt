package com.example.vanguard.core.domain.usecase

import com.example.vanguard.core.data.Resource
import com.example.vanguard.core.domain.model.Vanguard
import kotlinx.coroutines.flow.Flow

interface IVanguardUseCase {

    fun getAllVanguards(): Flow<Resource<List<Vanguard>>>
    fun getFavoriteVanguard(): Flow<List<Vanguard>>
    suspend fun updateFavoriteVanguard(vanguard: Vanguard, state: Boolean)

}