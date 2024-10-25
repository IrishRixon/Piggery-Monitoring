package com.example.dolpiggery.Settings.Screens.ManageAccounts.Repository

import android.util.Log
import com.example.dolpiggery.Settings.Screens.ManageAccounts.DataClass.User
import com.example.dolpiggery.Settings.Screens.ManageAccounts.Interface.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddAccountRepository {

    fun addAccount(
        email: String,
        password: String,
        phoneNumber: String,
        toast: (code: Int, txt:String) -> Unit
    ) {
        val api = getAPI()
        val user = User(email, password, phoneNumber)

        api.addAccount(user = user).enqueue(object : Callback<Unit> {
            override fun onResponse(p0: Call<Unit>, p1: Response<Unit>) {
                Log.i("Yowsi", "onResponse: ${p1.code()}")
                if(p1.isSuccessful) {
                    toast(p1.code(), "Successfully Added account '$email'")
                }
                else {
                    toast( p1.code(),"Failed to add an account: Please ensure the fields followed the proper format")
                }
            }

            override fun onFailure(p0: Call<Unit>, p1: Throwable) {
                toast(400,"${p1.message}")
            }

        })
    }

    private fun getAPI(): API {
        return Retrofit.Builder()
            .baseUrl("http://192.168.100.23:5000/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }
}