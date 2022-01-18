package com.example.viewmodeltwofragments_jan10.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeltwofragments_jan10.databinding.FragmentButtonBinding
import com.example.viewmodeltwofragments_jan10.ui.viewmodel.UserViewModel

class ButtonFragment: Fragment() {

    private var _binding: FragmentButtonBinding? = null
    private val binding: FragmentButtonBinding get() = _binding!!

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentButtonBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]
        with(binding) {
            countBtn.setOnClickListener {
                viewModel.addName()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}