package com.chytac.formsapi.repositories.event

import com.chytac.formsapi.entities.event.EventAnswersEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventAnswersRepository : JpaRepository<EventAnswersEntity, Int> {

    fun findAllByIdEvent(id: Int): List<EventAnswersEntity>
    fun findAllByIdProfile(id: Int?): List<EventAnswersEntity>
}