package com.karoliinamultas.parliamentmembersproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.karoliinamultas.parliamentmembersproject.data.*


class PartyViewModel(application: Application): AndroidViewModel(application) {
    private val repository = PoliticianRepository(PoliticianDB.getDatabase(getApplication()).politicianDao())
    val parties: LiveData<List<String>> = Transformations.map(repository.readAllData, { extractParties(it)})


    private fun extractParties(memberList: List<Politician>): List<String> {
        return memberList.map { it.party }.toSortedSet().toList()
    }


}