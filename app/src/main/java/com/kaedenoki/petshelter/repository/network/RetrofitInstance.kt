package com.kaedenoki.petshelter.repository.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val baseSource : Retrofit = Retrofit.Builder()
        .baseUrl("https://cat-dog.kaedenoki.net/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getClient(): PetContract = baseSource.create(PetContract::class.java)
}