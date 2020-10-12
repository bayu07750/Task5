package com.example.tugas5.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tugas5.databinding.FragmentProductBinding
import com.example.tugas5.model.Movie
import com.example.tugas5.viewmodel.ViewModelFactory

class ProductFragment : Fragment(), ProductAdapter.OnItemClickCallback {

    private lateinit var binding: FragmentProductBinding
    private lateinit var mViewModel: ProductViewModel
    private lateinit var mAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener { findNavController().navigateUp() }

        val viewModelFactory = ViewModelFactory.getInstance(requireContext())
        mViewModel = ViewModelProvider(this, viewModelFactory)[ProductViewModel::class.java]
        mAdapter = ProductAdapter()

        binding.progressBar.visibility = View.VISIBLE
        binding.constraintError.visibility = View.GONE
        binding.recyclerViewProduct.visibility = View.GONE

        setRecyclerView()
        setData()

        binding.constraintError.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            binding.constraintError.visibility = View.GONE
            binding.recyclerViewProduct.visibility = View.GONE
            setData()
        }
    }

    private fun setData() {
        mViewModel.getDataListMovies().observe(viewLifecycleOwner, { apiResponse ->
            if (apiResponse == null) {
                binding.progressBar.visibility = View.GONE
                binding.recyclerViewProduct.visibility = View.GONE
                binding.constraintError.visibility = View.VISIBLE
                return@observe
            }
            if (apiResponse.error == null) {
                apiResponse.listMovies?.let { mAdapter.setData(it) }
                binding.progressBar.visibility = View.GONE
                binding.constraintError.visibility = View.GONE
                binding.recyclerViewProduct.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
                binding.recyclerViewProduct.visibility = View.GONE
                binding.constraintError.visibility = View.VISIBLE
            }
        })
    }

    private fun setRecyclerView() {
        with (binding.recyclerViewProduct) {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter = mAdapter
        }
        mAdapter.setOnItemClickCallback(this)
    }

    override fun onItemClicked(movie: Movie) {
        val action = ProductFragmentDirections.actionProductFragmentToDetailFragment(movie)
        findNavController().navigate(action)
    }
}