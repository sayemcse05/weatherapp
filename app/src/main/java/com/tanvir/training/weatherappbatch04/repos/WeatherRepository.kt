package com.tanvir.training.weatherappbatch04.repos

import android.location.Location
import com.tanvir.training.weatherappbatch04.NetworkService
import com.tanvir.training.weatherappbatch04.models.CurrentModel
import com.tanvir.training.weatherappbatch04.models.ForecastModel
import com.tanvir.training.weatherappbatch04.weather_api_key

class WeatherRepository {

    suspend fun fetchCurrentData(location: Location, status: Boolean): CurrentModel {
        val unit = if (status) "imperial" else "metric"
        val endUrl =
            "weather?lat=${location.latitude}&lon=${location.longitude}&units=$unit&appid=$weather_api_key"
        return NetworkService.weatherServiceApi
            .getCurrentWeather(endUrl)
    }

    suspend fun fetchForecastData(location: Location, status: Boolean): ForecastModel {
        val unit = if (status) "imperial" else "metric"
        val endUrl =
            "forecast?lat=${location.latitude}&lon=${location.longitude}&units=$unit&appid=$weather_api_key"
        return NetworkService.weatherServiceApi
            .getForecastWeather(endUrl)
    }
}