package com.chytac.formsapi.entities.event

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class EventDatesEntity(
    @Id @GeneratedValue val id: Int? = null,
    @JsonIgnore val idEvent: Int?,
    val date: LocalDateTime
    )