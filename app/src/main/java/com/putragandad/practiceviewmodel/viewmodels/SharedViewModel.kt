package com.putragandad.practiceviewmodel.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.putragandad.practiceviewmodel.models.Item

class SharedViewModel: ViewModel() {
    private val _data = MutableLiveData<Item>() //declare _data as MutableLiveData with Item data class return type

    // data variable below will get any changes in the _data variable, in a non blocking way
    val data : LiveData<Item>
        get() = _data

    // set data to the MutableLiveData
    fun setData(value: Item) {
        _data.value = value
    }

}