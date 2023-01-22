package com.example.submission.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vanguard(
    var vanguardId : Int,
    var name : String,
    var grade : Int,
    var nation : String,
    var effect : String,
    var image : String,
    var isFavorite: Boolean
): Parcelable
