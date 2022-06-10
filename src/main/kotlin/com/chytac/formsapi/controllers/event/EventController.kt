package com.chytac.formsapi.controllers.event

import com.chytac.formsapi.entities.event.*
import com.chytac.formsapi.entities.event.objects.AnswerObject
import com.chytac.formsapi.utils.EventService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController(val eventService: EventService) {

    @GetMapping("/event/{id}")
    fun getEventById(@PathVariable id: Int): EventObject {
        val eventEntity: EventEntity = eventService.findEventById(id)
        val eventDatesEntity: List<EventDatesEntity> = eventService.findEventDateByIdEvent(id)

        return EventObject(eventEntity.name, eventEntity.description, eventDatesEntity)
    }

    @PostMapping("/event")
    fun addEvent(@RequestBody event: EventObject) {
        val eventEntity: EventEntity = eventService.eventRepository.save(EventEntity(name = event.name, description = event.description))
        for (eventDate in event.listOfDates) {
            eventService.eventDatesRepository.save(EventDatesEntity(idEvent = eventEntity.id, date = eventDate.date))
        }
    }

    @GetMapping("/event/{id}/answers")
    fun getAnswersByEventID(@PathVariable id: Int): List<AnswerObject>{
        return eventService.findAllAnswersByIdEvent(id)
    }

    @PostMapping("/event/{id}/answer")
    fun addAnswer(@PathVariable id: Int, @RequestBody answer: AnswerObject){
        val answerProfile: EventAnswersProfileEntity = eventService.eventAnswersProfileRepository.save(EventAnswersProfileEntity(name = answer.authorName, idEvent = id))
        for (answerDates in answer.listOfAnswers){
            println(eventService.eventAnswersRepository.save(EventAnswersEntity(idProfile = answerProfile.id, idDate = answerDates.idDate, idEvent = id, type = answerDates.type)))
        }
    }
}

data class EventObject(val name: String, val description: String, val listOfDates: List<EventDatesEntity>)