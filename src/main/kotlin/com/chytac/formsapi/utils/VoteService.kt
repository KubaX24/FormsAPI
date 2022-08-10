package com.chytac.formsapi.utils

import com.chytac.formsapi.entities.vote.VoteAnswersEntity
import com.chytac.formsapi.entities.vote.VoteAnswersProfileEntity
import com.chytac.formsapi.entities.vote.VoteDatesEntity
import com.chytac.formsapi.entities.vote.VoteEntity
import com.chytac.formsapi.entities.vote.objects.AnswerObject
import com.chytac.formsapi.repositories.vote.VoteAnswersProfileRepository
import com.chytac.formsapi.repositories.vote.VoteAnswersRepository
import com.chytac.formsapi.repositories.vote.VoteDatesRepository
import com.chytac.formsapi.repositories.vote.VoteRepository
import org.springframework.stereotype.Service

@Service
class VoteService(
    val voteAnswersProfileRepository: VoteAnswersProfileRepository,
    val voteAnswersRepository: VoteAnswersRepository,
    val voteDatesRepository: VoteDatesRepository,
    val voteRepository: VoteRepository
    ) {

    fun findAllVotes(): List<VoteEntity> {
        return voteRepository.findAll()
    }

    fun findVoteDateByIdVote(idVote: Int): List<VoteDatesEntity> {
        return voteDatesRepository.findAllByIdVote(idVote)
    }

    fun findVoteById(idVote: Int): VoteEntity {
        return voteRepository.findById(idVote).get()
    }

    fun findAllAnswersByIdVote(idVote: Int):List<AnswerObject>{
        val answerProfiles: List<VoteAnswersProfileEntity> = voteAnswersProfileRepository.findAllByIdVote(idVote)
        var answerObjectList: List<AnswerObject> = emptyList()

        for (answerProfile in answerProfiles) {
            val answers: List<VoteAnswersEntity> = voteAnswersRepository.findAllByIdProfile(answerProfile.id)

            answerObjectList += AnswerObject(answerProfile.name, answers)
        }

        return answerObjectList
    }
}