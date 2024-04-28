package com.putragandad.practiceviewmodel.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.putragandad.practiceviewmodel.models.Note

class SharedViewModel: ViewModel() {
    private val _data = MutableLiveData<ArrayList<Note>>() //declare _data as MutableLiveData with Item data class return type

    // data variable below will get any changes in the _data variable, in a non blocking way
//    val data : LiveData<ArrayList<Note>>
//        get() = _data
    val data : LiveData<ArrayList<Note>>
        get() = _data

    fun addData(value: Note) {
        /*
            Check condition :
            If _data hasn't been initialized yet with arrayList, initialize it
            and then afterwards add the item (in this case it's named value) to the arrayList

            Or, if _data is already initialized by arrayList, retrieve the
            arrayList and add the value to the arrayList
         */
        val list = _data.value ?: arrayListOf<Note>()
        list.add(value)
        _data.value = list
    }
}