package com.example.realtimeweather.api

import androidx.core.app.NotificationCompat.MessagingStyle.Message

// T refers to weather mode
sealed class NetworkResponse<out T> {
    data class Success<out T>(val data:T):NetworkResponse<T>()
    data class Error(val message: String) : NetworkResponse<Nothing>()
    object Loading : NetworkResponse<Nothing>()
}