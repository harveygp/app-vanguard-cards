package com.example.vanguard.core.data.di

import com.example.vanguard.core.data.IVanguardRepository
import com.example.vanguard.core.data.VanguardRepository
import com.example.vanguard.core.data.source.local.ILocalDataSource
import com.example.vanguard.core.data.source.remote.IRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideVanguardRepository(
        remoteDataSource: IRemoteDataSource,
        localDataSource: ILocalDataSource
    ): IVanguardRepository =
        VanguardRepository(
            remoteDataSource, localDataSource
        )

}