package com.putragandad.practiceviewmodel.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.putragandad.practiceviewmodel.models.Item

class SharedViewModel: ViewModel() {
    private val _data = MutableLiveData<ArrayList<Item>>() //declare _data as MutableLiveData with Item data class return type

    // data variable below will get any changes in the _data variable, in a non blocking way
    val data : LiveData<ArrayList<Item>>
        get() = _data

    fun addData(value: Item) {
        _data.value?.add(value)
    }
}