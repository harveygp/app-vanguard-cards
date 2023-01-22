package com.example.submission.di

import com.example.submission.core.domain.usecase.VanguardInteractor
import com.example.submission.core.domain.usecase.VanguardUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideVanguardUseCase(vanguardInteractor: VanguardInteractor): VanguardUseCase

}