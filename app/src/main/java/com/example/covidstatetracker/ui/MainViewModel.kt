package com.example.covidstatetracker.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covidstatetracker.models.CoVidStateItem
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : ViewModel(){

   suspend fun getData(): MutableLiveData<List<CoVidStateItem>> =
       withContext(IO){
           repository.getCovidStates()
       }
}