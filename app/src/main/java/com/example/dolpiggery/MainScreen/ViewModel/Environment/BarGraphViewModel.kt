package com.example.dolpiggery.MainScreen.ViewModel.Environment

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import co.yml.charts.common.model.Point
import co.yml.charts.ui.barchart.models.BarData
import com.example.dolpiggery.MainScreen.DataClass.Environment.BarGraph.BarGraphDataClass
import com.example.dolpiggery.MainScreen.Repository.Environment.BarGraphRepository

class BarGraphViewModel: ViewModel() {
    val barGraphRepository = BarGraphRepository()

    val buwan = mutableStateOf("")
    val barGraphDataList = mutableStateListOf<BarGraphDataClass>()

    val barDataList = mutableStateListOf<BarData>()

    fun addBarGraphData() {
//            Log.i("Hey", "Here addBarGraphData")
        barGraphRepository.addBarGraphData(addBuwan = {
            buwan.value = it
            Log.i("Hey", "Here addBuwan $buwan")
        },
            onDataChanged = {
                barGraphDataList.clear()
                barGraphDataList.addAll(it)
                Log.i("Hey", "Here onDataChanged $barGraphDataList")
            })

    }

    fun addBarDataList() {
        if(barGraphDataList.isNotEmpty()) {
            for (data in barGraphDataList) {
                Log.i("Hey", "addBarDatalist $barGraphDataList")
                barDataList.add(BarData(
                    point = Point(
                        x = data.araw.toFloat(),
                        y = data.highestTemp.toFloat() / 5f,
                    ),
                    label = data.araw.toString(),
                    description = data.highestTemp.toString()
                ))
            }
        }
    }

}