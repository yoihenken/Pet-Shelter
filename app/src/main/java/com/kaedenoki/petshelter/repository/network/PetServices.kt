package com.kaedenoki.petshelter.repository.network

import android.util.Log
import com.kaedenoki.petshelter.model.PetResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PetServices {
    val TAG = "PetServices"

    fun getCats(callback : (PetResponse) -> Unit){
        RetrofitInstance.getClient().getCats().enqueue(
            object  : Callback<PetResponse>{
                override fun onResponse(
                    call: Call<PetResponse>,
                    response: Response<PetResponse>
                ) {
                    Log.d(TAG, "onResponse: ${response.body()}")
                    callback(response.body()!!)
                }

                override fun onFailure(call: Call<PetResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            }
        )
    }

    fun getDogs(callback: (PetResponse) -> Unit){
        RetrofitInstance.getClient().getDogs().enqueue(
            object  : Callback<PetResponse>{
                override fun onResponse(
                    call: Call<PetResponse>,
                    response: Response<PetResponse>
                ) {
                    Log.d(TAG, "onResponse: ${response.body()}")
                    callback(response.body()!!)
                }

                override fun onFailure(call: Call<PetResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            }
        )
    }

    fun getCatDetail(end : String?, callback: (PetResponse) -> Unit){
        RetrofitInstance.getClient().getCatDetail(end).enqueue(
            object  : Callback<PetResponse>{
                override fun onResponse(
                    call: Call<PetResponse>,
                    response: Response<PetResponse>
                ) {
                    Log.d(TAG, "onResponse: ${response.body()}")
                    callback(response.body()!!)
                }

                override fun onFailure(call: Call<PetResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            }
        )
    }

    fun getDogDetail(end: String?, callback: (PetResponse) -> Unit){
        RetrofitInstance.getClient().getDogDetail(end).enqueue(
            object  : Callback<PetResponse>{
                override fun onResponse(
                    call: Call<PetResponse>,
                    response: Response<PetResponse>
                ) {
                    Log.d(TAG, "onResponse: ${response.body()}")
                    callback(response.body()!!)
                }

                override fun onFailure(call: Call<PetResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            }
        )
    }
}