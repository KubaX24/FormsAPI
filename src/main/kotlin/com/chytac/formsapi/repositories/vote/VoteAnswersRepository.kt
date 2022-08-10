package com.chytac.formsapi.repositories.vote

import com.chytac.formsapi.entities.vote.VoteAnswersEntity
import org.springframework.data.jpa.repository.JpaRepository

interface VoteAnswersRepository : JpaRepository<VoteAnswersEntity, Int> {

    fun findAllByIdVote(id: Int): List<VoteAnswersEntity>
    fun findAllByIdProfile(id: Int?): List<VoteAnswersEntity>
}