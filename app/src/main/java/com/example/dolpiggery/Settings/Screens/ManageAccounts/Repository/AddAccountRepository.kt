package com.example.dolpiggery.Settings.Screens.ManageAccounts.Repository

import android.util.Log
import com.example.dolpiggery.Settings.Screens.ManageAccounts.DataClass.CreateUserResponse
import com.example.dolpiggery.Settings.Screens.ManageAccounts.DataClass.User
import com.example.dolpiggery.Settings.Screens.ManageAccounts.Interface.API
import com.google.firebase.database.FirebaseDatabase
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddAccountRepository {
    val databaseReference = FirebaseDatabase.getInstance().getReference()

    fun addAccount(
        email: String,
        password: String,
        phoneNumber: String,
        toast: (code: Int, txt:String) -> Unit
    ) {
        val api = getAPI()
        val user = User(email, password, phoneNumber)

        api.addAccount(user = user).enqueue(object : Callback<CreateUserResponse> {
            override fun onResponse(p0: Call<CreateUserResponse>, p1: Response<CreateUserResponse>) {
                Log.i("Yowsi", "onResponse: ${p1.errorBody()}")
                if(p1.isSuccessful) {
                    val message = p1.body()?.message
                    toast(p1.code(), message.toString())
                    storePhoneNumber(p1.body()?.uid.toString(), phoneNumber)
                }
                else {
                    // Parse the error response from JSON
                    val errorResponse = p1.errorBody()?.string()
                    val errorMessage = JSONObject(errorResponse).getString("error")

                    toast(p1.code(), errorMessage)
                }
            }

            override fun onFailure(p0: Call<CreateUserResponse>, p1: Throwable) {
                toast(400,"${p1.message}")
            }

        })
    }

    fun patchAccount(
        uid: String,
        email: String,
        password: String,
        phoneNumber: String,
        toast: (code: Int, txt: String) -> Unit
    ) {

        val api = getAPI()
        val user = User(email, password, phoneNumber)

        api.patchAccount(user, uid).enqueue(object : Callback<Unit> {
            override fun onResponse(p0: Call<Unit>, p1: Response<Unit>) {
                if(p1.isSuccessful) {
                    toast(200, "Successfully updated '$email'")
                    updatePhoneNumber(uid, phoneNumber)
                }
                else {
                    val errorResponse = p1.errorBody()?.string()
                    val errorMessage = JSONObject(errorResponse).getString("error")
                    toast(p1.code(), errorMessage)
                }
            }

            override fun onFailure(p0: Call<Unit>, p1: Throwable) {
                toast(400,"${p1.message}")
            }
        })
    }

    private fun getAPI(): API {
        return Retrofit.Builder()
            //.baseUrl("http://192.168.100.23:5000/api/v1/") //Home Wifi
            .baseUrl("http://192.168.6.101:5000/api/v1/") //Dungca Wifi
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }

    fun storePhoneNumber(uid: String, phoneNumber: String) {
        databaseReference.child("phoneNumber").child(uid).setValue(phoneNumber)
    }

    fun updatePhoneNumber(uid: String, phoneNumber: String) {
        databaseReference.child("phoneNumber").child(uid).setValue(phoneNumber)
    }
}