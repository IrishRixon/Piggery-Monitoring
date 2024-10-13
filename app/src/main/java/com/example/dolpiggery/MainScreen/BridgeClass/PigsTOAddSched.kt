package com.example.dolpiggery.MainScreen.BridgeClass

import com.example.dolpiggery.Pigs.ViewModel.Cubicles.CubiclesViewModel

object PigsTOAddSched {
    var viewModel: CubiclesViewModel? = null

    fun setPigViewModel(viewModel: CubiclesViewModel) {
        this.viewModel = viewModel
    }

    fun getPigViewModel(): CubiclesViewModel? {
        return viewModel
    }
}