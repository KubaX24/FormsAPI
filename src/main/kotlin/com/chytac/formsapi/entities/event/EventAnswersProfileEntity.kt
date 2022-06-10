package com.chytac.formsapi.entities.event

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class EventAnswersProfileEntity(
    @Id @GeneratedValue val id: Int? = null,
    val name: String,
    val idEvent: Int
    )
