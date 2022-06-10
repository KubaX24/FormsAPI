package com.chytac.formsapi.utils

import com.chytac.formsapi.entities.event.EventAnswersEntity
import com.chytac.formsapi.entities.event.EventAnswersProfileEntity
import com.chytac.formsapi.entities.event.EventDatesEntity
import com.chytac.formsapi.entities.event.EventEntity
import com.chytac.formsapi.entities.event.objects.AnswerObject
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

    fun findAllAnswersByIdEvent(idEvent: Int):List<AnswerObject>{
        val answerProfiles: List<EventAnswersProfileEntity> = eventAnswersProfileRepository.findAllByIdEvent(idEvent)
        var answerObjectList: List<AnswerObject> = emptyList()

        for (answerProfile in answerProfiles) {
            val answers: List<EventAnswersEntity> = eventAnswersRepository.findAllByIdProfile(answerProfile.id)

            answerObjectList += AnswerObject(answerProfile.name, answers)
        }

        return answerObjectList
    }
}