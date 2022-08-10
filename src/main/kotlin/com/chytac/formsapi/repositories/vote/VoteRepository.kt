package com.chytac.formsapi.repositories.vote

import com.chytac.formsapi.entities.vote.VoteEntity
import org.springframework.data.jpa.repository.JpaRepository

interface VoteRepository : JpaRepository<VoteEntity, Int> {
}