package com.example.dolpiggery

import com.example.dolpiggery.MainActivity.MainActivity

object Context {
    private lateinit var context: MainActivity

    fun setContext(context: MainActivity) {
        Context.context = context
    }

    fun getContext(): MainActivity {
        return context
    }
}