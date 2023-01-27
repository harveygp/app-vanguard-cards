package com.example.vanguard.core.data.source.remote.di

import androidx.viewbinding.BuildConfig
import com.example.vanguard.core.data.source.remote.IRemoteDataSource
import com.example.vanguard.core.data.source.remote.RemoteDataSource
import com.example.vanguard.core.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideSSL(): CertificatePinner = CertificatePinner
        .Builder()
        .add("card-fight-vanguard-api.ue.r.appspot.com", "sha256/JhpWhrqZ/2TQ4KbDA94sV2D9C2EkkCTSIPfFkkaHcd0=")
        .add("card-fight-vanguard-api.ue.r.appspot.com", "sha256/zCTnfLwLKbS9S2sbp+uFz4KZOocFvXxkV06Ce9O5M2w=")
        .add("card-fight-vanguard-api.ue.r.appspot.com", "sha256/hxqRlPTu1bMS/0DITB1SSu0vd4u/8l8TjPgfaAp63Gc=")
        .build()

    @Provides
    @Singleton
    fun provideLogger() =
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
        } else HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)


    @Provides
    @Singleton
    fun provideOkHttpClient(logger: HttpLoggingInterceptor, shaKey: CertificatePinner): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .certificatePinner(shaKey)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(client: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDataSource(apiService : ApiService) : IRemoteDataSource {
        return RemoteDataSource(apiService)
    }
}