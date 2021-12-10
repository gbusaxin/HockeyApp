package com.example.hockeyapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.FragmentResultBinding
import com.example.hockeyapp.presentation.HockeyViewModel
import com.example.hockeyapp.presentation.adapters.ResultAdapter


class ResultFragment : Fragment() {

    private lateinit var adapter:ResultAdapter
    private lateinit var viewModel:HockeyViewModel
    private lateinit var binding:FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater,container,false)
        val view = binding.root
        adapter = ResultAdapter()
        viewModel = ViewModelProvider(this)[HockeyViewModel::class.java]
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvResult = binding.rvResult
        viewModel.resultInfoList.observe(viewLifecycleOwner,{
            adapter.list = it
            rvResult.adapter = adapter
        })
    }

}