package com.chytac.formsapi.controllers.event

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController {


    @GetMapping("/events")
    fun getAllEvents(){

    }
}