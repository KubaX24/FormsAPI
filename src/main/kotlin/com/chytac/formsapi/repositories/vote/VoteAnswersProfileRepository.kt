package com.chytac.formsapi.repositories.vote

import com.chytac.formsapi.entities.vote.VoteAnswersProfileEntity
import org.springframework.data.jpa.repository.JpaRepository

interface VoteAnswersProfileRepository : JpaRepository<VoteAnswersProfileEntity, Int> {

    fun findAllByIdVote(id: Int): List<VoteAnswersProfileEntity>
}