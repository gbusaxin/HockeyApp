package com.example.hockeyapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.FragmentFixturesBinding
import com.example.hockeyapp.presentation.HockeyViewModel
import com.example.hockeyapp.presentation.adapters.ResultAdapter


class FixturesFragment : Fragment() {

    private lateinit var adapter: ResultAdapter
    private lateinit var viewModel: HockeyViewModel
    private lateinit var binding: FragmentFixturesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = ResultAdapter()
        viewModel = ViewModelProvider(this)[HockeyViewModel::class.java]
        binding = FragmentFixturesBinding.inflate(inflater,container,false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvFix = binding.rvFixtures
        viewModel.fixturesInfoList.observe(viewLifecycleOwner,{
            adapter.list = it
            rvFix.adapter = adapter
        })
    }
}