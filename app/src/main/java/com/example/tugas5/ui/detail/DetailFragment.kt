package com.example.tugas5.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tugas5.R
import com.example.tugas5.data.db.Cart
import com.example.tugas5.databinding.FragmentDetailBinding
import com.example.tugas5.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_cart.*

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var mViewModel: DetailViewModel

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = ViewModelFactory.getInstance(requireContext())
        mViewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]

        binding.buttonBack.setOnClickListener { findNavController().navigateUp() }

        val movie = args.movie
        binding.movie = movie

        binding.buttonBuy.setOnClickListener {
            val cart = movie.title?.let { it1 ->
                Cart(
                    id = 0,
                    image = movie.getPoster(),
                    title = it1,
                    price = 46000,
                    pts = 1
                )
            }

            if (cart != null) {
                mViewModel.addCart(cart)
                findNavController().navigate(R.id.action_detailFragment_to_cartFragment)
            }
        }
    }
}