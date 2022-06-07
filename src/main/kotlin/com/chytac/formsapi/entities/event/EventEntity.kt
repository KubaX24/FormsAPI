package com.chytac.formsapi.entities.event

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class EventEntity(
    @Id @GeneratedValue val id: Int,
    val name: String,
    val description: String
    )
