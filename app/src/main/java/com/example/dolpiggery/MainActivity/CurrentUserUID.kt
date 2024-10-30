package com.example.dolpiggery.MainActivity

object CurrentUserUID {
    lateinit var uid: String

    fun setUID(uid: String) {
        this.uid = uid
    }

    fun getUID(): String {
        return uid
    }
}