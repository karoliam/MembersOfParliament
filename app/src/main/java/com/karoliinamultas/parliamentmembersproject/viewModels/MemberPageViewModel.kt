package com.karoliinamultas.parliamentmembersproject.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.karoliinamultas.parliamentmembersproject.data.Politician
import com.karoliinamultas.parliamentmembersproject.data.PoliticianDB
import com.karoliinamultas.parliamentmembersproject.data.PoliticianRepository

class MemberPageViewModel(application: Application): AndroidViewModel(application) {
    var i = 0
    fun plus() {
        i++
    }

    private val repository =
        PoliticianRepository(PoliticianDB.getDatabase(getApplication()).politicianDao())
    val members: LiveData<List<Politician>> = repository.allData


    fun extractInfo(memberList: List<Politician>, memberName: String): String {
        return memberList.filter { it.first + " " + it.last == memberName }.joinToString(" ") {
            "Seat number: " + it.seatNumber + "\nBorn year: " +
                    it.bornYear + "\nMinister: " + if (it.minister) "Yes!" else "no" +
                    "\nConstituency: " + it.constituency + "\nTwitter: " + it.twitter
        }


    }
}