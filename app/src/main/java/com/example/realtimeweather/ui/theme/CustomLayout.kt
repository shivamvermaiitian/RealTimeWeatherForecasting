package com.example.realtimeweather.ui.theme

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.dp


@Composable
fun FlowRow(
    modifier: Modifier = Modifier,
    content: @Composable ()-> Unit
) {

    Layout(modifier = Modifier,
        measurePolicy = { measurables,constraints ->
                        val placeable = measurables.map {
                            it.measure(constraints)
                        }
            val groupedPlaceable = mutableListOf<List<Placeable>>()
            var currentGroup = mutableListOf<Placeable>()
            var currentGroupWidth =0
            placeable.forEach { placeable ->
                if (currentGroupWidth+placeable.width<=constraints.maxWidth){
                    currentGroup.add(placeable)
                    currentGroupWidth+=placeable.width
                }else{
                    groupedPlaceable.add(currentGroup)
                    currentGroup= mutableListOf(placeable)
                    currentGroupWidth=placeable.width
                }
            }
            if (currentGroup.isNotEmpty()){
                groupedPlaceable.add(currentGroup)
            }

            layout(
                width = constraints.maxWidth,
                height = constraints.maxHeight
            ){
                var yPosition=0
                groupedPlaceable.forEach { row ->
                    var xPosition =0
                    row.forEach { placeable ->
                        placeable.place(
                            x=xPosition,
                            y=yPosition
                        )
                        xPosition+=placeable.width
                    }
                    yPosition+=row.maxOfOrNull { it.height }?:0
                }
            }
        },
        content = content
    )
}











//Layout(
//        modifier = Modifier,
//        measurePolicy ={measurables, constraints ->
//                       val placeable=measurables.map{
//                           it.measure(constraints)
//                       }
//            layout()
//
//        } ,
//         content = content
//    ){
//
//    }

//@Composable
//fun CustomLayoutCompose(
//    modifier: Modifier = Modifier,
//    content:@Composable () -> Unit
//
//) {
//    Layout(measurePolicy =)
//
//}





































@Composable
fun CustomLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        // Measure children
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        // Determine the size of the layout
        val width = constraints.maxWidth
        val height = placeables.sumOf { it.height }

        // Layout the children
        layout(width, height) {
            var yPosition = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height
            }
        }
    }
}
@Composable
fun MyCustomLayoutScreen() {
    CustomLayout {
        Text(text = "First item")
        Text(text = "Second item")
        Text(text = "Third item")
        // Add more items as needed
    }
}

@Composable
fun StaggeredGridLayout(
    modifier: Modifier = Modifier,
    columns: Int,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        // Measure the children
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        // Track the current x and y positions for placing children
        val columnWidths = IntArray(columns) { 0 }
        val columnHeights = IntArray(columns) { 0 }

        placeables.forEachIndexed { index, placeable ->
            val column = index % columns
            columnWidths[column] = maxOf(columnWidths[column], placeable.width)
            columnHeights[column] += placeable.height
        }

        // Calculate the width and height of the layout
        val width = columnWidths.sumOf { it }
        val height = columnHeights.maxOrNull() ?: constraints.minHeight

        // Layout the children
        layout(width, height) {
            val columnX = IntArray(columns) { 0 }
            val columnY = IntArray(columns) { 0 }

            placeables.forEachIndexed { index, placeable ->
                val column = index % columns
                placeable.placeRelative(x = columnX[column], y = columnY[column])
                columnX[column] += placeable.width
                columnY[column] += placeable.height
            }
        }
    }
}
@Composable
fun StaggeredGridExample() {
    StaggeredGridLayout(columns = 2) {
        for (i in 1..10) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color.Gray)
            )
        }
    }
}






