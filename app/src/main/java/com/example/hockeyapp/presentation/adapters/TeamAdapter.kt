package com.example.hockeyapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.ItemTeamBinding
import com.example.hockeyapp.domain.pojo.TeamInfo
import com.squareup.picasso.Picasso

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {
    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemTeamBinding.bind(itemView)
        val name = binding.textViewTeamName
        val image = binding.imageViewTeam
        val imageCity = binding.imageViewTeamCity
        val city = binding.textViewTeamCity
        val founded = binding.textViewTeamFounded
        val usernames = binding.textViewTeamUsername
        val venue = binding.textViewTeamVenue
        val trainer = binding.textViewTeamTrainer
        val captain = binding.textViewTeamCaptain
    }

    var list = listOf<TeamInfo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_team, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            name.text = item.name
            Picasso.get().load(item.image).into(image)
            Picasso.get().load(item.countryImage).into(imageCity)
            city.text = item.city
            founded.text = item.founded
            usernames.text = item.usernames
            venue.text = item.venue
            trainer.text = item.trainer
            captain.text = item.captain
        }
    }

    override fun getItemCount() = list.size
}