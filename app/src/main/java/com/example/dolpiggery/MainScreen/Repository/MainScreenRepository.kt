package com.example.dolpiggery.MainScreen.Repository

import android.util.Log
import com.example.dolpiggery.MainScreen.DataClass.Sub
import com.example.dolpiggery.MainScreen.Interface.API
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainScreenRepository {

    fun subscribe(sub: Sub) {
        val api = getAPI()

        api.subscribe(sub).enqueue(object : Callback<Unit> {
            override fun onResponse(p0: Call<Unit>, p1: Response<Unit>) {
                if(p1.isSuccessful) {
                    Log.i("Yowsi", "Subscribed")
                }
                else {
                    val errorResponse = p1.errorBody()?.string()
                    val errorMessage = JSONObject(errorResponse).getString("error")
                    Log.i("Yowsi", "onResponseFailed: $errorMessage")
                }
            }

            override fun onFailure(p0: Call<Unit>, p1: Throwable) {
                Log.e("Yowsi", "onFailure: ${p1.message}", )
            }

        })
    }

    private fun getAPI() : API {
        return Retrofit.Builder()
            .baseUrl("http://192.168.100.23:5000/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }
}