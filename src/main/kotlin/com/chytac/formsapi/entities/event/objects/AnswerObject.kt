package com.chytac.formsapi.entities.event.objects

import com.chytac.formsapi.entities.event.EventAnswersEntity

data class AnswerObject(val authorName: String, val listOfAnswers: List<EventAnswersEntity>)