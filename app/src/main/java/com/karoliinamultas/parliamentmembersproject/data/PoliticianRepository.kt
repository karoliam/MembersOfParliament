package com.karoliinamultas.parliamentmembersproject.data

import androidx.lifecycle.LiveData
import kotlin.coroutines.coroutineContext


class PoliticianRepository(private val politicianDao: PoliticianDao) {

    val allData: LiveData<List<Politician>> = politicianDao.readAllData()
    val allComments: LiveData<List<PComment>> = politicianDao.readAllComments()
    val allThumbsUp: LiveData<List<ThumbsUp>> = politicianDao.readAllThumbsUp()
    val allThumbsDown: LiveData<List<ThumbsDown>> = politicianDao.readAllThumbsDown()

    suspend fun addComment(comment: String, personNumber: Int) {
        PoliticianDB.getDatabase().politicianDao().addComment(PComment(0, comment, personNumber))
    }
    suspend fun addThumbsUp(thumbsUp: Int, personNumber: Int) {
        PoliticianDB.getDatabase().politicianDao().addThumbsUp(ThumbsUp(0, thumbsUp, personNumber))
    }
    suspend fun addThumbsDown(thumbsDown: Int, personNumber: Int) {
        PoliticianDB.getDatabase().politicianDao().addThumbsDown(ThumbsDown(0,thumbsDown, personNumber))
    }

}

