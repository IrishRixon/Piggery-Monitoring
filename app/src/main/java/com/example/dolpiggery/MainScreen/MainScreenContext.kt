package com.example.dolpiggery.MainScreen

object MainScreenContext {
    private lateinit var context: MainScreen

    fun setContext(context: MainScreen) {
        this.context = context
    }

    fun getContext() : MainScreen {
        return context
    }
}