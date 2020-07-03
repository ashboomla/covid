package com.example.covidstatetracker.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidstatetracker.R
import com.example.covidstatetracker.models.CoVidStateItem
import com.example.covidstatetracker.network.ApiClient
import com.example.covidstatetracker.ui.MainRepository
import com.example.covidstatetracker.ui.MainViewModel
import com.example.covidstatetracker.ui.MainViewModelFactory
import com.example.covidstatetracker.ui.adapters.StateAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var factory: MainViewModelFactory
    lateinit var adapter: StateAdapter
    lateinit var listo : List<CoVidStateItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MainRepository(ApiClient())
        factory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)

        recycler_view_state.layoutManager = LinearLayoutManager(this)

        coR()

    }

    fun coR() {
        CoroutineScope(Main).launch{
            viewModel.getData().observe(this@MainActivity,Observer { list ->
                Log.i("aaa",list.toString())
                listo = list
                adapter = StateAdapter(list)

                recycler_view_state.adapter = adapter

            })
//            withContext(Main){
//                adapter = StateAdapter(listo)
//
//                recycler_view_state.adapter = adapter
//            }
        }
    }
}
