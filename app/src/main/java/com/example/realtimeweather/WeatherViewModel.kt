package com.example.realtimeweather

import android.net.Network
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realtimeweather.api.Constant
import com.example.realtimeweather.api.NetworkResponse
import com.example.realtimeweather.api.Retrofitinstance
import com.example.realtimeweather.api.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherApi=Retrofitinstance.weatherApi
    private val _weatherResult=MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult: LiveData<NetworkResponse<WeatherModel>> = _weatherResult


    fun getData(city : String){
        _weatherResult.value=NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response=weatherApi.getWeather(Constant.apiKey,city)
                if (response.isSuccessful){
                    response.body()?.let {
                        _weatherResult.value=NetworkResponse.Success(it)
                    }
                }else{
                    _weatherResult.value=NetworkResponse.Error("Failed to load data")
                }
            }
            catch (e:Exception){
                _weatherResult.value=NetworkResponse.Error("Failed to load data")
            }
        }
//        viewModelScope.launch {
//            val response=weatherApi.getWeather(Constant.apiKey,city)
//            if (response.isSuccessful){
//                Log.i("Response : ",response.body().toString())
//            }else{
//                Log.i("Error : ",response.message())
//            }
//        }

//        Log.i("City name",city)
    }




}