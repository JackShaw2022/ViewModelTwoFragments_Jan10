package com.example.viewmodeltwofragments_jan10.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Lives through orientation changes
// holds data and ui logic
// Can share data between fragments
// VM part of MVVM
class CounterViewModel: ViewModel() {

    private var _count: MutableLiveData<Int> = MutableLiveData(0)
    val count: LiveData<Int> get() = _count

    fun addCount() {
        // Grabbing current value of live data
        val currentCount: Int? = count.value

        // Updating MutableLiveData with new value
        _count.value = currentCount?.plus(1)
    }
}