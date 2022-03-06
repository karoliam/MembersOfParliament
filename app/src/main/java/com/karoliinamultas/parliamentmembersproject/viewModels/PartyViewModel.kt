package com.karoliinamultas.parliamentmembersproject.viewModels

//date: 6.3.2022
//name: Karoliina Multas
//student id: 2101425
//ViewModel for PartiesFragment. It extracts the names of the parties.

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.karoliinamultas.parliamentmembersproject.data.*

class PartyViewModel(application: Application): AndroidViewModel(application) {

    private val repository = PoliticianRepository(PoliticianDB.getDatabase(getApplication()).politicianDao())
    val parties: LiveData<List<String>> = Transformations.map(repository.allData, { extractParties(it)})


    private fun extractParties(memberList: List<Politician>): List<String> {
        return memberList.map { it.party }.toSortedSet().toList()
    }
}