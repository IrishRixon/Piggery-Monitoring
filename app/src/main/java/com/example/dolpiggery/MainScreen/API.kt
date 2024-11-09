package com.example.dolpiggery.MainScreen

import com.example.dolpiggery.MainScreen.DataClass.Sub
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("subscribe")
    fun subscribe(@Body sub: Sub): Call<Unit>
}