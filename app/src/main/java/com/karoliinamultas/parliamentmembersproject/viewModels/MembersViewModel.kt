package com.karoliinamultas.parliamentmembersproject.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.karoliinamultas.parliamentmembersproject.data.Politician
import com.karoliinamultas.parliamentmembersproject.data.PoliticianDB
import com.karoliinamultas.parliamentmembersproject.data.PoliticianRepository

class MembersViewModel(application: Application): AndroidViewModel(application) {
    private val repository = PoliticianRepository(PoliticianDB.getDatabase(getApplication()).politicianDao())
    val members: LiveData<List<Politician>> = repository.allData


    fun extractParties(memberList: List<Politician>, partyName: String): List<String> {
        return memberList.filter { it.party == partyName }.map { it.first + " " + it.last}
    }


}