package com.example.reservoirapps.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.reservoirapps.adapter.ReservoirAdapter
import com.example.reservoirapps.databinding.FragmentHomeBinding
import com.example.reservoirapps.viewmodel.ReservoirViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel:ReservoirViewModel by viewModels()
    private lateinit var reservoirAdapter: ReservoirAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRv()
    }

    private fun setUpRv() {

        reservoirAdapter = ReservoirAdapter()

       binding.recyclerView.apply {
           layoutManager = GridLayoutManager(requireContext(), 2)
           setHasFixedSize(true)
           adapter = reservoirAdapter
       }


        viewModel.reservoirResponse.observe(requireActivity(),{
            response ->
            reservoirAdapter.reservoir = response.responseData
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }
}