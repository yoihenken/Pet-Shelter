package com.kaedenoki.petshelter.repository.network

import com.kaedenoki.petshelter.model.PetResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PetContract {
    @GET("cats")
    fun getCats():Call<PetResponse>

    @GET("dogs")
    fun getDogs():Call<PetResponse>

    @GET("cats/detail/{end}")
    fun getCatDetail(
        @Path("end")
        end : String?
    ): Call<PetResponse>

    @GET("dogs/detail/{end}")
    fun getDogDetail(
        @Path("end")
        end : String?
    ): Call<PetResponse>
}