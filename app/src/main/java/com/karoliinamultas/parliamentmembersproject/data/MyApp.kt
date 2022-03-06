package com.karoliinamultas.parliamentmembersproject.data
//date: 6.3.2022
//name: Karoliina Multas
//student id: 2101425
//Application class for setting the context

import android.app.Application
import android.content.Context


class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        lateinit var appContext: Context
    }
}