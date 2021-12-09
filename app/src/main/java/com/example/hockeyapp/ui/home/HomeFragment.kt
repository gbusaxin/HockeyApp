package com.example.hockeyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.FragmentHomeBinding
import com.example.hockeyapp.presentation.adapters.MyViewPagerAdapter
import com.example.hockeyapp.presentation.fragments.NewsFragment
import com.example.hockeyapp.presentation.fragments.TournamentFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter : MyViewPagerAdapter

    private lateinit var newsFragment: NewsFragment
    private lateinit var tournamentFragment: TournamentFragment

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsFragment = NewsFragment()
        tournamentFragment = TournamentFragment()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val support = requireActivity().supportFragmentManager
        val viewPager = _binding?.viewPager
        val tabs = _binding?.tabs
        adapter = MyViewPagerAdapter(support)

        adapter.addFragment(newsFragment,"НОВОСТИ")
        adapter.addFragment(tournamentFragment,"ТУРНИР")

        viewPager?.adapter = adapter
        tabs?.setupWithViewPager(viewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}