package com.example.covidstatetracker.ui

import androidx.lifecycle.MutableLiveData
import com.example.covidstatetracker.models.CoVidStateItem
import com.example.covidstatetracker.network.ApiClient
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class MainRepository(private var apiClient: ApiClient) {
    var statesResponse : MutableLiveData<List<CoVidStateItem>> = MutableLiveData()
    lateinit var responseState : List<CoVidStateItem>

    suspend fun getCovidStates(): MutableLiveData<List<CoVidStateItem>> {
      withContext(IO){
          val call = apiClient.getApiInterface().getStateData()
              .execute()
          if (call.code() in 200..399){
              responseState = call.body()!!
                statesResponse = MutableLiveData(responseState)
          }
          else {responseState = emptyList()}
      }
        return statesResponse
    }
}