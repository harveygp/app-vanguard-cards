package com.example.submission.utils

import com.example.submission.core.data.source.local.entity.VanguardEntity
import com.example.submission.core.data.source.remote.response.VanguardResponse
import com.example.submission.core.domain.model.Vanguard

object DataMapper {

    fun mapResponsesToEntities(input: List<VanguardResponse>): List<VanguardEntity> {
        val vanguardList = ArrayList<VanguardEntity>()
        input.map {
            val vanguard = VanguardEntity(
                vanguardId = it.id,
                name = it.name,
                grade = it.grade,
                nation = it.nation,
                effect = it.effect,
                image = it.imageurljp,
                isFavorite = false
            )
            vanguardList.add(vanguard)
        }
        return vanguardList
    }

    fun mapEntitiesToDomain(input: List<VanguardEntity>): List<Vanguard> =
        input.map {
            Vanguard(
                vanguardId = it.vanguardId,
                name = it.name,
                grade = it.grade,
                nation = it.nation,
                effect = it.effect,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Vanguard) = VanguardEntity(
        vanguardId = input.vanguardId,
        name = input.name,
        grade = input.grade,
        nation = input.nation,
        effect = input.effect,
        image = input.image,
        isFavorite = input.isFavorite
    )

}