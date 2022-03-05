package com.karoliinamultas.parliamentmembersproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Politician::class, PComment::class], version = 2, exportSchema = false)
abstract class PoliticianDB: RoomDatabase() {

    abstract fun politicianDao(): PoliticianDao

    companion object {
        @Volatile
        private var INSTANCE: PoliticianDB? = null

        fun getDatabase(context: Context): PoliticianDB {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PoliticianDB::class.java,
                    "politician_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
