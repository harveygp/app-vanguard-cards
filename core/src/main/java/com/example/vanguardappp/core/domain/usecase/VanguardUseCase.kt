package com.example.vanguardappp.core.domain.usecase

import com.example.vanguardappp.core.data.IVanguardRepository
import com.example.vanguardappp.core.data.Resource
import com.example.vanguardappp.core.domain.model.Vanguard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VanguardUseCase @Inject constructor(private val vanguardRepository : IVanguardRepository)
    : IVanguardUseCase {
    override fun getAllVanguards(): Flow<Resource<List<Vanguard>>> = vanguardRepository.getAllVanguards()

    override fun getFavoriteVanguard(): Flow<List<Vanguard>> = vanguardRepository.getFavoriteVanguard()

    override suspend fun updateFavoriteVanguard(vanguard: Vanguard, state: Boolean) =
        withContext(Dispatchers.IO){vanguardRepository.updateFavoriteVanguard(vanguard, state)}

}