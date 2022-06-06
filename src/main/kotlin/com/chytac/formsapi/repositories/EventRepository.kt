package com.chytac.formsapi.repositories

import com.chytac.formsapi.entities.EventEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<EventEntity, Int> {
}