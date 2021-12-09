package com.example.hockeyapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.ItemNewsBinding
import com.example.hockeyapp.domain.pojo.NewsInfo

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val binding = ItemNewsBinding.bind(itemView)
        val title = binding.textViewItemTitle
        val date = binding.textViewItemDate
        val body = binding.textViewItemBody
    }

    var list = listOf<NewsInfo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news,parent,false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            title.text = item.title
            date.text = item.date
            body.text = item.body
        }
    }

    override fun getItemCount() = list.size
}