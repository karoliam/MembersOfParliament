package com.karoliinamultas.parliamentmembersproject.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PoliticianDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPolitician(politician: Politician)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addComment(pComment: PComment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addThumbsUp(thumbsUp: ThumbsUp)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addThumbsDown(thumbsDown: ThumbsDown)

    @Query("SELECT * FROM politician_table ORDER BY personNumber")
    fun readAllData(): LiveData<List<Politician>>

    @Query("SELECT * FROM comment")
    fun readAllComments(): LiveData<List<PComment>>

    @Query("SELECT * FROM thumbsUp")
    fun readAllThumbsUp(): LiveData<List<ThumbsUp>>

    @Query("SELECT * FROM thumbsDown")
    fun readAllThumbsDown(): LiveData<List<ThumbsDown>>
}