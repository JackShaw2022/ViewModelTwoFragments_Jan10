package com.example.viewmodeltwofragments_jan10.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodeltwofragments_jan10.ui.dataclass.UserDataClass

// Lives through orientation changes
// holds data and ui logic
// Can share data between fragments
// VM part of MVVM
class CounterViewModel: ViewModel() {

    private var _firstName: MutableLiveData<String> = MutableLiveData("")
    val firstName: LiveData<String> get() = _firstName

    private var _lastName: MutableLiveData<String> = MutableLiveData("")
    val lastName: LiveData<String> get() = _lastName

    fun addName() {
        var name = UserDataClass("Jon", "Kelly")
        // Grabbing current value of live data
        val currentFirstName: String? = firstName.value
        val currentLastName: String? = lastName.value

        // Updating MutableLiveData with new value
        _firstName.value = currentFirstName?.plus(name.firstName)
        _lastName.value = currentLastName?.plus(name.lastName)
    }
}