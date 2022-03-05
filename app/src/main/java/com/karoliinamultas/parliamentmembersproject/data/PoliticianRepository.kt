package com.karoliinamultas.parliamentmembersproject.data

import androidx.lifecycle.LiveData


class PoliticianRepository(private val politicianDao: PoliticianDao) {

    val allData: LiveData<List<Politician>> = politicianDao.readAllData()
    val allComments: LiveData<List<PComment>> = politicianDao.readAllComments()

    }

