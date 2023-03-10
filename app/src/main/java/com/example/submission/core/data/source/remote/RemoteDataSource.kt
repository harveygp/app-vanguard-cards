package com.example.submission.core.data.source.remote

import android.util.Log
import com.example.submission.core.data.source.remote.network.ApiResponse
import com.example.submission.core.data.source.remote.network.ApiService
import com.example.submission.core.data.source.remote.response.VanguardResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    //get data from API Remote
    suspend fun getAllVanguards() : Flow<ApiResponse<List<VanguardResponse>>> = flow {
        try {
            val response = apiService.getAllVanguards()
            val dataArray = response.data
            if(dataArray.isNotEmpty()) emit(ApiResponse.Success(response.data))
            else emit(ApiResponse.Empty)

        } catch (e : Exception){
            emit(ApiResponse.Error(e.toString()))
            Log.e("RemoteDataSource", e.toString())
        }
    }.flowOn(Dispatchers.IO)
}