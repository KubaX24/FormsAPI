package com.chytac.formsapi.entities.event

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class EventDatesEntity(
    @Id @GeneratedValue val id: Int,
    val idEvent: Int,
    val date: LocalDate
    )