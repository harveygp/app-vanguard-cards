package com.example.submission.core.domain.usecase

import com.example.submission.core.data.IVanguardRepository
import com.example.submission.core.data.Resource
import com.example.submission.core.domain.model.Vanguard
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VanguardUseCase @Inject constructor(private val vanguardRepository : IVanguardRepository)
    : IVanguardUseCase {
    override fun getAllVanguards(): Flow<Resource<List<Vanguard>>> = vanguardRepository.getAllVanguards()

    override fun getFavoriteVanguard(): Flow<List<Vanguard>> = vanguardRepository.getFavoriteVanguard()

    override suspend fun updateFavoriteVanguard(vanguard: Vanguard, state: Boolean) = vanguardRepository.updateFavoriteVanguard(vanguard, state)

}