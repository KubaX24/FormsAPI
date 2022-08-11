package com.chytac.formsapi.controllers

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController : ErrorController{

    @GetMapping(value = ["/"], produces = ["application/json"])
    fun indexMapping(): String{
        return "v1";
    }

    @GetMapping(value = ["/status"], produces = ["application/json"])
    fun getStatus(): String{
        return "ok";
    }

    @GetMapping(value = ["/error"], produces = ["application/json"])
    fun errorHandler(): String{
        return """
            {
                "status": 404,
                "message": "Not found!"
            }
        """.trimIndent()
    }
}