package com.chytac.formsapi.entities.vote

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class VoteAnswersEntity(
    @JsonIgnore @Id @GeneratedValue val id: Int? = null,
    @JsonIgnore val idProfile: Int?,
    val idDate: Int,
    @JsonIgnore val idVote: Int,
    val type: Int
    )

/**
 * TYPES
 * 0 - NO
 * 1 - IDK
 * 2 - YES
 */