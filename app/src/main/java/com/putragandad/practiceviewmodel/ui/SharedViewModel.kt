package com.putragandad.practiceviewmodel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.putragandad.practiceviewmodel.models.Note

class SharedViewModel: ViewModel() {
    private val _data = MutableLiveData<ArrayList<Note>>() //declare _data as MutableLiveData with Item data class return type

    // data variable below will get any changes in the _data variable, in a non blocking way
    val data : LiveData<ArrayList<Note>>
        get() = _data

    fun addData(value: Note) {
        _data.value?.add(value)
    }
}