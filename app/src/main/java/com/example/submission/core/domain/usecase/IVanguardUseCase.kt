package com.example.submission.core.domain.usecase

import com.example.submission.core.data.Resource
import com.example.submission.core.domain.model.Vanguard
import kotlinx.coroutines.flow.Flow

interface IVanguardUseCase {

    fun getAllVanguards(): Flow<Resource<List<Vanguard>>>
    fun getFavoriteVanguard(): Flow<List<Vanguard>>
    suspend fun updateFavoriteVanguard(vanguard: Vanguard, state: Boolean)

}