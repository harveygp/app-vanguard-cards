package com.example.submission.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vanguard")
data class VanguardEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "vanguardId")
    var vanguardId : Int,

    @ColumnInfo(name = "name")
    var name : String,

    @ColumnInfo(name = "grade")
    var grade : Int,

    @ColumnInfo(name = "nation")
    var nation : String,

    @ColumnInfo(name = "effect")
    var effect : String,

    @ColumnInfo(name = "image")
    var image : String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)