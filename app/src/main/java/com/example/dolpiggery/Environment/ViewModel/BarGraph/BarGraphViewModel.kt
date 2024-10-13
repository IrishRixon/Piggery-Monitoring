package com.example.dolpiggery.Environment.ViewModel.BarGraph

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import co.yml.charts.common.model.Point
import co.yml.charts.ui.barchart.models.BarData
import com.example.dolpiggery.Environment.DataClass.BarGraph.BarGraphDataClass
import com.example.dolpiggery.Environment.Repository.BarGraph.BarGraphRepository

class BarGraphViewModel : ViewModel() {
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
        Log.i("Bar", "AddbarDatalist")
        var i = 1
        if (barGraphDataList.isNotEmpty()) {
            barDataList.clear()
            for (data in barGraphDataList) {
                Log.i("Hey", "data $data")
                while (data.araw != i) {
                    barDataList.add(
                        BarData(
                            point = Point(
                                x = i.toFloat(),
                                y = 0f,
                            ),
                            label = i.toString(),
                            description = 0.toString()
                        )
                    )
                    i++
                }

                barDataList.add(
                    BarData(
                        point = Point(
                            x = i.toFloat(),
                            y = data.highestTemp.toFloat() / 5f,
                        ),
                        label = i.toString(),
                        description = data.highestTemp.toString()
                    )
                )
                i++
            }
            Log.i("Hey", "addBarDatalist $barDataList")
        }
    }

}