package com.example.vanguard.core.data.source.local.di

import android.content.Context
import androidx.room.Room
import com.example.vanguard.core.data.source.local.ILocalDataSource
import com.example.vanguard.core.data.source.local.LocalDataSource
import com.example.vanguard.core.data.source.local.room.VanguardDao
import com.example.vanguard.core.data.source.local.room.VanguardDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private val passphrase: ByteArray = SQLiteDatabase.getBytes("vanguard".toCharArray())
    val factory = SupportFactory(passphrase)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): VanguardDatabase = Room.databaseBuilder(
        context,
        VanguardDatabase::class.java, "Vanguard.db"
    ).fallbackToDestructiveMigration()
        .openHelperFactory(factory)
        .build()

    @Provides
    @Singleton
    fun provideVanguardDao(database: VanguardDatabase): VanguardDao = database.vanguardDao()

    @Provides
    @Singleton
    fun provideVanguardDataSource(vanguardDao : VanguardDao) : ILocalDataSource =
        LocalDataSource(vanguardDao)

}