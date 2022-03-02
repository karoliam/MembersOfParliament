package com.karoliinamultas.parliamentmembersproject.data

import androidx.lifecycle.LiveData


class PoliticianRepository(private val politicianDao: PoliticianDao) {

    val readAllData: LiveData<List<Politician>> = politicianDao.readAllData()

    suspend fun addPolitician(politician: Politician) {
        politicianDao.addPolitician(politician)
    }
}
