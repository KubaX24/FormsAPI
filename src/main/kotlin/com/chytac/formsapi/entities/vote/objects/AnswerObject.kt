package com.chytac.formsapi.entities.vote.objects

import com.chytac.formsapi.entities.vote.VoteAnswersEntity

data class AnswerObject(val authorName: String, val listOfAnswers: List<VoteAnswersEntity>)