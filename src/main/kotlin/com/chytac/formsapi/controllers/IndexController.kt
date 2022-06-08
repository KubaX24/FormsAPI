package com.chytac.formsapi.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/")
    fun indexMapping(): String{
        return "v1";
    }

    @GetMapping("/status")
    fun getStatus(): String{
        return "ok";
    }
}