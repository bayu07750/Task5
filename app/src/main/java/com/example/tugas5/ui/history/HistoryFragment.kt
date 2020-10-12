package com.example.tugas5.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas5.databinding.FragmentHistoryBinding
import com.example.tugas5.viewmodel.ViewModelFactory

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var mAdapter: HistoryAdapter
    private lateinit var mViewModel: HistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = HistoryAdapter()
        val viewModelFactory = ViewModelFactory.getInstance(requireContext())
        mViewModel = ViewModelProvider(this, viewModelFactory)[HistoryViewModel::class.java]

        binding.buttonBack.setOnClickListener { findNavController().navigateUp() }

        mViewModel.setDataHistory()

        setRecyclerView()
        setData()
    }

    private fun setData() {
        mViewModel.getDataHistory().observe(viewLifecycleOwner, { listHistory ->
            mAdapter.setData(listHistory)
        })
    }

    private fun setRecyclerView() {
        with (binding.recyclerViewHistory) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }
}