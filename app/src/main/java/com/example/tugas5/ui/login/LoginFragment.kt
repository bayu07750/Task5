package com.example.tugas5.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tugas5.R
import com.example.tugas5.databinding.FragmentLoginBinding
import com.example.tugas5.utils.validateEmail
import com.example.tugas5.utils.validatePassword

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext())
            .load(R.drawable.kodepedia_logo)
            .into(binding.imageLogo)

        binding.buttonLogin.setOnClickListener {
            if (validateEmail(binding.textInputEmail, requireContext()) && validatePassword(binding.textInputPassword, requireContext())) {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
        binding.buttonRegister.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_registerFragment) }
        binding.textForgotPassword.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_forgetPasswordFragment) }
    }
}