package com.example.covidstatetracker.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.covidstatetracker.models.CoVidStateItem
import com.example.covidstatetracker.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private var apiClient: ApiClient) {
    val statesResponse : MutableLiveData<List<CoVidStateItem>> = MutableLiveData()

    fun getCovidStates(): MutableLiveData<List<CoVidStateItem>>{
        apiClient.getApiInterface().getStateData()
            .enqueue(object : Callback<List<CoVidStateItem>>{
                override fun onFailure(call: Call<List<CoVidStateItem>>, t: Throwable) {
                    Log.i("repo",t.message)
                }

                override fun onResponse(
                    call: Call<List<CoVidStateItem>>,
                    response: Response<List<CoVidStateItem>>
                ) {
                    statesResponse.value = response.body()
                    Log.i("repo",response.body().toString())
                }

            })
        return statesResponse
    }
}