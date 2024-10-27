package com.example.dolpiggery.Settings.Screens.ManageAccounts.Interface

import com.example.dolpiggery.Settings.Screens.ManageAccounts.DataClass.User
import com.example.dolpiggery.Settings.Screens.ManageAccounts.DataClass.UserAccount
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface API {
    @GET("users-list")
    fun getUsersAccount() : Call<List<UserAccount>>

    @DELETE("{uid}")
    fun deleteUser(@Path("uid") uid: String) : Call<Unit>

    @POST("addAccount")
    fun addAccount(@Body user: User): Call<ResponseBody>

    @PATCH("patchAccount/{uid}")
    fun patchAccount(@Body user: User, @Path("uid") uid: String): Call<Unit>
}