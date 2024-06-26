package com.example.realtimeweather.ui.theme

import android.graphics.Paint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.realtimeweather.WeatherViewModel
import com.example.realtimeweather.api.NetworkResponse
import com.example.realtimeweather.api.WeatherModel


@Composable
fun WeatherPage(viewModel: WeatherViewModel){
    var city by remember {
        mutableStateOf("")
    }
    var weatherResult=viewModel.weatherResult.observeAsState()
    val keyboardController= LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value =city , onValueChange = {
                city=it
            }, label = {
                Text(text = "Search for any Location")
            }
            )
            IconButton(onClick = {
            viewModel.getData(city)
                keyboardController?.hide()
             }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search for any Location")
            }
//            OutlinedTextField(value = city, onValueChange = {
//                city=it
//            }, label = {
//                Text(text ="Email or ID",fontSize = 18.sp)
//            }, modifier = Modifier
//                .fillMaxWidth()
//                .padding(
//                    start = 20.dp,
//                    end = 20.dp
//                )
//                .size(
//                    width = 250.dp,
//                    height = 70.dp
//                ),
//                shape = RoundedCornerShape(36.dp),colors = TextFieldDefaults.colors()
//            )
//            Spacer(modifier = Modifier.height(20.dp))






        }
        when(val result=weatherResult.value){
            is NetworkResponse.Error -> {
                Text(text = result.message)
            }
            NetworkResponse.Loading -> {
                CircularProgressIndicator()
            }
            is NetworkResponse.Success -> {
                WeatherDetails(data = result.data)
            }
            null -> {}
        }
    }
}
//
//
//testing

@Composable
fun WeatherDetails(data : WeatherModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Loaction icon",
            modifier=Modifier.size(40.dp))
        }
        Text(text = data.location.name, fontSize = 30.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = data.location.country, fontSize = 18.sp, color = Color.Gray)

    }
    Spacer(modifier = Modifier.height(16.dp))
//    Text(
//        text = "${data.current.temp_c}°C",
//        fontSize = 56.dp,
//        fontWeight = FontWeight.Bold,
//        textAlign = TextAlign.Center
//    )
    Text(
        text ="${data.current.temp_c}°C",
        fontSize = 56.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    AsyncImage(
        modifier = Modifier.size(160.dp),
        model = "https:${data.current.condition.icon}".replace("64x64","128x128"),
        contentDescription = "Condition icon"
    )
    Text(
        text ="${data.current.condition.text}°C",
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        color = Color.Gray
    )
    Spacer(modifier = Modifier.height(16.dp))
    Card {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                WeatherKeyval("Humidity",data.current.humidity)
                WeatherKeyval("Wind Speed",data.current.wind_kph+" km/h")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                WeatherKeyval("UV",data.current.uv)
                WeatherKeyval("Precipitation",data.current.precip_mm+" mm")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                WeatherKeyval("Local Time",data.location.localtime.split(" ")[1])
                WeatherKeyval("Local Date",data.location.localtime.split(" ")[0])
            }
        }
    }

}
@Composable
fun WeatherKeyval(key:String,value:String){
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment =Alignment.CenterHorizontally

    ) {
        Text(text = value, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = key, fontWeight = FontWeight.SemiBold,color=Color.Gray)
    }

}



















