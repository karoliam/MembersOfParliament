package com.karoliinamultas.parliamentmembersproject.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.karoliinamultas.parliamentmembersproject.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemberPageViewModel(application: Application): AndroidViewModel(application) {
    private val repository =
        PoliticianRepository(PoliticianDB.getDatabase(getApplication()).politicianDao())
    val members: LiveData<List<Politician>> = repository.allData


    fun extractInfo(memberList: List<Politician>, memberName: String): String {
        return memberList.filter { it.first + " " + it.last == memberName }.joinToString(" ") {
            "Seat number: " + it.seatNumber + "\nBorn year: " +
                    it.bornYear + "\nMinister: " + if (it.minister) "Yes!" else "no" +
                    "\nConstituency: " + it.constituency + "\nTwitter: " + if(it.twitter=="") "No twitter!" else it.twitter
        }
    }
    fun extractPersonNumber(memberList: List<Politician>, memberName: String): Int {
        return memberList.filter{it.first + " " + it.last == memberName}.map { it.personNumber }.joinToString(" ").toInt()
    }

    fun addComment(comment: String, personNumber: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addComment(comment, personNumber)
        }
    }
    val comments = repository.allComments
    val thumbsUp = repository.allThumbsUp
    val thumbsDown = repository.allThumbsDown


    fun extractComment(commentList: List<PComment>, personNumber:Int): String {
        return commentList.filter { it.personNumber == personNumber }
            .joinToString("\n") { it.comment }
    }

    fun addThumbsUp(thumbsUp: Int, personNumber: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addThumbsUp(thumbsUp, personNumber)
        }
    }

    fun extractThumbsUp(thumbsUpList: List<ThumbsUp>, personNumber: Int): List<Int> {
        return thumbsUpList.filter { it.personNumber == personNumber }.map { it.thumbUp }
    }

    fun extractThumbsDown(thumbsDownList: List<ThumbsDown>, personNumber: Int): List<Int> {
        return thumbsDownList.filter { it.personNumber == personNumber }.map { it.thumbDown }
    }

    fun addThumbsDown(thumbsDown: Int, personNumber: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addThumbsDown(thumbsDown, personNumber)
        }
    }


}