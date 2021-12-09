package com.example.hockeyapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.FragmentTournamentBinding
import com.example.hockeyapp.presentation.HockeyViewModel
import com.example.hockeyapp.presentation.adapters.TournamentAdapter


class TournamentFragment : Fragment() {

    private lateinit var viewModel: HockeyViewModel
    private lateinit var binding:FragmentTournamentBinding
    private lateinit var adapter: TournamentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTournamentBinding.inflate(inflater,container,false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[HockeyViewModel::class.java]
        adapter = TournamentAdapter()
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvTournament = binding.rvTournament
        viewModel.tournamentInfoList.observe(viewLifecycleOwner,{
            adapter.list = it
            rvTournament.adapter = adapter
        })
    }

}