package com.chytac.formsapi.controllers.event

import com.chytac.formsapi.entities.event.EventDatesEntity
import com.chytac.formsapi.entities.event.EventEntity
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
}

data class EventObject(val name: String, val description: String, val listOfDates: List<EventDatesEntity>)