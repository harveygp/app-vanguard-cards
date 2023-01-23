package com.example.vanguardappp.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.vanguardappp.core.data.source.local.entity.VanguardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VanguardDao {

    @Query("SELECT * FROM vanguard")
    fun getAllVanguards(): Flow<List<VanguardEntity>>

    @Query("SELECT * FROM vanguard where isFavorite = 1")
    fun getFavoriteVanguard(): Flow<List<VanguardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVanguard(listVanguard : List<VanguardEntity>)

    @Update
    fun updateFavoriteVanguard(vanguard : VanguardEntity)
}