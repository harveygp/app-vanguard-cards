package com.example.vanguardappp.core.data.source.remote.network

import com.example.vanguardappp.core.data.source.remote.response.ListVanguardResponse
import retrofit2.http.GET

interface ApiService {

    @GET("cards")
    suspend fun getAllVanguards() : ListVanguardResponse


}