package com.karoliinamultas.parliamentmembersproject.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData



class PoliticianViewModel(application: Application): AndroidViewModel(application) {


    private val readAllData: LiveData<List<Politician>>
    private val repository: PoliticianRepository
    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response


    init {
        val politicianDao = PoliticianDB.getDatabase(application).politicianDao()
        repository = PoliticianRepository(politicianDao)
        readAllData = repository.readAllData
    }

    val politicians = readAllData

}