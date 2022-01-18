package com.example.viewmodeltwofragments_jan10.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeltwofragments_jan10.databinding.FragmentEntryBinding
import com.example.viewmodeltwofragments_jan10.ui.dataclass.UserDataClass
import com.example.viewmodeltwofragments_jan10.ui.viewmodel.UserViewModel

class EntryFragment: Fragment() {

    private var _binding: FragmentEntryBinding? = null
    private val binding: FragmentEntryBinding get() = _binding!!

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEntryBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]
        with(binding) {
            submitBtn.setOnClickListener {
                val firstNameStr = firstNameEt.text.toString()
                val lastNameStr = lastNameEt.text.toString()
               viewModel.addName(UserDataClass(firstNameStr, lastNameStr))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}