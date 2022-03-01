package com.karoliinamultas.parliamentmembersproject.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karoliinamultas.parliamentmembersproject.MemberOfParliament

@Dao
interface PoliticianDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPolitician(politician: MemberOfParliament)

    @Query("SELECT * FROM politician_table")
    fun readAllData(): LiveData<List<MemberOfParliament>>

}