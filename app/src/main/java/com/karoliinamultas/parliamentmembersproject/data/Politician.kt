package com.karoliinamultas.parliamentmembersproject.data
//date: 6.3.2022
//name: Karoliina Multas
//student id: 2101425
//data classes for entities (Politician, PComment, ThumbsUp and ThumbsDown).

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
    val comment: String,
    val personNumber: Int
)

@Entity(tableName = "thumbsUp")
data class ThumbsUp (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val thumbUp: Int,
    val personNumber: Int
)

@Entity(tableName = "thumbsDown")
data class ThumbsDown (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val thumbDown: Int,
    val personNumber: Int
)