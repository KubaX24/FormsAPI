package com.chytac.formsapi.entities.vote

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class VoteEntity(
    @Id @GeneratedValue val id: Int? = null,
    val name: String,
    val description: String
    )
