package com.example.dolpiggery.Settings.Screens.ManageAccounts.Interface

import com.example.dolpiggery.Settings.Screens.ManageAccounts.DataClass.UserAccount
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("users-list")
    fun getUsersAccount() : Call<List<UserAccount>>

    @DELETE("{uid}")
    fun deleteUser(@Path("uid") uid: String) : Call<Unit>
}