package com.example.hockeyapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.ItemTournamentBinding
import com.example.hockeyapp.domain.pojo.TournamentInfo
import com.squareup.picasso.Picasso

class TournamentAdapter : RecyclerView.Adapter<TournamentAdapter.TournamentViewHolder>() {
    inner class TournamentViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val binding = ItemTournamentBinding.bind(itemView)
        val positiont = binding.textViewTournamentPosition
        val image = binding.imageViewTournamentImage
        val name = binding.textViewTournamentName
        val n = binding.textViewTournamentN
        val b = binding.textViewTournamentB
        val bo = binding.textViewTournamentBO
        val bb = binding.textViewTournamentBb
        val pb = binding.textViewTournamentPb
        val po = binding.textViewTournamentPO
        val p = binding.textViewTournamentP
        val sh = binding.textViewTournamentSH
        val scores = binding.textViewTournamentScores
    }

    var list = listOf<TournamentInfo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentViewHolder {
        return TournamentViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tournament,parent,false))
    }

    override fun onBindViewHolder(holder: TournamentViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            positiont.text = item.position.toString()
            Picasso.get().load(item.image).into(image)
            name.text = item.name
            n.text = item.n
            b.text = item.b
            bo.text = item.bo
            bb.text = item.bb
            pb.text = item.pb
            po.text = item.po
            p.text = item.p
            sh.text = item.sh
            scores.text = item.scores
        }
    }

    override fun getItemCount() = list.size
}