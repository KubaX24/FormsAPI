package com.chytac.formsapi.entities.vote

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class VoteDatesEntity(
    @Id @GeneratedValue val id: Int? = null,
    @JsonIgnore val idVote: Int?,
    val date: LocalDateTime
    )