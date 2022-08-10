package com.chytac.formsapi.controllers.vote

import com.chytac.formsapi.entities.vote.*
import com.chytac.formsapi.entities.vote.objects.AnswerObject
import com.chytac.formsapi.utils.VoteService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class VoteController(val voteService: VoteService) {

    @GetMapping("/vote/{id}")
    fun getVoteById(@PathVariable id: Int): VoteObject {
        val voteEntity: VoteEntity = voteService.findVoteById(id)
        val voteDatesEntity: List<VoteDatesEntity> = voteService.findVoteDateByIdVote(id)

        return VoteObject(voteEntity.name, voteEntity.description, voteDatesEntity)
    }

    @PostMapping("/vote")
    fun addVote(@RequestBody vote: VoteObject) {
        val voteEntity: VoteEntity = voteService.voteRepository.save(VoteEntity(name = vote.name, description = vote.description))
        for (voteDate in vote.listOfDates) {
            voteService.voteDatesRepository.save(VoteDatesEntity(idVote = voteEntity.id, date = voteDate.date))
        }
    }

    @GetMapping("/vote/{id}/answers")
    fun getAnswersByVoteID(@PathVariable id: Int): List<AnswerObject>{
        return voteService.findAllAnswersByIdVote(id)
    }

    @PostMapping("/vote/{id}/answer")
    fun addAnswer(@PathVariable id: Int, @RequestBody answer: AnswerObject){
        val answerProfile: VoteAnswersProfileEntity = voteService.voteAnswersProfileRepository.save(VoteAnswersProfileEntity(name = answer.authorName, idVote = id))
        for (answerDates in answer.listOfAnswers){
            println(voteService.voteAnswersRepository.save(VoteAnswersEntity(idProfile = answerProfile.id, idDate = answerDates.idDate, idVote = id, type = answerDates.type)))
        }
    }
}

data class VoteObject(val name: String, val description: String, val listOfDates: List<VoteDatesEntity>)