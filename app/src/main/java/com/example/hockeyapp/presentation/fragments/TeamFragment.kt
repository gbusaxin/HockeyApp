package com.example.hockeyapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.FragmentTeamBinding
import com.example.hockeyapp.presentation.HockeyViewModel
import com.example.hockeyapp.presentation.adapters.TeamAdapter


class TeamFragment : Fragment() {

    private lateinit var adapter:TeamAdapter
    private lateinit var viewModel: HockeyViewModel
    private lateinit var binding: FragmentTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        adapter = TeamAdapter()
        viewModel = ViewModelProvider(this)[HockeyViewModel::class.java]

        binding = FragmentTeamBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvTeam = binding.rvTeam
        viewModel.teamInfoList.observe(viewLifecycleOwner,{
            adapter.list = it
            rvTeam.adapter = adapter
        })
    }

}