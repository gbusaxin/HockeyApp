package com.example.hockeyapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.FragmentNewsBinding
import com.example.hockeyapp.presentation.HockeyViewModel
import com.example.hockeyapp.presentation.adapters.NewsAdapter


class NewsFragment : Fragment() {

    private lateinit var binding:FragmentNewsBinding
    private lateinit var adapter:NewsAdapter
    private lateinit var viewModel: HockeyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[HockeyViewModel::class.java]
        adapter = NewsAdapter()
        val root = binding.root
        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.newsInfoList.observe(viewLifecycleOwner,{
            adapter.list = it
            binding.rvNews.adapter = adapter
        })
    }

}