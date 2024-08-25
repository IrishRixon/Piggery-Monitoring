package com.example.piggery.MainActivity

object Context {
    private lateinit var context: MainActivity

    fun setContext(context: MainActivity) {
        this.context = context
    }

    fun getContext(): MainActivity {
        return context
    }
}