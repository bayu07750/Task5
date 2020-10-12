package com.example.tugas5.ui.address

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas5.databinding.FragmentAddressBinding
import com.example.tugas5.viewmodel.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class AddressFragment : Fragment() {

    private lateinit var binding: FragmentAddressBinding
    private lateinit var mViewModel: AddressViewModel
    private lateinit var mAdapter: AddressAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = ViewModelFactory.getInstance(requireContext())
        mViewModel = ViewModelProvider(this, viewModelFactory)[AddressViewModel::class.java]
        mAdapter = AddressAdapter()

        binding.buttonBack.setOnClickListener { findNavController().navigateUp() }

        setRecyclerView()
        setData()

        binding.buttonSubmit.setOnClickListener {
            if (binding.editAddress.text.toString().isEmpty()) {
                // ubah sama yang layout invoice
                Toast.makeText(requireContext(), "alamat tidak boleh kosong", Toast.LENGTH_SHORT)
                    .show()
            } else {
                binding.editAddress.error = null
                val action = AddressFragmentDirections.actionAddressFragmentToInvoiceFragment(
                    getCurrentDate(), binding.editAddress.text.toString()
                )
                findNavController().navigate(action)
            }
        }
    }


    private fun getCurrentDate(): String {
        // 3 sep 2018
        val date = Date()
        val simpleDateFormat = SimpleDateFormat("d MMM yyyy", Locale.getDefault())

        return simpleDateFormat.format(date)
    }

    private fun setData() {
        mViewModel.getDataListPayment().observe(viewLifecycleOwner, { list ->
            if (list.isNotEmpty()) {
                mAdapter.setData(list)
            }
        })
    }

    private fun setRecyclerView() {
        with (binding.recyclerViewPembayaran) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }
}