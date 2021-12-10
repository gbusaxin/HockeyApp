package com.example.hockeyapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.ItemResultBinding
import com.example.hockeyapp.domain.pojo.ResultInfo

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>(){
    inner class ResultViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val binding = ItemResultBinding.bind(itemView)
        val teams = binding.textViewResultTeams
        val date = binding.textViewResultDate
        val result = binding.textViewResultResult
    }

    var list = listOf<ResultInfo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result,parent,false))
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            teams.text = item.teams
            date.text = item.date
            result.text = item.result
        }
    }

    override fun getItemCount() = list.size
}