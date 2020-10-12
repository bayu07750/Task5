package com.example.tugas5.ui.forget

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tugas5.R
import com.example.tugas5.databinding.FragmentForgetPasswordBinding
import com.example.tugas5.utils.validateEmail

class ForgetPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgetPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext())
            .load(R.drawable.kodepedia_logo)
            .into(binding.imageLogo)

        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        binding.buttonSendPassword.setOnClickListener {
            if (validateEmail(binding.textInputEmail, requireContext())) {
                Toast.makeText(requireContext(), "Send Password Successfully", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
        }
    }
}