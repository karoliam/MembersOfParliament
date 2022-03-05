package com.karoliinamultas.parliamentmembersproject.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.karoliinamultas.parliamentmembersproject.data.Politician
import com.karoliinamultas.parliamentmembersproject.data.PoliticianDB
import com.karoliinamultas.parliamentmembersproject.data.PoliticianRepository

class MembersViewModel(application: Application): AndroidViewModel(application) @Inject constructor() {
    private val repository = PoliticianRepository(PoliticianDB.getDatabase(getApplication()).politicianDao())
    val members: LiveData<List<String>> = Transformations.map(repository.allData, { extractParties(it)})


    private fun extractParties(memberList: List<Politician>): List<String> {
        return memberList.map { it.first + " " + it.last}
    }


}