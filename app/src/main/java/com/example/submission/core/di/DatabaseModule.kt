package com.example.submission.core.di

import android.content.Context
import androidx.room.Room
import com.example.submission.core.data.source.local.room.VanguardDao
import com.example.submission.core.data.source.local.room.VanguardDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): VanguardDatabase = Room.databaseBuilder(
        context,
        VanguardDatabase::class.java, "Vanguard.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: VanguardDatabase): VanguardDao = database.vanguardDao()
}