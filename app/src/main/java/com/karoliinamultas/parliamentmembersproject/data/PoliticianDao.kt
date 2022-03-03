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

    @Query("SELECT * FROM politician_table ORDER BY personNumber")
    fun readAllData(): LiveData<List<Politician>>
}