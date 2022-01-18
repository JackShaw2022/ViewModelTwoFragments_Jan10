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

    private var _firstName: MutableLiveData<List<String>> = MutableLiveData()
    val firstName: LiveData<List<String>> get() = _firstName
    private val arrFirstName = ArrayList<String>()

    private var _lastName: MutableLiveData<List<String>> = MutableLiveData()
    val lastName: LiveData<List<String>> get() = _lastName
    private val arrLastName = ArrayList<String>()

    fun addName() {
        var name = UserDataClass("Jon", "Kelly")
        // Grabbing current value of live data
        val currentFirstName: String = name.firstName
        val currentLastName: String = name.lastName

        arrFirstName.add(currentFirstName)
        arrLastName.add(currentLastName)

        // Updating MutableLiveData with new value
        for(i in 0 until arrFirstName.size) {
            _firstName.value = arrFirstName
        }
        for(j in 0 until arrLastName.size){
            _lastName.value = arrLastName
        }
    }
}