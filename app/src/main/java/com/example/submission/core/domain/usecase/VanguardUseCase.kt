package com.example.submission.core.domain.usecase

import com.example.submission.core.data.Resource
import com.example.submission.core.domain.model.Vanguard
import kotlinx.coroutines.flow.Flow

interface VanguardUseCase {

    fun getAllVanguards(): Flow<Resource<List<Vanguard>>>
    fun getFavoriteVanguard(): Flow<List<Vanguard>>
    fun updateFavoriteVanguard(vanguard: Vanguard, state: Boolean)

}