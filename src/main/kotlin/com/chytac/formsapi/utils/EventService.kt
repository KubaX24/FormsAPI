package com.chytac.formsapi.utils

import com.chytac.formsapi.entities.event.EventDatesEntity
import com.chytac.formsapi.entities.event.EventEntity
import com.chytac.formsapi.repositories.event.EventAnswersProfileRepository
import com.chytac.formsapi.repositories.event.EventAnswersRepository
import com.chytac.formsapi.repositories.event.EventDatesRepository
import com.chytac.formsapi.repositories.event.EventRepository
import org.springframework.stereotype.Service

@Service
class EventService(
    val eventAnswersProfileRepository: EventAnswersProfileRepository,
    val eventAnswersRepository: EventAnswersRepository,
    val eventDatesRepository: EventDatesRepository,
    val eventRepository: EventRepository
    ) {

    fun findAllEvents(): List<EventEntity> {
        return eventRepository.findAll()
    }

    fun findEventDateByIdEvent(idEvent: Int): List<EventDatesEntity> {
        return eventDatesRepository.findAllByIdEvent(idEvent)
    }

    fun findEventById(idEvent: Int): EventEntity {
        return eventRepository.findById(idEvent).get()
    }
}