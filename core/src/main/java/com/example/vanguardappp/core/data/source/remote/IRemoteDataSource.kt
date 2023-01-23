package com.example.vanguardappp.core.data.source.remote

import com.example.vanguardappp.core.data.source.remote.network.ApiResponse
import com.example.vanguardappp.core.data.source.remote.response.VanguardResponse
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {

    suspend fun getAllVanguards(): Flow<ApiResponse<List<VanguardResponse>>>

}