package com.example.submission.core.di

import com.example.submission.core.data.VanguardRepository
import com.example.submission.core.domain.repository.IVanguardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(vanguardRepository: VanguardRepository): IVanguardRepository

}