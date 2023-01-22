package com.example.submission.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class VanguardResponse(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("cardtype")
    val cardtype: String,

    @field:SerializedName("clan")
    val clan: String,

    @field:SerializedName("critical")
    val critical: Int,

    @field:SerializedName("designillus")
    val designillus: String,

    @field:SerializedName("effect")
    val effect: String,

    @field:SerializedName("flavor")
    val flavor: String,

    @field:SerializedName("format")
    val format: String,

    @field:SerializedName("grade")
    val grade: Int,

    @field:SerializedName("illustcolor")
    val illustcolor: String,

    @field:SerializedName("illust")
    val illust: String,

    @field:SerializedName("illust2")
    val illust2: String,

    @field:SerializedName("illust3")
    val illust3: String,

    @field:SerializedName("illust4")
    val illust4: String,

    @field:SerializedName("illust5")
    val illust5: String,

    @field:SerializedName("imageurlen")
    val imageurlen: String,

    @field:SerializedName("imageurljp")
    val imageurljp: String,

    @field:SerializedName("imaginarygift")
    val imaginarygift: String,

    @field:SerializedName("italian")
    val italian: String,

    @field:SerializedName("kana")
    val kana: String,

    @field:SerializedName("kanji")
    val kanji: String,

    @field:SerializedName("korean")
    val korean: String,

    @field:SerializedName("limitationtext")
    val limitationtext: String,

    @field:SerializedName("mangaillust")
    val mangaillust: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("nation")
    val nation: String,

    @field:SerializedName("note")
    val note: String,

    @field:SerializedName("othernames")
    val othernames: String,

    @field:SerializedName("phonetic")
    val phonetic: String,

    @field:SerializedName("power")
    val power: Int,

    @field:SerializedName("race")
    val race: String,

    @field:SerializedName("rideskill")
    val rideskill: String,

    @field:SerializedName("sets")
    val sets: List<String>,

    @field:SerializedName("tournamentstatuses")
    val tournamentstatuses: Tournamentstatuses,

    @field:SerializedName("shield")
    val shield: Int,

    @field:SerializedName("skill")
    val skill: String,

    @field:SerializedName("thai")
    val thai: String,

    @field:SerializedName("translation")
    val translation: String,

    @field:SerializedName("triggereffect")
    val triggereffect: String
)

data class Tournamentstatuses(
    @field:SerializedName("en")
    val en: String,

    @field:SerializedName("jp")
    val jp: String,

    @field:SerializedName("kr")
    val kr: String,

    @field:SerializedName("th")
    val th: String,

    @field:SerializedName("it")
    val it: String,
)
