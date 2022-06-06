package com.chytac.formsapi.entities

import org.springframework.data.annotation.Id
import java.time.LocalDate
import javax.persistence.GeneratedValue

data class EventEntity(
    @Id @GeneratedValue val id: Int,
    val name: String,
    val description: String,
    val dates: List<LocalDate>
    )
