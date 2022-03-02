package com.karoliinamultas.parliamentmembersproject.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://users.metropolia.fi/~peterh/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("mps.json")
    suspend fun getPoliticianList(): List<Politician>
}

object PoliticianApi {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java) }
}