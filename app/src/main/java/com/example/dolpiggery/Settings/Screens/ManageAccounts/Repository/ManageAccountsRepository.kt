package com.example.dolpiggery.Settings.Screens.ManageAccounts.Repository

import android.util.Log
import com.example.dolpiggery.Settings.Screens.ManageAccounts.DataClass.UserAccount
import com.example.dolpiggery.Settings.Screens.ManageAccounts.Interface.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ManageAccountsRepository {
    fun getUsersAccount(onGot: (List<UserAccount>) -> Unit) {
        Log.i("hi", "repo: Breakpoint")

        val retrofit = getRetrofit()

        Log.i("hi", "repo: Breakpoint1")


        retrofit.getUsersAccount().enqueue(object : Callback<List<UserAccount>> {
            override fun onResponse(p0: Call<List<UserAccount>>, p1: Response<List<UserAccount>>) {
                Log.i("Yowsi", "repo: ${p1.code()}, ${p1.body()}")

                val listOfUsersAccount = mutableListOf<UserAccount>()
                if (p1.isSuccessful) {
                    Log.i("hi", "repo: Breakpoint3")

                    p1.body()?.let {
                        Log.i("hi", "repo: Breakpoint4")

                        for (user in it) {
                            Log.i("hi", "repo: Breakpoint5")

                            listOfUsersAccount.add(user)
                        }
                    }
                    onGot(listOfUsersAccount)
                    Log.i("hi", "repo: list ${listOfUsersAccount}")
                }
            }

            override fun onFailure(p0: Call<List<UserAccount>>, p1: Throwable) {
                Log.i("hi", "onFailure: ${p1.message}")
            }
        })
    }

    fun deleteAccount(uid: String, toast: () -> Unit) {
        val retrofit = getRetrofit()

        retrofit.deleteUser(uid).enqueue( object : Callback<Unit> {
            override fun onResponse(p0: Call<Unit>, p1: Response<Unit>) {
                if(p1.isSuccessful) {
                    toast()
                }
            }

            override fun onFailure(p0: Call<Unit>, p1: Throwable) {
                Log.i("Yowsi", "delete user onFailure: ${p1.message}")
            }

        })

    }

    private fun getRetrofit(): API {
        return Retrofit.Builder()
            .baseUrl("http://192.168.100.23:5000/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }
}