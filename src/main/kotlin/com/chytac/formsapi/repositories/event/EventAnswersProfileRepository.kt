package com.chytac.formsapi.repositories.event

import com.chytac.formsapi.entities.event.EventAnswersProfileEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventAnswersProfileRepository : JpaRepository<EventAnswersProfileEntity, Int> {
}