package com.chytac.formsapi.controllers.vote

import com.chytac.formsapi.entities.vote.*
import com.chytac.formsapi.entities.vote.objects.AnswerObject
import com.chytac.formsapi.utils.HashIDUtil
import com.chytac.formsapi.utils.VoteService
import org.springframework.web.bind.annotation.*

@RestController
class VoteController(val voteService: VoteService) {

    @CrossOrigin
    @GetMapping("/vote/{hash_id}")
    fun getVoteById(@PathVariable hash_id: String): VoteObject {
        val id: Int = HashIDUtil.getId(hash_id).toInt()

        val voteEntity: VoteEntity = voteService.findVoteById(id)
        val voteDatesEntity: List<VoteDatesEntity> = voteService.findVoteDateByIdVote(id)

        return VoteObject(voteEntity.name, voteEntity.description, voteDatesEntity)
    }

    @CrossOrigin
    @PostMapping("/vote")
    fun addVote(@RequestBody vote: VoteObject): ResponseObject{
        val voteEntity: VoteEntity = voteService.voteRepository.save(VoteEntity(name = vote.name, description = vote.description))
        for (voteDate in vote.listOfDates) {
            voteService.voteDatesRepository.save(VoteDatesEntity(idVote = voteEntity.id, date = voteDate.date))
        }

        return ResponseObject(HashIDUtil.getHash(voteEntity.id!!.toLong()))
    }

    @CrossOrigin
    @GetMapping("/vote/{hash_id}/answers")
    fun getAnswersByVoteID(@PathVariable hash_id: String): List<AnswerObject>{
        val id: Int = HashIDUtil.getId(hash_id).toInt()

        return voteService.findAllAnswersByIdVote(id)
    }

    @CrossOrigin
    @PostMapping("/vote/{hash_id}/answer")
    fun addAnswer(@PathVariable hash_id: String, @RequestBody answer: AnswerObject){
        val id: Int = HashIDUtil.getId(hash_id).toInt()

        val answerProfile: VoteAnswersProfileEntity = voteService.voteAnswersProfileRepository.save(VoteAnswersProfileEntity(name = answer.authorName, idVote = id))
        for (answerDates in answer.listOfAnswers){
            voteService.voteAnswersRepository.save(VoteAnswersEntity(idProfile = answerProfile.id, idDate = answerDates.idDate, idVote = id, type = answerDates.type))
        }
    }
}

data class VoteObject(val name: String, val description: String, val listOfDates: List<VoteDatesEntity>)
data class ResponseObject(val id: String)