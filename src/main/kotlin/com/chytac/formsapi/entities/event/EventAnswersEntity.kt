package com.chytac.formsapi.entities.event

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class EventAnswersEntity(
    @Id @GeneratedValue val id: Int,
    val idProfile: Int,
    val idDate: Int,
    val idEvent: Int
    )
