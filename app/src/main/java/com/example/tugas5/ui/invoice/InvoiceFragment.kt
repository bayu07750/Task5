package com.example.tugas5.ui.invoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas5.R
import com.example.tugas5.data.db.Cart
import com.example.tugas5.databinding.FragmentInvoiceBinding
import com.example.tugas5.ui.cart.CartAdapter
import com.example.tugas5.viewmodel.ViewModelFactory
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class InvoiceFragment : Fragment() {

    private lateinit var binding: FragmentInvoiceBinding
    private lateinit var mAdapter: CartAdapter
    private lateinit var mViewModel: InvoiceViewModel

    private val args: InvoiceFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInvoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = ViewModelFactory.getInstance(requireContext())
        mViewModel = ViewModelProvider(this, viewModelFactory)[InvoiceViewModel::class.java]
        mAdapter = CartAdapter()

        binding.buttonBack.setOnClickListener { findNavController().navigateUp() }

        binding.textAddress.text = args.address
        binding.textDate.text = args.currentDate

        setRecyclerView()
        setData()
    }

    private fun setData() {
        mViewModel.readCart.observe(viewLifecycleOwner, { list ->
            if (list.isNotEmpty()) {
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
        with (binding.recyclerViewInvoice) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }
}