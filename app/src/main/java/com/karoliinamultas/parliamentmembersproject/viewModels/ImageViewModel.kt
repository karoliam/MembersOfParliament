package com.karoliinamultas.parliamentmembersproject.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.karoliinamultas.parliamentmembersproject.data.Politician
import com.karoliinamultas.parliamentmembersproject.data.PoliticianDB
import com.karoliinamultas.parliamentmembersproject.data.PoliticianRepository

class ImageViewModel(application: Application): AndroidViewModel(application) {
    private val repository = PoliticianRepository(PoliticianDB.getDatabase(getApplication()).politicianDao())
    val pictureUrl: LiveData<List<Politician>> = repository.allData


    fun extractPictureUrl(memberList: List<Politician>, memberName: String): String {
        return memberList.filter { it.first + " " + it.last == memberName }
            .joinToString(" ") { it.picture }
    }
}