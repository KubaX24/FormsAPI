package com.chytac.formsapi.repositories.vote

import com.chytac.formsapi.entities.vote.VoteDatesEntity
import org.springframework.data.jpa.repository.JpaRepository

interface VoteDatesRepository : JpaRepository<VoteDatesEntity, Int> {

    fun findAllByIdVote(idVote: Int): List<VoteDatesEntity>
}