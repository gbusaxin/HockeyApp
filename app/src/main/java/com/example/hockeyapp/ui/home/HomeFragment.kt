package com.example.hockeyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hockeyapp.databinding.FragmentHomeBinding
import com.example.hockeyapp.presentation.adapters.MyViewPagerAdapter
import com.example.hockeyapp.presentation.fragments.FixturesFragment
import com.example.hockeyapp.presentation.fragments.ResultFragment
import com.example.hockeyapp.presentation.fragments.TeamFragment
import com.example.hockeyapp.presentation.fragments.TournamentFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: MyViewPagerAdapter

    private lateinit var tournamentFragment: TournamentFragment
    private lateinit var teamFragment: TeamFragment
    private lateinit var resultFragment: ResultFragment
    private lateinit var fixturesFragment: FixturesFragment

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tournamentFragment = TournamentFragment()
        teamFragment = TeamFragment()
        resultFragment = ResultFragment()
        fixturesFragment = FixturesFragment()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val viewPager = _binding?.viewPager
        val tabs = _binding?.tabs
        adapter = MyViewPagerAdapter(childFragmentManager)

        adapter.addFragment(tournamentFragment, "ТУРНИР")
        adapter.addFragment(teamFragment, "КОМАНДЫ")
        adapter.addFragment(resultFragment, "РЕЗУЛЬТАТЫ")
        adapter.addFragment(fixturesFragment,"БУДУЩИЕ")

        viewPager?.adapter = adapter
        tabs?.setupWithViewPager(viewPager)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}