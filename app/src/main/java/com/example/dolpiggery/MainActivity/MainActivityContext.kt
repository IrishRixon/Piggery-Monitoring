package com.example.dolpiggery.MainActivity

object MainActivityContext {
    private lateinit var context: MainActivity

    fun setContext(context: MainActivity) {
        MainActivityContext.context = context
    }

    fun getContext(): MainActivity {
        return context
    }
}