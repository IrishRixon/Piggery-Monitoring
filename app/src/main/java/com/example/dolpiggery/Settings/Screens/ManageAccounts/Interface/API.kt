package com.example.dolpiggery.Settings.Screens.ManageAccounts.Interface

import com.example.dolpiggery.Settings.Screens.ManageAccounts.DataClass.UserAccount
import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("users-list")
    fun getUsersAccount() : Call<List<UserAccount>>
}