package com.tw.chuxing.transportation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tw.chuxing.R
import com.tw.chuxing.databinding.FragmentHomeBinding
import com.tw.chuxing.transportation.viewmodel.HomeViewModel
import kotlin.math.sign

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.confirm.setOnClickListener {
            viewModel.fetchProposals(binding.destination.text.toString())
        }
        initObserver()
    }

    private fun initObserver() {
        viewModel.proposals.observe(requireActivity(), {
            if (it.isEmpty()) {
                Toast.makeText(requireContext(), R.string.unavailable_proposal, Toast.LENGTH_SHORT).show()
            } else {
                binding.departLayout.visibility = View.GONE
                binding.destinationLayout.visibility = View.GONE
                binding.confirm.visibility = View.GONE
                binding.recycler.layoutManager = LinearLayoutManager(requireContext())
                binding.recycler.adapter = ProposalsAdapter(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}