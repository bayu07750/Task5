package com.example.tugas5.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas5.R
import com.example.tugas5.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), HomeAdapter.OnItemClickCallback {

    private lateinit var list: List<String>
    private lateinit var mAdapter: HomeAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = listOf("Product", "Account", "My Cart", "History", "Log out")
        mAdapter = HomeAdapter()

        setRecyclerView()
        setData()
    }

    private fun setData() {
        mAdapter.setData(list)
        mAdapter.setOnItemClickCallback(this)
    }

    private fun setRecyclerView() {
        with (binding.recyclerViewHome) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }

    override fun onItemClick(textMenu: String, position: Int) {
        when (position) {
            0 -> {
                findNavController().navigate(R.id.action_homeFragment_to_productFragment)
            }
            1 -> {
                findNavController().navigate(R.id.action_homeFragment_to_accountFragment)
            }
            2 -> {
                findNavController().navigate(R.id.action_homeFragment_to_cartFragment)
            }
            3 -> {
                findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
            }
            4 -> {}
        }
    }
}