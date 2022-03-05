package com.karoliinamultas.parliamentmembersproject.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.karoliinamultas.parliamentmembersproject.data.Politician
import com.karoliinamultas.parliamentmembersproject.data.PoliticianDB
import com.karoliinamultas.parliamentmembersproject.data.PoliticianRepository


class PoliticianViewModel(application: Application): AndroidViewModel(application) {


    private val readAllData: LiveData<List<Politician>>
    private val repository: PoliticianRepository


    init {
        val politicianDao = PoliticianDB.getDatabase(application).politicianDao()
        repository = PoliticianRepository(politicianDao)
        readAllData = repository.allData
    }

    val politicians = readAllData

}