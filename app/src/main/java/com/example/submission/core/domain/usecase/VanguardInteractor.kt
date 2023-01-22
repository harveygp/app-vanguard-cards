package com.example.submission.core.domain.usecase

import com.example.submission.core.data.Resource
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.core.domain.repository.IVanguardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VanguardInteractor @Inject constructor(private val vanguardRepository : IVanguardRepository) : VanguardUseCase {
    override fun getAllVanguards(): Flow<Resource<List<Vanguard>>> = vanguardRepository.getAllVanguards()

    override fun getFavoriteVanguard(): Flow<List<Vanguard>> = vanguardRepository.getFavoriteVanguard()

    override fun updateFavoriteVanguard(vanguard: Vanguard, state: Boolean) = vanguardRepository.updateFavoriteVanguard(vanguard, state)

}