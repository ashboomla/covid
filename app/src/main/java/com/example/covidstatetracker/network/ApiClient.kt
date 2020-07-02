package com.example.covidstatetracker.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient {
    fun getApiInterface(): ApiInterface = _api


    companion object {

        val _api by lazy {
            Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }

    }

}
