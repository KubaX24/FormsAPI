package com.chytac.formsapi.repositories.event

import com.chytac.formsapi.entities.event.EventEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<EventEntity, Int> {
}