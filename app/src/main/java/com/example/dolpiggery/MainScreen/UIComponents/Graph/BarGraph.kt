package com.example.dolpiggery.MainScreen.UIComponents.Graph

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisConfig
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.axis.Gravity
import co.yml.charts.common.model.Point
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarChartType
import co.yml.charts.ui.barchart.models.BarData
import co.yml.charts.ui.barchart.models.BarStyle
import co.yml.charts.ui.barchart.models.drawBarGraph
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Snow60

@Composable
fun BarGraph(
    buwan: String,
    barDataList: List<BarData>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Snow60)
    ) {
        Log.i("Hey", "Here BarGraph")
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
//            Text(text = buwan)
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Snow60)
                    .padding(10.dp)
            ) {
                val yStepSize = 10
                val maxRange = 50

                val xAxisData = AxisData.Builder()
                    .axisStepSize(30.dp)
                    .steps(barDataList.size - 1)
                    .bottomPadding(40.dp)
                    .axisLabelAngle(20f)
                    .startDrawPadding(20.dp)
                    .labelData { index ->
                        barDataList[index].label
                    }
                    .build()

                val yAxisData = AxisData.Builder()
                    .steps(10)
                    .backgroundColor(Snow60)
                    .labelAndAxisLinePadding(20.dp)
                    .axisOffset(20.dp)
                    .labelData { index ->
                        (index * (maxRange / yStepSize)).toString()
                    }
                    .axisConfig(AxisConfig())
                    .build()

                val barChart = BarChartData(
                    chartData = barDataList,
                    xAxisData = xAxisData,
                    yAxisData = yAxisData,
                    backgroundColor = Snow60,
                    paddingEnd = 0.dp,
                    horizontalExtraSpace = 20.dp,
                )

                if(barDataList.isNotEmpty()) {
                    Log.i("Hey", "Here Here")
                    BarChart(
                        modifier = Modifier
                            .height(450.dp)
                            .background(Snow60),
                        barChartData = barChart
                    )
                }
            }
        }
    }
}