package com.example.covidstatetracker.network

import com.example.covidstatetracker.models.CoVidStateItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("states/current.json")
   fun getStateData(): Call<List<CoVidStateItem>>

    fun getStateDATA(): Call<List<CoVidStateItem>>
}