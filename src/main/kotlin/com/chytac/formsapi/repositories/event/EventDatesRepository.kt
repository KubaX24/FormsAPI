package com.chytac.formsapi.repositories.event

import com.chytac.formsapi.entities.event.EventDatesEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventDatesRepository : JpaRepository<EventDatesEntity, Int> {
}