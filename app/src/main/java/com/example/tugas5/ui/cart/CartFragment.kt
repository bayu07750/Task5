package com.example.tugas5.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas5.R
import com.example.tugas5.data.db.Cart
import com.example.tugas5.databinding.FragmentCartBinding
import com.example.tugas5.viewmodel.ViewModelFactory
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var mAdapter: CartAdapter
    private lateinit var mViewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = CartAdapter()
        val viewModelFactory = ViewModelFactory.getInstance(requireContext())
        mViewModel = ViewModelProvider(this, viewModelFactory)[CartViewModel::class.java]

        binding.buttonBack.setOnClickListener { findNavController().navigateUp() }

        setRecyclerView()
        setData()

        binding.buttonCheckout.setOnClickListener {
            findNavController().navigate(R.id.action_cartFragment_to_addressFragment)
        }
    }

    private fun setData() {
        mViewModel.readCart.observe(viewLifecycleOwner, { list ->
            if (list.isEmpty()) {
                binding.nestedScroll.visibility = View.GONE
                binding.constraintEmpty.visibility = View.VISIBLE
            } else {
                binding.nestedScroll.visibility = View.VISIBLE
                binding.constraintEmpty.visibility = View.GONE
                mAdapter.setData(list)

                setTotalPrice(list)
            }
        })
    }

    private fun setTotalPrice(list: List<Cart>?) {
        if (list != null) {
            var totalPrice = 0
            for (cart in list) {
                totalPrice += cart.price
            }

            (DecimalFormat.getCurrencyInstance() as DecimalFormat).also { kursIndo ->
                DecimalFormatSymbols().also { formatRp ->
                    formatRp.currencySymbol = "Rp "
                    formatRp.groupingSeparator = '.'
                    kursIndo.decimalFormatSymbols = formatRp
                }
                binding.textTotalPrice.text = resources.getString(R.string.totalPrice, kursIndo.format(totalPrice))
            }
        }
    }

    private fun setRecyclerView() {
        with (binding.recyclerViewCart) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }
}