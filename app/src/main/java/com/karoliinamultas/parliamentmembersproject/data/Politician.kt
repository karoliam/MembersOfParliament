package com.karoliinamultas.parliamentmembersproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "politician_table")
    data class Politician (
        @PrimaryKey
        val personNumber: Int,
        val seatNumber: Int,
        val last: String,
        val first: String,
        val party: String,
        val minister: Boolean,
        val picture: String,
        val twitter: String,
        val bornYear: Int,
        val constituency: String
    )

@Entity(tableName = "comment")
data class PComment (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val comment: String
)
