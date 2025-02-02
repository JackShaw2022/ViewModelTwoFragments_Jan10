package com.example.viewmodeltwofragments_jan10.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeltwofragments_jan10.databinding.FragmentReviewBinding
import com.example.viewmodeltwofragments_jan10.ui.viewmodel.UserViewModel

class UserFragment : Fragment() {

    private var _binding: FragmentReviewBinding? = null
    private val binding: FragmentReviewBinding get() = _binding!!

    // lateinit because value will be assigned later
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Initialize ViewModel in onViewCreated()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Creating ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        with(binding) {
            viewModel.firstName.observe(viewLifecycleOwner) { firstName ->
                firstNameTv.text = firstName.toString()
            }
            viewModel.lastName.observe(viewLifecycleOwner) { lastName ->
               lastNameTv.text = lastName.toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}