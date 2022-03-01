package com.karoliinamultas.parliamentmembersproject.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.karoliinamultas.parliamentmembersproject.MemberOfParliament
import com.karoliinamultas.parliamentmembersproject.ParliamentMembersData.members
import com.karoliinamultas.parliamentmembersproject.PartiesFragmentDirections
import com.karoliinamultas.parliamentmembersproject.StartScreenDirections
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PoliticianViewModel(application: Application): AndroidViewModel(application) {

    private lateinit var currentPolitician: MemberOfParliament
    private val readAllData: LiveData<List<MemberOfParliament>>
    private val repository: PoliticianRepository
//    private val _navigateToMembersFragment = MutableLiveData<Long?>()
//    val navigateToMembersFragment
//        get() = _navigateToMembersFragment


    init {
        val politicianDao = PoliticianDB.getDatabase(application).politicianDao()
        repository = PoliticianRepository(politicianDao)
        readAllData = repository.readAllData
    }

    var i = 0
    fun politicianData(): MemberOfParliament {
        currentPolitician = members[i]
        return currentPolitician
    }


    fun addPolitician(politician: MemberOfParliament) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPolitician(politician)
        }
    }
//    fun onPartyClicked(id: Long) {
//        _navigateToMembersFragment.value = id
//    }
    val politicians = readAllData
//
//    fun onPartyNavigated() {
//        _navigateToMembersFragment.value = null
//    }
}