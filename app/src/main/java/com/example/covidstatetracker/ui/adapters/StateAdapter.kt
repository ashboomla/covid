package com.example.covidstatetracker.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidstatetracker.R
import com.example.covidstatetracker.models.CoVidStateItem
import kotlinx.android.synthetic.main.row_adapter_state.view.*

class StateAdapter(val list: List<CoVidStateItem>) :
    RecyclerView.Adapter<StateAdapter.RowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_adapter_state, parent, false)
        return RowViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        var item = list[position]
        holder.bindItem(item)
    }

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: CoVidStateItem) {
            itemView.textView_State.text = item.state
            itemView.textView_Date.text = item.dateChecked
            itemView.textView_NOD.text = item.death.toString()

        }
    }

}