package com.example.vanguardappp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListVanguardResponse(
    @field:SerializedName("data")
    val data: List<VanguardResponse>,

    @field:SerializedName("paging")
    val paging: Paging
)

data class Paging(
    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("pagesize")
    val pagesize: Int
)

