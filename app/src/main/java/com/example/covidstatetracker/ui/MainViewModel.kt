package com.example.covidstatetracker.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covidstatetracker.models.CoVidStateItem

class MainViewModel(private val repository: MainRepository) : ViewModel(){

     fun getData(): MutableLiveData<List<CoVidStateItem>> = repository.getCovidStates()
}