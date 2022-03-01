package com.karoliinamultas.parliamentmembersproject.data

import androidx.lifecycle.LiveData
import com.karoliinamultas.parliamentmembersproject.MemberOfParliament

class PoliticianRepository(private val politicianDao: PoliticianDao) {

    val readAllData: LiveData<List<MemberOfParliament>> = politicianDao.readAllData()

    suspend fun addPolitician(politician: MemberOfParliament) {
        politicianDao.addPolitician(politician)
    }
}