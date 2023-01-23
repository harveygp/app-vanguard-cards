package com.example.vanguard.core.domain.di

import com.example.vanguard.core.data.IVanguardRepository
import com.example.vanguard.core.domain.usecase.IVanguardUseCase
import com.example.vanguard.core.domain.usecase.VanguardUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideVanguardUseCase(repository : IVanguardRepository) : IVanguardUseCase =
        VanguardUseCase(repository)

}