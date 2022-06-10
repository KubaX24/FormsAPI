package com.chytac.formsapi.entities.event

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class EventAnswersEntity(
    @JsonIgnore @Id @GeneratedValue val id: Int? = null,
    @JsonIgnore val idProfile: Int?,
    val idDate: Int,
    @JsonIgnore val idEvent: Int,
    val type: Int
    )

/**
 * TYPES
 * 0 - NO
 * 1 - YES
 * 2 - IDK
 */