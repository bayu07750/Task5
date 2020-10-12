package com.example.tugas5.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tugas5.R
import com.example.tugas5.databinding.FragmentRegisterBinding
import com.example.tugas5.utils.validateEmail
import com.example.tugas5.utils.validateOther
import com.example.tugas5.utils.validatePassword
import com.example.tugas5.utils.validateRetypePassword

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext())
            .load(R.drawable.kodepedia_logo)
            .into(binding.imageLogo)

        binding.buttonLogin.setOnClickListener { findNavController().navigateUp() }

        binding.buttonRegister.setOnClickListener {
            if (validateOther(binding.textInputFullName, requireContext()) &&
                    validateEmail(binding.textInputEmail, requireContext()) &&
                    validatePassword(binding.textInputPassword, requireContext()) &&
                    validatePassword(binding.textInputRetypePassword, requireContext()) &&
                    validateRetypePassword(binding.textInputPassword, binding.textInputRetypePassword, requireContext())) {
                Toast.makeText(requireContext(), "Register Successfully", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
        }
    }
}