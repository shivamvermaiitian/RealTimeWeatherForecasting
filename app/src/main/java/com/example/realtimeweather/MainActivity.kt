package com.example.realtimeweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.realtimeweather.ui.theme.FlowRow
import com.example.realtimeweather.ui.theme.RealTimeWeatherTheme
import com.example.realtimeweather.ui.theme.StaggeredGridExample
import com.example.realtimeweather.ui.theme.TestingScreen
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        enableEdgeToEdge()
        setContent {
//            TestingScreen()
//            MyScreen()

            FlowRow {
                repeat(122){
                    Box(
                        modifier = Modifier
                            .width(Random.nextInt(10, 150).dp)
                            .height(80.dp)
                            .background(Color(Random.nextLong(0xFFFFFFFF)))
                    ) {

                    }
                }
            }
//            RealTimeWeatherTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
////                    StaggeredGridExample()
////                    MyCustomLayoutScreen()
////                    LazyColumnScreen()
////                    LazyColumnGrid()
////                    RowColumnScreen()
////                    LazyRowColumnScreen()
////                    WeatherPage(weatherViewModel)
//                }
//            }
        }
    }
}


